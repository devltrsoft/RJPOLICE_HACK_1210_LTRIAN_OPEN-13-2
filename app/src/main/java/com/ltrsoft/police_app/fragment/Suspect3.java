package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.Model.SuspectDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;


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

        Bundle bundle1=getArguments();
        if (bundle1.getString("type").equals("complaints")){
            String suspect_id=bundle1.getString("suspect_id");
            Toast.makeText(getContext(), ""+suspect_id, Toast.LENGTH_SHORT).show();
            SuspectDeo suspectDeo=new SuspectDeo();
            suspectDeo.getone_Complaint_Suspect_by_Suspect_id(suspect_id, getContext(), new Callback() {
                @Override
                public void onSuccess(Object obj) {
                    ArrayList <Suspect>suspectlist= (ArrayList<Suspect>) obj;
                    Suspect suspect= suspectlist.get(0);

                    sid.setText(suspect.getComplaint_suspect_id());
                    suspect_dob.setText(suspect.getDob());
                    Suspect_full_name.setText(suspect.getFname());
                    suspect_address.setText(suspect.getMname());
                    suspect_gender.setText(suspect.getGender());
                    suspect_mobile.setText(suspect.getMobile());
                    suspect_email.setText(suspect.getEmail());
                    suspect_country.setText(suspect.getCountry());
                    suspect_district.setText(suspect.getDistrict());
                    suspect_state.setText(suspect.getState());
                    suspect_city.setText(suspect.getCity());
                }
                @Override
                public void onErro(String errro) {

                }
            });
        }
        else if(bundle1.getString("type").equals("investigation")) {
           String id=bundle1.getString("suspect_id");
            Toast.makeText(getContext(), "id ="+id, Toast.LENGTH_SHORT).show();
           SuspectDeo suspectDeo = new SuspectDeo();
           suspectDeo.getOneSuspect(id, getContext(), new Callback() {
               @Override
               public void onSuccess(Object obj) {
                   ArrayList <Suspect>suspectlist= (ArrayList<Suspect>) obj;
                   Suspect suspect= suspectlist.get(0);

                   sid.setText(suspect.getInvestigation_suspect_id());
                   suspect_dob.setText(suspect.getDob());
                   Suspect_full_name.setText(suspect.getFname());
                   suspect_address.setText(suspect.getMname());
                   suspect_gender.setText(suspect.getGender());
                   suspect_mobile.setText(suspect.getMobile());
                   suspect_email.setText(suspect.getEmail());
                   suspect_country.setText(suspect.getCountry());
                   suspect_district.setText(suspect.getDistrict());
                   suspect_state.setText(suspect.getState());
                   suspect_city.setText(suspect.getCity());
               }

               @Override
               public void onErro(String errro) {
                   Toast.makeText(getContext(), "error "+errro.toString(), Toast.LENGTH_SHORT).show();
               }
           });

        }
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