package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Adapter.EvidenceAdapter1;
import com.ltrsoft.police_app.Classes.Evidance;
import com.ltrsoft.police_app.Model.EvidanceDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Evidence1 extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Evidance> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.evidance__history__dashboard, container, false);
        recyclerView = view.findViewById(R.id.evidenceRecyclerView);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Evidance History");
        }
        EvidanceDeo evidanceDeo = new EvidanceDeo();
        evidanceDeo.getAllEvidance(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                   list=(ArrayList<Evidance>) obj;
                EvidenceAdapter1 adapter=new EvidenceAdapter1((ArrayList<Evidance>)obj);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onErro(String errro) {

            }
        });


        return view;
    }
}
