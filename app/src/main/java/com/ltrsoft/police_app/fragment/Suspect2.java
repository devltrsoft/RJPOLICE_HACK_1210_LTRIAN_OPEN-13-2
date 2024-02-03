package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Adapter.SuspectAdapter2;
import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.Classes.SuspectTracking;
import com.ltrsoft.police_app.Model.SuspectDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Suspect2 extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<SuspectTracking> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.suspect2, container, false);
        recyclerView = view.findViewById(R.id.suspect2recycler);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Suspect History By Dates");
        }
        String suspect_id=getArguments().getString("investigation_suspect_id");
        Toast.makeText(getContext(), "suspect id ="+suspect_id, Toast.LENGTH_SHORT).show();
        SuspectDeo suspectDeo = new SuspectDeo();
        suspectDeo.getSuspectByDate(suspect_id, getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                SuspectAdapter2 adapter2 = new SuspectAdapter2((ArrayList<SuspectTracking>) obj);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter2);
            }
            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "failed "+errro.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
