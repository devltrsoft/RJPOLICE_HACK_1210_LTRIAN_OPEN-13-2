package com.ltrsoft.police_app;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ltrsoft.police_app.Add_complaint.AddComplaint;
import com.ltrsoft.police_app.Add_complaint.AddEvidence;
import com.ltrsoft.police_app.Add_complaint.AddSuspect;
import com.ltrsoft.police_app.Add_complaint.AddWarrent;
import com.ltrsoft.police_app.Add_complaint.AddWitness;
import com.ltrsoft.police_app.Add_complaint.Add_Criminal;
import com.ltrsoft.police_app.Add_complaint.Add_Investigation;
import com.ltrsoft.police_app.Model.AddVictim;

public class Add_Complain_page extends Fragment {

    public Add_Complain_page() {
        // Required empty public constructor
    }
    private LinearLayout addcomplain,addsuspect,addevidence,addwitness,addvictim,Addinvestigation,addcriminal,addwrrent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.add__complain_page, container, false);

        addcomplain = view.findViewById(R.id.Addcompalint);
        addsuspect = view.findViewById(R.id.Addsuspect);
        addevidence = view.findViewById(R.id.Addevidance);
        addwitness = view.findViewById(R.id.Addwitness);
        addvictim = view.findViewById(R.id.Addvictim);
        Addinvestigation=view.findViewById(R.id.AddInvestigation);
        addcriminal = view.findViewById(R.id.addcriminal);
        addwrrent = view.findViewById(R.id.addwrrent);
// Access the hosting activity and get the ActionBar
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        // Set the title on the ActionBar or Toolbar
        if (actionBar != null) {
            actionBar.setTitle("Add Complaint ");
        }
        addcriminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add_Criminal addCriminal = new Add_Criminal();
                loadfragment(addCriminal);
            }
        });
        addwrrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddWarrent addWarrent = new AddWarrent();
                loadfragment(addWarrent);
            }
        });
        addcomplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddComplaint addComplaint = new AddComplaint();
                loadfragment(addComplaint);
            }
        });


        addsuspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddSuspect addSuspect=new AddSuspect();
                loadfragment(addSuspect);
            }
        });

        addevidence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddEvidence addEvidence = new AddEvidence();
                loadfragment(addEvidence);
            }
        });

        addwitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddWitness addWitness = new AddWitness();
                loadfragment(addWitness);
            }
        });
        addvictim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddVictim addVictim = new AddVictim();
                loadfragment(addVictim);
            }
        });
        Addinvestigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add_Investigation addInvestigation=new Add_Investigation();
                loadfragment(addInvestigation);
            }
        });
        return view;



    }
    private void loadfragment(Fragment fragment) {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_main,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}