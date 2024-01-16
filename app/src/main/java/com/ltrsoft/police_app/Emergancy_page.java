package com.ltrsoft.police_app;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Emergancy_page extends Fragment {



    public Emergancy_page() {
        // Required empty public constructor
    }
    private CardView ambulance,woman_help,firebrigate,police_station,bombsquad,cybercrime,safety_feature;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.emergancy_page, container, false);
        ambulance = view . findViewById(R.id.Ambulance);
        woman_help = view . findViewById(R.id.womenhelpline);
        firebrigate = view . findViewById(R.id.Firman);
        police_station = view . findViewById(R.id.policeno);
        bombsquad=view.findViewById(R.id.bombsquad);
        cybercrime=view.findViewById(R.id.cybercrime);
        safety_feature=view.findViewById(R.id.safety);

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amb="tel:"+"102";//102
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse(amb));

                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });
        woman_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wh="tel:"+"1091";//1091

                Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse(wh));

                if(ActivityCompat.checkSelfPermission(getContext(),android.Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });

        firebrigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fb="tel:"+"101";//101
                Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse(fb));

                if (ActivityCompat.checkSelfPermission(getContext(),android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });

        police_station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ps="tel:"+"100";//100
                Intent intent= new Intent(Intent.ACTION_CALL,Uri.parse(ps));

                if (ActivityCompat.checkSelfPermission(getContext(),android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });

        bombsquad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ps="tel:"+"100";
                Intent intent= new Intent(Intent.ACTION_CALL,Uri.parse(ps));

                if (ActivityCompat.checkSelfPermission(getContext(),android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });

        cybercrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ps="tel:"+"1930";
                Intent intent= new Intent(Intent.ACTION_CALL,Uri.parse(ps));

                if (ActivityCompat.checkSelfPermission(getContext(),android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });

        safety_feature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ps="tel:"+"100";
                Intent intent= new Intent(Intent.ACTION_CALL,Uri.parse(ps));

                if (ActivityCompat.checkSelfPermission(getContext(),android.Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                    startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{android.Manifest.permission.CALL_PHONE},1);
                }
            }
        });





        return view;
    }
}