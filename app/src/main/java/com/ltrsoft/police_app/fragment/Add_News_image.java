package com.ltrsoft.police_app.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.police_app.Classes.News;
import com.ltrsoft.police_app.Model.NewsDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Add_News_image extends Fragment {

    private ImageView photo;
    private Button upload,save;
    private final int GALLERY_REQ_CODE = 105;
    private final int CAMERA_REQ_CODE = 104;
    private Bitmap bitmap;
    private String encodeImage;

    private static final String URL = " ";

    public Add_News_image() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.add__news_image, container, false);


        photo=view.findViewById(R.id.photo);
        upload=view.findViewById(R.id.upload);
        save=view.findViewById(R.id.save);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("   Add News Image ");
        }

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDeo newsDeo=new NewsDeo();
                int news_id=1;
                newsDeo.addnewsImage( news_id,encodeImage , getContext(),  new Callback() {
                    @Override
                    public void onSuccess(Object obj) {
                      String success=(String) obj;
                        //Toast.makeText(getContext(), ""+success, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onErro(String errro) {
                        //Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();

                    }
                });
                 News_page adding_complain_detail=new News_page();
                getFragmentManager(). beginTransaction().replace(R.id.container_main, adding_complain_detail  ).commit();

            }
        });



            return view;
    }




    private void openCamera() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("Select")
                .setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Positive button click
                        openGallery();
                    }
                }).setNegativeButton("Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Positive button click
                        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                            // Request CAMERA permission
                            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, CAMERA_REQ_CODE);
                        } else {
                            // CAMERA permission already granted, launch camera
                            launchCamera();
                        }
                    }


                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQ_CODE && resultCode == Activity.RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                bitmap = (Bitmap) extras.get("data");
                photo.setImageBitmap(bitmap);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                if (bitmap != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byte[] bytes = byteArrayOutputStream.toByteArray();
                    encodeImage = Base64.encodeToString(bytes, Base64.NO_WRAP);
                    //
                } else {
                  //  Toast.makeText(getContext(), "please select the image", Toast.LENGTH_SHORT).show();

                }
            }
        } else if (requestCode == GALLERY_REQ_CODE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
           // Toast.makeText(getActivity(), "" + selectedImage, Toast.LENGTH_SHORT).show();
            InputStream inputStream = null;
            try {
                inputStream = getContext().getContentResolver().openInputStream(selectedImage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            bitmap = BitmapFactory.decodeStream(inputStream);
            // Display the selected image in ImageView

            photo.setImageURI(selectedImage);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            encodeImage = Base64.encodeToString(bytes, Base64.DEFAULT);
//            Toast.makeText(getActivity(), ""+selectedImage, Toast.LENGTH_SHORT).show();
//            System.out.println(selectedImage);
//            try {
//                // Instead of setting the image directly, you need to handle the image loading
//                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), selectedImage);
//                // Now you can use the bitmap as needed, such as displaying in an ImageView
//                photo.setImageBitmap(bitmap);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//                Toast.makeText(getActivity(), "Failed to load image", Toast.LENGTH_SHORT).show();
//            }
        }
    }

    private void launchCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQ_CODE);
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY_REQ_CODE);
    }



}