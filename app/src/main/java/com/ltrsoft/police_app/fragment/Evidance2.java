package com.ltrsoft.police_app.fragment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.police_app.Adapter.EvidenceAdapter1;
import com.ltrsoft.police_app.Adapter.EvidenceAdapter2;
import com.ltrsoft.police_app.Classes.Evidance;
import com.ltrsoft.police_app.Model.EvidanceDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Evidance2 extends Fragment {
    private ArrayList<Evidance> list = new ArrayList<>();



    public Evidance2() {
        // Required empty public constructor
    }
   private RecyclerView evidance2recycler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.evidance2, container, false);
        Toast.makeText(getContext(), "yes working", Toast.LENGTH_SHORT).show();
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
    evidance2recycler=view.findViewById(R.id.evidance2_recycle);
        if (actionBar != null) {
            actionBar.setTitle("Evidance History By Dates");
        }
        EvidanceDeo evidanceDeo = new EvidanceDeo();
        evidanceDeo.getAllEvidance("2023-12-14-1",getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                list=(ArrayList<Evidance>) obj;
                EvidenceAdapter2 adapter=new EvidenceAdapter2((ArrayList<Evidance>)obj);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                evidance2recycler.setLayoutManager(layoutManager);
                evidance2recycler.setAdapter(adapter);
            }
            @Override
            public void onErro(String errro) {

            }
        });



        return view;
    }
}