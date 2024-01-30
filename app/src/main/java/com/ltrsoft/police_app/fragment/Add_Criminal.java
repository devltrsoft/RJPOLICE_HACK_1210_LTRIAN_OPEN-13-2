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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.police_app.Model.SpinnerDeo;
import com.ltrsoft.police_app.Classes.Criminal;
import com.ltrsoft.police_app.Model.CriminalDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class Add_Criminal extends Fragment {



    public Add_Criminal() {
        // Required empty public constructor
    }
    private EditText name,address,contatct,dob,email,adhar,caseId;
    private RadioGroup gender;
    private Spinner country,state,district,city;
    private ImageView showimg,calender,back;
    private Button upload,submit;
    private RadioButton male,female;
    private View view;
    private RequestQueue queue;

    private static final String INSERT_CRIMINAL = "https://rj.ltr-soft.com/public/police_api/criminal_detail/create_criminal_detail.php";

    int GALLERY_REQ_CODE=100;
    int CAMERA_REQ_CODE=200;
     private String encodeImage;
    private Bitmap bitmap;
    private ArrayAdapter adapter,adapter2,adapter3,adapter4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.add__criminal, container, false);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("   Add Criminal");
        }
        setId();
        setSpinner();
        queue= Volley.newRequestQueue(getContext());



        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              addcriminal();
            }
        });

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalender( );
            }
        });

    return view;
    }

    private void addcriminal() { name = view.findViewById(R.id.fname);
      String  address1 =  address.getText().toString().trim();
      String  contatct1 = contatct .getText().toString().trim();
      String dob1 = dob.getText().toString().trim();
        String email1 = email.getText().toString().trim();
        String adhar1 = adhar.getText().toString().trim();
        String caseId1 = caseId.getText().toString().trim();
        String cname =name.getText().toString().trim();
        String gender = male.isChecked() ? "Male" : "Female";


        if(caseId1.isEmpty()){
            caseId.setError("Enter the Case ID");
            Toast.makeText(getContext(), "Enter the Case ID", Toast.LENGTH_SHORT).show();
        }
        else {
            if (cname.isEmpty()){
                name.setError("Enter the Name of Criminal");
                Toast.makeText(getContext(), "Enter the Name of Criminal", Toast.LENGTH_SHORT).show();

            }
            else {
                if (address1.isEmpty()){
                    address.setError("Enter The Address");
                    Toast.makeText(getContext(), "Enter The Address", Toast.LENGTH_SHORT).show();

                }
                else {
                    if (contatct1.isEmpty()){
                        contatct.setError("Enter The Contact Number");
                        Toast.makeText(getContext(), "Enter The Contact Number", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        if (dob1.isEmpty()){
                            dob.setError("Enter the Date of Birth");
                            Toast.makeText(getContext(), "Enter the Date of Birth", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            if (email1.isEmpty()){
                                email.setError("Enter The Email");
                                Toast.makeText(getContext(), "Enter The Email", Toast.LENGTH_SHORT).show();

                            }
                            else {
                                if (adhar1.isEmpty()){
                                    adhar.setError("Enter the Adhar Number");
                                    Toast.makeText(getContext(), "Enter the Adhar Number", Toast.LENGTH_SHORT).show();

                                }
                                else {

                                   Criminal criminal=new Criminal(cname,address1,adhar1,contatct1,
                                           dob1,email1,caseId1,gender,encodeImage);
                                    CriminalDeo criminalDeo=new CriminalDeo();
                                    criminalDeo.createcriminal(criminal, getContext(), new Callback() {
                                        @Override
                                        public void onSuccess(Object obj) {
                                         String success=(String) obj;
                                            Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onErro(String errro) {
                                            Toast.makeText(getContext(), "error="+errro, Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }
                            }
                        }
                    }
                }
            }
        }
     }

    public void openCalender() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
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
    public void openCamera() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("Select")
                .setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Positive button click
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent, GALLERY_REQ_CODE);
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
                            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(cameraIntent, CAMERA_REQ_CODE);
                        }
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQ_CODE && resultCode == Activity.RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                bitmap = (Bitmap) extras.get("data");
                showimg.setImageBitmap(bitmap);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                if (bitmap != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byte[] bytes = byteArrayOutputStream.toByteArray();
                    encodeImage = Base64.encodeToString(bytes, Base64.NO_WRAP);
                    //
                } else {
                    Toast.makeText(getContext(), "please select the image", Toast.LENGTH_SHORT).show();

                }
            }
        } else if (requestCode == GALLERY_REQ_CODE && resultCode == Activity.RESULT_OK && data != null) {
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

            showimg.setImageURI(selectedImage);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            encodeImage = android.util.Base64.encodeToString(bytes, Base64.DEFAULT);
        }
    }

    private void setId() {
         name = view.findViewById(R.id.fname);
        address = view.findViewById(R.id.address);
        contatct = view.findViewById(R.id.contact);
        dob = view.findViewById(R.id.dob);
        email = view.findViewById(R.id.email);
        adhar = view.findViewById(R.id.addhar);
        caseId = view.findViewById(R.id.caseid);
        gender = view.findViewById(R.id.gender);
        male=view.findViewById(R.id.male);
        female=view.findViewById(R.id.female);
        country = view.findViewById(R.id.country);
        state = view.findViewById(R.id.state);
        district = view.findViewById(R.id.district);
        city = view.findViewById(R.id.city);
        showimg = view.findViewById(R.id.photo);
        calender = view.findViewById(R.id.calenderImg);
        upload = view.findViewById(R.id.upload);
        submit = view.findViewById(R.id.save);

    }
    public void setSpinner(){
        SpinnerDeo spinnerAdapter = new SpinnerDeo(getContext());
        spinnerAdapter.getCountryAdapter(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                ArrayList countrylist=new ArrayList();
                countrylist=(ArrayList) obj;
                adapter = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1,countrylist);
                adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                country.setAdapter(adapter);

            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();
            }
        });


        spinnerAdapter.getStateList(1, getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {

                ArrayList  statelist=new ArrayList();
                statelist=(ArrayList) obj;

                adapter2 = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1,statelist);
                adapter2.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                state.setAdapter(adapter2);
            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();

            }
        });


        spinnerAdapter.getDistrict(1, getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {

                ArrayList  districtlist=new ArrayList();
                districtlist=(ArrayList) obj;


                adapter3 = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1,districtlist);
                adapter3.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                district.setAdapter(adapter3);

            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();

            }
        });
        spinnerAdapter.getCity(1, getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                ArrayList citylist=new ArrayList();
                citylist=(ArrayList) obj;
                adapter4=new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1,citylist);
                adapter4.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                city.setAdapter(adapter4);
            }

            @Override
            public void onErro(String errro) {

            }
        });

    }
}