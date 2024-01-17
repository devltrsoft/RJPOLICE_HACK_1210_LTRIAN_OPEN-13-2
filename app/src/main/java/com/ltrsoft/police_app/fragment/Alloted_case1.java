package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.ltrsoft.police_app.Adapter.AllotedCaseAdapter1;
import com.ltrsoft.police_app.Classes.Complaint;
import com.ltrsoft.police_app.Classes.News;
import com.ltrsoft.police_app.Model.ComplaintDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Alloted_case1 extends Fragment {

    private RecyclerView recyclerView;
   private ArrayList<Complaint> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alloted_cases__history, container, false);
        recyclerView = view.findViewById(R.id.alloedrecycleview);

       list.clear();
        ComplaintDeo complaintDeo=new ComplaintDeo();
        complaintDeo.getoneComplaint(1, getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                ArrayList<Complaint>  complaintlist=new ArrayList<>();
                complaintlist=(ArrayList<Complaint>)obj;
                 AllotedCaseAdapter1 adapter = new AllotedCaseAdapter1(complaintlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
             }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();
            }
        });
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
