package com.ltrsoft.police_app.fragment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.police_app.R;

public class Evidance2 extends Fragment {



    public Evidance2() {
        // Required empty public constructor
    }
   private RecyclerView evidance2recycler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.evidance2, container, false);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
    evidance2recycler=view.findViewById(R.id.evidance2_recycle);
        if (actionBar != null) {
            actionBar.setTitle("Evidance History By Dates");
        }

    return view;
    }
}