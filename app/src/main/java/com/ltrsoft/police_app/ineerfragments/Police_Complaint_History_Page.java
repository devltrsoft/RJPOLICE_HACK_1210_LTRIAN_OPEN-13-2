package com.ltrsoft.police_app.ineerfragments;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Alloted_case1;
import com.ltrsoft.police_app.fragment.Alloted_case2;
import com.ltrsoft.police_app.fragment.Criminal1;
import com.ltrsoft.police_app.fragment.Evidence1;
import com.ltrsoft.police_app.fragment.Investigation1;
import com.ltrsoft.police_app.fragment.Suspect1;
import com.ltrsoft.police_app.fragment.Victim1;
import com.ltrsoft.police_app.fragment.Warrant1;
import com.ltrsoft.police_app.fragment.Witness1;

public class Police_Complaint_History_Page extends Fragment {


    public Police_Complaint_History_Page() {
     }
    private CardView invistigationcard,allowed_cases, evidence1,suspect,warrentcard,witness,victime,criminal;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v= inflater.inflate(R.layout.police__complaint__history__page, container, false);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Police History Page");
        }
        invistigationcard =v.findViewById(R.id.investigtion);

        allowed_cases=v.findViewById(R.id.allowscases);

        victime=v.findViewById(R.id.victim);

        witness=v.findViewById(R.id.witness);


        suspect=v.findViewById(R.id.suspect);

        warrentcard=v.findViewById(R.id.warrant);
        criminal=v.findViewById(R.id.criminal);

        evidence1=v.findViewById(R.id.evidance);
        invistigationcard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Toast.makeText(getActivity(), " invistigation", Toast.LENGTH_SHORT).show();
                Investigation1 d=new Investigation1();

                getFragmentManager().beginTransaction().replace(R.id.container_main,d).addToBackStack(null).commit();

            }
        });


        allowed_cases.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getActivity(), " allowd cases", Toast.LENGTH_SHORT).show();
                Alloted_case1 al=new Alloted_case1();
                getFragmentManager().beginTransaction().replace(R.id.container_main,al).addToBackStack(null).commit();

            }
        });




        evidence1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Evidence1 ehd=new Evidence1();
                getFragmentManager().beginTransaction().replace(R.id.container_main,ehd).addToBackStack(null).commit();
            }
        });

        suspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(getActivity(), " suspect", Toast.LENGTH_SHORT).show();
                Suspect1 shd=new Suspect1();
                getFragmentManager().beginTransaction().replace(R.id.container_main,shd).addToBackStack(null).addToBackStack(null).commit();
            }
        });

        warrentcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // Toast.makeText(getActivity(), "witness", Toast.LENGTH_SHORT).show();
               Warrant1 w=new Warrant1();
                getFragmentManager().beginTransaction().replace(R.id.container_main,w).addToBackStack(null).commit();

            }
        });

        witness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "witness", Toast.LENGTH_SHORT).show();
                Witness1 w=new Witness1();
                getFragmentManager().beginTransaction().replace(R.id.container_main,w). addToBackStack(null).commit();

            }
        });
        victime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Victim1 vhd=new Victim1();
                getFragmentManager().beginTransaction().replace(R.id.container_main,vhd).addToBackStack(null).commit();
            }
        });
        criminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Criminal1 criminal1=new Criminal1();
                getFragmentManager().beginTransaction().replace(R.id.container_main,criminal1).addToBackStack(null).commit();
            }
        });
    return  v;
    }
}