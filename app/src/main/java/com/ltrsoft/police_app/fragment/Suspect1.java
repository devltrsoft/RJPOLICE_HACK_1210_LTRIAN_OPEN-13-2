package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Adapter.SuspectAdapter1;
import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.Model.SuspectDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Suspect1 extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Suspect> list ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.suspect__history__dashboard, container, false);
        recyclerView = view.findViewById(R.id.suspectHistoryRecycler);

        SuspectDeo suspectDeo = new SuspectDeo();
        suspectDeo.getAllSuspect(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                System.out.println("response"+obj.toString());
                Toast.makeText(getContext(), "response"+obj, Toast.LENGTH_SHORT).show();
                list = (ArrayList<Suspect>)obj;
                SuspectAdapter1 adapter = new SuspectAdapter1(list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "error"+errro.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
