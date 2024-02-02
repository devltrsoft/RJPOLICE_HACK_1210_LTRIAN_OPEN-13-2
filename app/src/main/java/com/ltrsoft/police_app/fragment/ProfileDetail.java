package com.ltrsoft.police_app.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_app.Classes.Police;
import com.ltrsoft.police_app.Model.PoliceDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;
import com.ltrsoft.police_app.utils.UserDataAccess;

import java.util.ArrayList;

public class ProfileDetail extends Fragment {


    public ProfileDetail() {
        // Required empty public constructor
    }
    private final static String POLICE_DETAIL_URL = "http://rj.ltr-soft.com/public/police_api/data/police_read.php";
    private TextView police_id,batch_number,station_id,police_fname,police_mname,police_lname
            ,police_email,police_gender,police_dob,police_mobile1,police_mobile2,police_address,
            position_name,city_name,district_name,state_name,police_adhar;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.profile_detail, container, false);
        police_id = view.findViewById(R.id.poiceid);
        batch_number = view.findViewById(R.id.batchno);
        station_id = view.findViewById(R.id.stationid);
        police_fname = view.findViewById(R.id.fname);
        police_mname = view.findViewById(R.id.mname);
        police_lname = view.findViewById(R.id.lname);
        police_email = view.findViewById(R.id.pemail);
        police_mobile1 = view.findViewById(R.id.mno);
        police_gender = view.findViewById(R.id.pgender);
        police_dob = view.findViewById(R.id.pdob);
        police_mobile2 = view.findViewById(R.id.alno);
        police_address = view.findViewById(R.id.adress);
        position_name = view.findViewById(R.id.positionid);
        city_name = view.findViewById(R.id.cityid);
        district_name = view.findViewById(R.id.districtid);
        state_name = view.findViewById(R.id.stateid);
        police_adhar = view . findViewById(R.id.policeadhar);
        PoliceDeo policeDeo=new PoliceDeo();
        UserDataAccess access1 = new UserDataAccess();
        Activity activity1 =(Activity)getContext();
       String Police_id= access1.getPoliceId( activity1);
         PoliceDeo.getonepolice(new Police(Police_id).setPolice_id(), getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
            Police police = (Police)obj;
                batch_number.setText(Police.getBatch_number());
                 station_id.setText(Police.getStation_name());
                police_fname.setText(Police.getFname());
                police_mname.setText(Police.getMname());
                police_fname.setText(Police.getLname());
                police_email.setText(police.getEmail());
                police_gender.setText(police.getGender());
                police_dob.setText(police.getDob());
                police_mobile1.setText(police.getMobile1());
                police_mobile2.setText(police.getMobile2());
                police_address.setText(police.getAddress());
                city_name.setText(police.getCity());
                district_name.setText(police.getDistrict());
                state_name.setText(police.getState());
                position_name.setText(police.getPosition_name());
                police_adhar.setText(Police.getAdhar());
              }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getActivity(), ""+errro, Toast.LENGTH_SHORT).show();
            }
        });


        view.findViewById(R.id.p_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.fragment_container, new EditFragment())
//                        .addToBackStack(null)
//                        .commit();
            }
        });



      return  view;
    }
}