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


public class Suspect3 extends Fragment {
    public Suspect3() {
    }
        private Button Add_criminal;
    private TextView sid,suspect_addhar,Suspect_full_name,suspect_address,suspect_dob,suspect_gender,suspect_mobile
            ,suspect_email,suspect_country,suspect_state,suspect_district,suspect_city;
    private ImageView back_button,edit,download,Suspect_pic;
    private ImageView sev;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.suspect_detail, container, false);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        sid=view.findViewById(R.id.suspect_name);
        suspect_addhar=view.findViewById(R.id.suspect_addhar);
        Suspect_full_name=view.findViewById(R.id.Suspect_full_name);
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
        if (actionBar != null) {
            actionBar.setTitle("Suspect History Detail");
        }
        Bundle bundle = getArguments();
        sid.setText(bundle.getString("cid"));
        suspect_dob.setText(bundle.getString("date"));
        Suspect_full_name.setText(bundle.getString("name"));
        // suspect_address.setText(bundle.getString(""));
        suspect_gender.setText(bundle.getString("gender"));
        suspect_mobile.setText(bundle.getString("mobile"));
        suspect_email.setText(bundle.getString("email"));
        suspect_country.setText(bundle.getString("cname"));
        suspect_district.setText(bundle.getString("dname"));
        suspect_state.setText(bundle.getString("sname"));
        suspect_city.setText(bundle.getString("cname"));
            Add_criminal=view.findViewById(R.id.suspect_button);
            Add_criminal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main,new Add_Criminal()).commit();
                }
            });


        return view;
    }
}