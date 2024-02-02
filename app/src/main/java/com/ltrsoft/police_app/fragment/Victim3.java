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

import com.ltrsoft.police_app.Classes.Victim;
import com.ltrsoft.police_app.Model.VictimDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

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
    public ArrayList<Victim>list;
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

        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Victim History Detail");
        }
        Bundle bundle = getArguments();

        if (bundle.getString("type").equals("investigation")){
            String id = bundle.getString("victim_id");
            Toast.makeText(getContext(), "from investigetion"+id, Toast.LENGTH_SHORT).show();
            VictimDeo victimDeo = new VictimDeo();
            victimDeo.getOneVictim(id, getContext(), new Callback() {
                @Override
                public void onSuccess(Object obj) {
                    Toast.makeText(getContext(), "succes ", Toast.LENGTH_SHORT).show();
                    list = (ArrayList<Victim>) obj;
                    Victim victim = list.get(0);
                    full_name.setText(victim.getFname());
                    suspect_addhar.setText(victim.getMname());
                    suspect_dob.setText(victim.getDob());
                    suspect_gender.setText(victim.getGender());
                    suspect_mobile.setText(victim.getMobile());
                    suspect_country.setText(victim.getCountry());
                    suspect_state.setText(victim.getState());
                    suspect_city.setText(victim.getCity());
                    suspect_district.setText(victim.getDistrict());
                }
                @Override
                public void onErro(String errro) {
                    Toast.makeText(getContext(), "error while loading "+errro.toString(), Toast.LENGTH_SHORT).show();
                    System.out.println("eror"+errro.toString());
                }
            });

        } else if (bundle.getString("type").equals("complaints")) {

            Toast.makeText(getContext(), "from complaints", Toast.LENGTH_SHORT).show();
        }

    return view;
    }
}