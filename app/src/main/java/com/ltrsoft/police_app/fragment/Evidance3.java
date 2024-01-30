package com.ltrsoft.police_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ltrsoft.police_app.R;

public class Evidance3 extends Fragment {


    public Evidance3() {
        // Required empty public constructor
    }

    private Button close;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.evidance3, container, false);
       close=view.findViewById(R.id.close);


    return view;
    }
}