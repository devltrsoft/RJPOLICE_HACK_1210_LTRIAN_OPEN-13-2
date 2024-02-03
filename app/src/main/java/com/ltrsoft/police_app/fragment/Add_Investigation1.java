package com.ltrsoft.police_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.police_app.R;

public class Add_Investigation1 extends Fragment {

    public Add_Investigation1() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.add__investigation1, container, false);
         recyclerView=view.findViewById(R.id.add_investigation_1_adapter);

    return  view;
    }
}