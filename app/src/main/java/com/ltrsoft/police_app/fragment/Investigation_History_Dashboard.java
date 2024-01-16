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

public class Investigation_History_Dashboard extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<InvistigationHeostryClass> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.investigation_history_dashboard, container, false);
        recyclerView = view.findViewById(R.id.investigationrecle);


        list.clear();
        list.add(new InvistigationHeostryClass("1", "Harun", "2022-01-08"));
        list.add(new InvistigationHeostryClass("2", "Harun Shaikh", "2022-01-09"));
        list.add(new InvistigationHeostryClass("3", "Shaikh Kaif", "2022-01-10"));

        InvestigationHistoryAdapter adapter = new InvestigationHistoryAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
