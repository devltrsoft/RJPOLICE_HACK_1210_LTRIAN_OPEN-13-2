 package com.ltrsoft.police_app.fragment;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.Model.WitnessDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

 public class AddWitness extends Fragment {
     private final int CAMERA_REQ_CODE = 104;
     private final int GALLERY_REQ_CODE = 105;

     private Spinner complain_names;

     private EditText name,address,contact,dob,email,addhar;
     private RadioGroup gender;
     private RadioButton male,female;
     private Button save,upload;
     private Spinner country,state,district,city;
     private ImageView photo,back_image;

     public ArrayAdapter adapter,adapter2,adapter3,adapter4;
     private Bitmap bitmap;
     String encodeImage;
     private String cid;
     private ArrayList<String> listcomplain = new ArrayList<>();
     private ArrayList<String> listcomplainid = new ArrayList<>();
     private static  String COMPLAIN_NAME_EBY_USER = "https://rj.ltr-soft.com/public/police_api/data/complaint_user_read.php";

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.add_witness, container, false);
         name=view.findViewById(R.id.fname);
         address=view.findViewById(R.id.address);
         contact=view.findViewById(R.id.contact);
         dob=view.findViewById(R.id.dob);
         email=view.findViewById(R.id.email);
         addhar=view.findViewById(R.id.addhar);
         male=view.findViewById(R.id.male);
         female=view.findViewById(R.id.female);
         save=view.findViewById(R.id.save);
         upload=view.findViewById(R.id.upload);
         country=view.findViewById(R.id.country);
         state=view.findViewById(R.id.state);
         district=view.findViewById(R.id.district);
         city=view.findViewById(R.id.city);
         photo=view.findViewById(R.id.photo);
         gender=view.findViewById(R.id.gender);
          complain_names = view.findViewById(R.id.complain_name);

         complain_names.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

          dob.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 showDatePickerDialog();
             }
         });

         photo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

         upload.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openCamera();
             }
         });
         save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 final String name1 =  name.getText().toString().trim();
                 final String address1= address.getText().toString().trim();
                 final String country1 =  country.toString().trim();
                 final String state1 =  state.toString().trim();
                 final String district1 =  district.toString().trim();
                 final String city1 =  city.toString().trim();
                 final String email1 =  email.getText().toString().trim();
                 final String dob1 =  dob.getText().toString().trim();
                 final String mobile1 =  contact.getText().toString().trim();
                 final String addhar1 =  addhar.getText().toString().trim();
                 String gender = male.isChecked() ? "Male" : "Female";
                 WitnessDeo witnessDeo=new WitnessDeo();
                 witnessDeo.createwitness(new Witness(name1, address1, country1, state1, district1, city1, email1, dob1,
                         mobile1, addhar1, gender), getContext(), new Callback() {
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


                 //save();
//                Adding_complain_detail adding_complain_detail=new Adding_complain_detail();
//                getFragmentManager(). beginTransaction().replace(R.id.containers, adding_complain_detail  ).addToBackStack(null).commit();

             }
         });

     return view;
     }
     private void showDatePickerDialog() {

         Calendar calendar = Calendar.getInstance();
         int year = calendar.get(Calendar.YEAR);
         int month = calendar.get(Calendar.MONTH);
         int day = calendar.get(Calendar.DAY_OF_MONTH);

         DatePickerDialog datePickerDialog = new DatePickerDialog(
                 getContext(),
                 new DatePickerDialog.OnDateSetListener() {
                     @Override
                     public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                         // Handle the date selection or update the TextView
                         String dateOfBirth = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                         dob.setText(dateOfBirth);
                     }
                 },
                 year,
                 month,
                 day);

         // Show the date picker dialog
         datePickerDialog.show();
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
                 }
                 else {
                     Toast.makeText(getContext(), "please select the image", Toast.LENGTH_SHORT).show();

                 }
             }
         } else if(requestCode == GALLERY_REQ_CODE && resultCode == Activity.RESULT_OK && data != null) {
             Uri selectedImage = data.getData();
             Toast.makeText(getActivity(), ""+selectedImage, Toast.LENGTH_SHORT).show();
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
             bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
             byte[] bytes = byteArrayOutputStream.toByteArray();
             encodeImage = Base64.encodeToString(bytes, Base64.DEFAULT);
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
                         complain_names.setAdapter(adapter);
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