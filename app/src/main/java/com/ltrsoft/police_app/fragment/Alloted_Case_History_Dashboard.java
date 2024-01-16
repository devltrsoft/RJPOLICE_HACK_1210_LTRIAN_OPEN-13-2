package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.ltrsoft.police_app.R;

import java.util.ArrayList;

public class Alloted_Case_History_Dashboard extends Fragment {

    private RecyclerView recyclerView;
//    private ArrayList<AllotedCaseHistoryClass> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alloted_cases__history, container, false);
        recyclerView = view.findViewById(R.id.alloedrecycleview);

//        list.clear();
//        list.add(new AllotedCaseHistoryClass("1", "John Doe", "2022-01-08"));
//        list.add(new AllotedCaseHistoryClass("2", "Jane Doe", "2022-01-09"));
//        list.add(new AllotedCaseHistoryClass("3", "Bob Smith", "2022-01-10"));
//
//        AllotedCaseHistoryAdapter adapter = new AllotedCaseHistoryAdapter(list);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);

        return view;
    }
}
