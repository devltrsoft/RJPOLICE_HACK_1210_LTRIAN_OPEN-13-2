package com.ltrsoft.police_app.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.police_app.Classes.Evidance;
import com.ltrsoft.police_app.Model.EvidanceDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddEvidence extends Fragment {

     static  String COMPLAIN_NAME_EBY_USER = "https://rj.ltr-soft.com/public/police_api/data/complaint_user_read.php";

    private String encodeImage;
    private Bitmap bitmap;
    private static final int PICK_VIDEO_REQUEST = 1;
    private ActivityResultLauncher<Intent> videoPickerLauncher;

    private ArrayList<String> listcomplain = new ArrayList<>();
    private ArrayList<String> listcomplainid = new ArrayList<>();

    private final int CAMERA_REQ_CODE = 102;
    private final int GALLERY_REQ_CODE = 103;
    private Button save,open_gallery,open_camera;
    private ImageView img;
    private VideoView video;
    private EditText Evidance_name,Evidance_despription;
    private Spinner complain_name;
    private ArrayAdapter adapter;
    private String cid;


    public AddEvidence() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          View view= inflater.inflate(R.layout.add_evidence, container, false);

        save = view.findViewById(R.id.save);
        open_camera = view.findViewById(R.id.open_camera);
        open_gallery = view.findViewById(R.id.open_gallery);
        img = view.findViewById(R.id.Evidance_photo);
        Evidance_despription = view.findViewById(R.id.description);
        Evidance_name = view.findViewById(R.id.evidance_name);
        video = view.findViewById(R.id.Evidance_video);
        complain_name = view.findViewById(R.id.ecomplain_name);

        complain_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cid=  listcomplainid.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                cid=  listcomplainid.get(0);
            }
        });

        String police_Id = "1";
        loadComplainNameByUser(police_Id);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String evidance_name =  Evidance_name.getText().toString().trim();
                final String evidance_desc =  Evidance_despription.getText().toString().trim();
                     final  String photo_path=encodeImage;
                     String  fir_id="1";
                EvidanceDeo evidanceDeo=new EvidanceDeo();
                evidanceDeo.createevidance(new Evidance(evidance_name, evidance_desc, photo_path, fir_id), getContext(), new Callback() {
                    @Override
                    public void onSuccess(Object obj) {
                        String success=(String) obj;
                        Toast.makeText(getContext(), ""+success, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onErro(String errro) {
                        Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();

                    }
                });
               // submit();
                // getFragmentManager().beginTransaction().replace(R.id.containermain, new Dashboard()).commit();
            }
        });

        open_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
        open_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });

   return view;
    }
    private void openGallery() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("Select")
                .setPositiveButton("Video", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        openVideoPicker();
                    }
                }).setNegativeButton("Photo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Positive button click
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent, GALLERY_REQ_CODE);

                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void openCamera() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("Select")
                .setPositiveButton("Video", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Positive button click
                        recordVideo();
                    }
                }).setNegativeButton("Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Positive button click
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, CAMERA_REQ_CODE);
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void recordVideo() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivityForResult(intent, 0); // Use any non-zero requestCode
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQ_CODE && resultCode == Activity.RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                bitmap = (Bitmap) extras.get("data");
                img.setImageBitmap(bitmap);
                encodeImage = encodeImage(bitmap);
            }
        } else if(requestCode == GALLERY_REQ_CODE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            Toast.makeText(getActivity(), "" + selectedImage, Toast.LENGTH_SHORT).show();
            InputStream inputStream = null;
            try {
                inputStream = getContext().getContentResolver().openInputStream(selectedImage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            bitmap = BitmapFactory.decodeStream(inputStream);
            // Display the selected image in ImageView
            img.setImageURI(selectedImage);
            encodeImage = encodeImage(bitmap);
        }
    }

    private String encodeImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes, Base64.NO_WRAP);
    }

    private Bitmap resizeBitmap(Bitmap originalBitmap, int maxWidth, int maxHeight) {
        int width = originalBitmap.getWidth();
        int height = originalBitmap.getHeight();
        float aspectRatio = (float) width / (float) height;

        if (width > maxWidth || height > maxHeight) {
            if (aspectRatio > 1) {
                width = maxWidth;
                height = (int) (width / aspectRatio);
            } else {
                height = maxHeight;
                width = (int) (height * aspectRatio);
            }
        }

        return Bitmap.createScaledBitmap(originalBitmap, width, height, true);
    }

    private void openVideoPicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_VIDEO_REQUEST);
    }

    private void playSelectedVideo(Uri videoUri) {
        video.setVideoURI(videoUri);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(video);
        video.setMediaController(mediaController);
        video.start();
    }

    private void displaySelectedVideo(Uri videoUri) {
        video.setVideoURI(videoUri);
        video.start();
    }
    private void loadComplainNameByUser(String police_id) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, COMPLAIN_NAME_EBY_USER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response.toString());
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String complaint_id = jsonObject.getString("complaint_id");
                                String complaint_subject = jsonObject.getString("complaint_subject");
                                listcomplainid.add(complaint_id);
                                listcomplain.add(complaint_subject);
                            }
                        } catch (JSONException e) {
                            System.out.println("error"+e.toString());
                            throw new RuntimeException(e);
                        }

//                        Toast.makeText(getContext(), "response = " + response.toString(), Toast.LENGTH_SHORT).show();
//                        Log.d("resonse", response.toString());


//                         listcomplain = new ArrayList<>();

                        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_expandable_list_item_1, listcomplain);
                        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                        complain_name.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("user_id", police_id );
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

}