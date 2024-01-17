package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import com.ltrsoft.police_app.R;

public class Victim3 extends Fragment {
    public Victim3() {
        // Required empty public constructor
    }
    private Button close;
    private ImageView back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.victim__history__dates, container, false);
    close=view.findViewById(R.id.close);
    back=view.findViewById(R.id.back);
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.  main_container,new Witness2()).commit();

        }
    });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.  main_container,new Witness2()).commit();
            }
        });


    return view;
    }
}