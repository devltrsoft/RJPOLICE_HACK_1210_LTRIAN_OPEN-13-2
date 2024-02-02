package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Adapter.EvidenceAdapter1;
import com.ltrsoft.police_app.Adapter.WitnessAdapter1;
import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.Model.PoliceDeo;
import com.ltrsoft.police_app.Model.WitnessDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Witness1 extends Fragment {
    private Spinner fir_spinner;
    ArrayList  <String> firlist=new ArrayList();
    private String fir_id;
    private RecyclerView recyclerView;
    private ArrayList<Witness> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.witness__history__dashboard, container, false);
        recyclerView = view.findViewById(R.id.witnessHistoryRecycler);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        fir_spinner = view.findViewById(R.id.vfir_id_spiiner);

        if (actionBar != null) {
            actionBar.setTitle("  Witness History");
        }
        fir_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fir_id = firlist.get(i);
                loadWitness(fir_id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                fir_id = firlist.get(0);
                loadWitness(fir_id);
            }
        });

        PoliceDeo policeDeo=new PoliceDeo();
        policeDeo.getfir_id(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                firlist=(ArrayList) obj;
                ArrayAdapter adapter2;
                adapter2 = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1,firlist);
                adapter2.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                fir_spinner .setAdapter(adapter2);

            }
            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

   public void loadWitness(String fir_id){
       WitnessDeo witnessDeo = new WitnessDeo();
       if (!list.isEmpty()) {
           list.clear();
           WitnessAdapter1 witnessAdapter1 = new WitnessAdapter1(list);
           LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
           recyclerView.setLayoutManager(layoutManager);
           recyclerView.setAdapter(witnessAdapter1);
       }
           witnessDeo.getAllWitness(fir_id, getContext(), new Callback() {
               @Override
               public void onSuccess(Object obj) {
                   list = (ArrayList<Witness>) obj;
                   if (!list.isEmpty()) {
                       WitnessAdapter1 witnessAdapter1 = new WitnessAdapter1(list);
                       LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                       recyclerView.setLayoutManager(layoutManager);
                       recyclerView.setAdapter(witnessAdapter1);
                   }

               }

               @Override
               public void onErro(String errro) {
                   Toast.makeText(getContext(), "error" + errro.toString(), Toast.LENGTH_SHORT).show();
               }
           });
       }
}
