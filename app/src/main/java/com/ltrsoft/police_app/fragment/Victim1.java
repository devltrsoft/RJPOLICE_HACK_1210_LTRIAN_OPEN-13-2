package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Adapter.VictimAdapter1;
import com.ltrsoft.police_app.Classes.Victim;
import com.ltrsoft.police_app.Model.VictimDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Victim1 extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Victim> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.victim__history__dashboard, container, false);
        recyclerView = view.findViewById(R.id.victimHistoryRecycler);

        VictimDeo victimDeo = new VictimDeo();
        victimDeo.getAllVictim( getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                list = (ArrayList<Victim>) obj;
                VictimAdapter1 adapter = new VictimAdapter1((ArrayList<Victim>) obj);
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
