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

import com.ltrsoft.police_app.Adapter.VictimAdapter2;
import com.ltrsoft.police_app.Classes.Victim;
import com.ltrsoft.police_app.Classes.Victimtracking;
import com.ltrsoft.police_app.Model.VictimDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;


public class Victim2 extends Fragment {


    public Victim2() {
        // Required empty public constructor
    }
    private RecyclerView victim2;


    private ArrayList<Victim> list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.victim2, container, false);
        victim2=view.findViewById(R.id.victime2);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        Bundle bundle = getArguments();
//        Toast.makeText(getContext(), "id = "+bundle.getString("victim_id"), Toast.LENGTH_SHORT).show();
        String id=bundle.getString("victim_id");
        if (actionBar != null) {
            actionBar.setTitle("Victim History By Dates");
        }

        VictimDeo victimDeo = new VictimDeo();
        victimDeo.getVictimByDate(id,getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                VictimAdapter2 adapter = new VictimAdapter2((ArrayList<Victimtracking>) obj);
                LinearLayoutManager layoutManager= new LinearLayoutManager(getContext());
                victim2.setLayoutManager(layoutManager);
                victim2.setAdapter(adapter);
            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "eror "+errro.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}