package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.ltrsoft.police_app.R;

public class Victim3 extends Fragment {
    public Victim3() {
        // Required empty public constructor
    }
    private Button close;
    private TextView full_name,suspect_addhar,Suspect_full_name,suspect_address,suspect_dob,suspect_gender,suspect_mobile
            ,suspect_email,suspect_country,suspect_state,suspect_district,suspect_city;
    private ImageView back;
    private ImageView back_button,edit,download,Suspect_pic;
    private ImageView sev;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.victim__history__dates, container, false);
         suspect_addhar=view.findViewById(R.id.suspect_addhar);
        full_name=view.findViewById(R.id.Suspect_full_name);
        suspect_address=view.findViewById(R.id.suspect_address);
        suspect_dob=view.findViewById(R.id.suspect_dob);
        suspect_gender=view.findViewById(R.id.suspect_gender);
        suspect_mobile=view.findViewById(R.id.suspect_mobile);
        suspect_email=view.findViewById(R.id.suspect_email);
        suspect_country=view.findViewById(R.id.suspect_country);
        suspect_state=view.findViewById(R.id.suspect_state);
        suspect_district=view.findViewById(R.id.suspect_district);
        suspect_city=view.findViewById(R.id.suspect_city);


         Suspect_pic=view.findViewById(R.id.Suspect_pic);
        Bundle bundle = getArguments();



        full_name.setText(bundle.getString("complaint_victim_fname"+bundle.getString("complaint_victim_mname")+bundle.getString("complaint_victim_lname")));
        suspect_addhar.setText(bundle.getString("aadhar"));
        suspect_dob.setText(bundle.getString("dob"));
        suspect_gender.setText(bundle.getString("gender"));
        suspect_mobile.setText(bundle.getString("mobile"));
        suspect_country.setText(bundle.getString("country_name"));
        suspect_state.setText(bundle.getString("state_name"));
        suspect_city.setText(bundle.getString("city_name"));
        suspect_district.setText(bundle.getString("district_name"));
         ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Victim History Detail");
        }



    return view;
    }
}