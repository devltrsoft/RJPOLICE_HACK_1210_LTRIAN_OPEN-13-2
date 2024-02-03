package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Adapter.WitnessAdapter2;
import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.Classes.WitnessTracking;
import com.ltrsoft.police_app.Model.WitnessDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Witness2 extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<WitnessTracking> list1 = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.witness2, container, false);
        recyclerView = view.findViewById(R.id.witnessHistoryRecycler2);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Witness History By Date");
        }
        Bundle bundle = getArguments();
        String wid=bundle.getString("witness_id");
        Toast.makeText(getContext(), "id="+wid, Toast.LENGTH_SHORT).show();
        WitnessDeo witnessDeo = new WitnessDeo();
        witnessDeo.getWitnessByDate(wid,getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                //Toast.makeText(getContext(), "succes"+obj, Toast.LENGTH_SHORT).show();
                System.out.println("obj = "+obj.toString());
                list1=(ArrayList<WitnessTracking>)obj;
                WitnessAdapter2 adapter = new WitnessAdapter2(list1);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "error"+errro.toString(), Toast.LENGTH_SHORT).show();

                if (errro.equals("NoData")){
                    list1=new ArrayList<>();
                    list1.add(new WitnessTracking("1",wid,"","","witness created","witness created by xyz",""));
                    WitnessAdapter2 adapter = new WitnessAdapter2(list1);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }
            }
        });
        return view;
    }
}
