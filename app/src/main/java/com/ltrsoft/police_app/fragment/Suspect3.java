package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.ltrsoft.police_app.R;


public class Suspect3 extends Fragment {
    public Suspect3() {
    }
        private Button Add_criminal;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.suspect_detail, container, false);
            Add_criminal=view.findViewById(R.id.criminal_button);
            Add_criminal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Add_Criminal()).commit();
                }
            });


        return view;
    }
}