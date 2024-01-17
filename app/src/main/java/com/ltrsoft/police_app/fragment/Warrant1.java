package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.ltrsoft.police_app.Adapter.Warrant1Adapter;
import com.ltrsoft.police_app.Classes.Warrant;
import com.ltrsoft.police_app.Model.WarrantDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Warrant1 extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Warrant> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.warrant1, container, false);
        recyclerView = view.findViewById(R.id.warrantHistoryRecycler);

      list.clear();
        WarrantDeo warrantDeo=new WarrantDeo();
        warrantDeo.getAllWarrant(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                ArrayList<Warrant> warrantlist=new ArrayList();
                warrantlist=(ArrayList<Warrant>) obj;

                 Warrant1Adapter adapter = new Warrant1Adapter(warrantlist);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

                //Toast.makeText(getContext(), "success"+warrantlist, Toast.LENGTH_SHORT).show();
             }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();
            }
        });


//        list.add(new WarrantHistoryClass("1", "John Doe", "2022-01-08"));
//        list.add(new WarrantHistoryClass("2", "Jane Doe", "2022-01-09"));
//        list.add(new WarrantHistoryClass("3", "Smith Johnson", "2022-01-10"));

         Warrant1Adapter adapter = new Warrant1Adapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
