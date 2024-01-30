package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_app.Classes.Criminal;
import com.ltrsoft.police_app.Model.CriminalDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Criminal2 extends Fragment {
     String criminal_id;
    private ArrayList<Criminal> criminal1 = new ArrayList<>();
    private TextView name,address,contatct,dob,email,adhar,caseId;
    private TextView gender;
    private TextView country,state,district,city;
    private ImageView showimg,calender,back;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          View view= inflater.inflate(R.layout.criminal_history__dates, container, false);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        name = view.findViewById(R.id.fname);
        address = view.findViewById(R.id.address);
        contatct = view.findViewById(R.id.contact);
        dob = view.findViewById(R.id.dob);
        email = view.findViewById(R.id.email);
        adhar = view.findViewById(R.id.addhar);
        caseId = view.findViewById(R.id.caseid);
        gender = view.findViewById(R.id.gender);

        country = view.findViewById(R.id.country);
        state = view.findViewById(R.id.state);
        district = view.findViewById(R.id.district);
        city = view.findViewById(R.id.city);
        showimg = view.findViewById(R.id.photo);

        if (actionBar != null) {
            actionBar.setTitle("Criminal History Detail");
        }
       Bundle b=getArguments();
        if (b!=null){
             criminal_id=b.getString("criminal_id");
            name.setText(b.getString("name") );
        address.setText(b.getString("address"));
        email.setText(b.getString("email"));
       country.setText(b.getString("country"));
       state.setText(b.getString("state"));
       district.setText(b.getString("district"));
       city.setText(b.getString("city"));
       contatct.setText(b.getString("contatct"));
       gender.setText(b.getString("gender"));
       caseId.setText(b.getString("caseId"));
       adhar.setText(b.getString("adhar"));
       dob.setText(b.getString("dob"));


        }
       // Toast.makeText(getContext(), ""+criminal_id, Toast.LENGTH_SHORT).show();
//        CriminalDeo criminalDeo=new CriminalDeo();
//        criminalDeo.criminalone(criminal_id, getContext(), new Callback() {
//            @Override
//            public void onSuccess(Object obj) {
//                criminal1 = (ArrayList<Criminal>) obj;
//        name.setText(criminal1.ge());
//        address.setText(criminal.getAddress());
//        email.setText(criminal.getEmail());
//       country.setText(criminal.getCountry());
//       state.setText(criminal.getState());
//       district.setText(criminal.getDistrict());
//       city.setText(criminal.getCity());
//       contatct.setText(criminal.getMobile());
//       gender.setText(criminal.getGender());
//       caseId.setText(criminal.getCriminal_complaint_id());
//       adhar.setText(criminal.getAdhar());
//       dob.setText(criminal.getDob());

//            }
//
//            @Override
//            public void onErro(String errro) {
//                Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();
//            }
      //  });
    return view;
    }
}