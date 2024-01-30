package com.ltrsoft.police_app.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ltrsoft.police_app.Classes.Warrant;
import com.ltrsoft.police_app.Model.WarrantDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;
import java.util.Calendar;

public class AddWarrent extends Fragment {

    public AddWarrent() {}
    private EditText Discription,authority,judician,issued_date,fname,caseIDs,court_name;
   private ImageView calender;
    private Spinner Warrant_Type;
     private ArrayAdapter adapter ;
     private Button save;
    private ArrayList list = new ArrayList();
    private String desc,auth,judic,idate,cases,court_name1,fname1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.add_warrent, container, false);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("   Add Warrant");
        }
        Discription=view.findViewById(R.id.Discription);
        authority=view.findViewById(R.id.authority);
        judician=view.findViewById(R.id.judician);
        issued_date=view.findViewById(R.id.issued_date);
        fname=view.findViewById(R.id.fname);
        caseIDs=view.findViewById(R.id.caseIDs);
        court_name=view.findViewById(R.id.court_name);
        Warrant_Type=view.findViewById(R.id.Warrant_Type);
        save=view.findViewById(R.id.save);
        calender=view.findViewById(R.id.calenderImg);
        setAdapterr();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();

            }
        });

//
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  openCalender( );
             }
        });


        return view;
    }

    private void validation() {
        desc = Discription.getText().toString();
        auth = authority.getText().toString();
        judic = judician.getText().toString();
        idate = issued_date.getText().toString();
        cases = caseIDs.getText().toString();
        court_name1=court_name.getText().toString();
        fname1=fname.getText().toString();
        if(cases.isEmpty()){
            caseIDs.setError("Enter the Case ID");
            Toast.makeText(getContext(), "Enter the Case ID", Toast.LENGTH_SHORT).show();
        }
        else {
            if (fname1.isEmpty()){
                fname.setError("Enter the Name of Criminal");
                Toast.makeText(getContext(), "Enter the Name of Criminal", Toast.LENGTH_SHORT).show();

            }
            else {
                if (idate.isEmpty()){
                    issued_date.setError("Enter The Address");
                    Toast.makeText(getContext(), "Enter The Address", Toast.LENGTH_SHORT).show();

                }
                else {
                    if (judic.isEmpty()){
                        judician.setError("Enter The Contact Number");
                        Toast.makeText(getContext(), "Enter The Contact Number", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        if (auth.isEmpty()){
                            authority.setError("Enter the Date of Birth");
                            Toast.makeText(getContext(), "Enter the Date of Birth", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            if (court_name1.isEmpty()){
                                court_name.setError("Enter The Email");
                                Toast.makeText(getContext(), "Enter The Email", Toast.LENGTH_SHORT).show();

                            }
                            else {
                                if (desc.isEmpty()){
                                    Discription.setError("Enter the Adhar Number");
                                    Toast.makeText(getContext(), "Enter the Adhar Number", Toast.LENGTH_SHORT).show();

                                }
                                else {

                                    sendrequest();
                                }
                            }
                        }
                    }
                }
            }
        }


    }

    private void sendrequest() {
        String warrant_type_id="1";
        WarrantDeo warrantDeo1=new WarrantDeo();
        warrantDeo1.createwarrant(new Warrant(  warrant_type_id, cases,fname1,   idate, judic, auth, desc, court_name1), getContext(), new Callback() {
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
    }

    private void openCalender() {
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
                        issued_date.setText(dateOfBirth);
                    }
                },
                year,
                month,
                day);

        // Show the date picker dialog
        datePickerDialog.show();
    }


    private void setAdapterr() {
        WarrantDeo warrantDeo=new WarrantDeo();
        warrantDeo.read_wrarrant_type(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {

               ArrayList list1=new ArrayList();
               list1=(ArrayList)obj;
               String list= String.valueOf(list1);
                Toast.makeText(getContext(), ""+list, Toast.LENGTH_SHORT).show();


               // ArrayList list = spinnerAdapter.getCountryAdapter();
                adapter = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1,list1);
                adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                Warrant_Type.setAdapter(adapter);

            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();

            }
        });


     }
}