package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Adapter.WitnessAdapter1;
import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.Model.WitnessDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Witness1 extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Witness> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.witness__history__dashboard, container, false);
        recyclerView = view.findViewById(R.id.witnessHistoryRecycler);

        WitnessDeo witnessDeo = new WitnessDeo();
        witnessDeo.getAllWitness(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                list = (ArrayList<Witness>)obj;
                WitnessAdapter1 witnessAdapter1 = new WitnessAdapter1(list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(witnessAdapter1);
            }
            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "error"+errro.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
