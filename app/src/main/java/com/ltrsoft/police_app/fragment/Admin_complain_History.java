package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Adapter.complain_history_adapter;
import com.ltrsoft.police_app.Classes.complain_history_class;
import com.ltrsoft.police_app.R;

import java.util.ArrayList;

public class Admin_complain_History extends Fragment {

    private ArrayList<complain_history_class> list=new ArrayList<>();

    public Admin_complain_History() {
        // Required empty public constructor
    }
RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.admin_complain_history, container, false);
         recyclerView=view.findViewById(R.id.complaint_Recycler);
         list.add(new complain_history_class("8380949810","ganesh sagave","latur"));
        list.add(new complain_history_class("8380949810","ganesh sagave","latur"));
        list.add(new complain_history_class("8380949810","ganesh sagave","latur"));
        complain_history_class  complainHistoryClass = new complain_history_class(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
         recyclerView.setLayoutManager(layoutManager);
        complain_history_adapter complainHistoryAdapter=new complain_history_adapter(list);
         recyclerView.setAdapter( complainHistoryAdapter);



      return  view;
    }
}