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
import com.ltrsoft.police_app.Adapter.VictimAdapter1;
import com.ltrsoft.police_app.Classes.Victim;
import com.ltrsoft.police_app.Model.PoliceDeo;
import com.ltrsoft.police_app.Model.VictimDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;
import com.ltrsoft.police_app.utils.UserDataAccess;

import java.util.ArrayList;

public class Victim1 extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Victim> list = new ArrayList<>();
    private Spinner fir_spinner;
    ArrayList  <String> firlist=new ArrayList();
    private String fir_id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.victim__history__dashboard, container, false);
        recyclerView = view.findViewById(R.id.victimHistoryRecycler);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        fir_spinner = view.findViewById(R.id.vfir_id_spiiner);
        if (actionBar != null) {
            actionBar.setTitle("Victim History");
        }
        PoliceDeo policeDeo=new PoliceDeo();
        UserDataAccess userDataAccess=new UserDataAccess();
        String user=userDataAccess.getuser(getActivity());

        if(user.equals("Admin")){
            policeDeo.getfir_id_by_station_id(getContext(), new Callback() {
                @Override


                public void onSuccess(Object obj) {
                    // Toast.makeText(getContext(), ""+user, Toast.LENGTH_SHORT).show();
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
        }else {
            policeDeo.getfir_id(getContext(), new Callback() {
                @Override
                public void onSuccess(Object obj) {
                    firlist = (ArrayList) obj;
                    ArrayAdapter adapter2;
                    adapter2 = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1, firlist);
                    adapter2.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
                    fir_spinner.setAdapter(adapter2);
                }

                @Override
                public void onErro(String errro) {
                    Toast.makeText(getContext(), "" + errro, Toast.LENGTH_SHORT).show();
                }
            });
        }

        fir_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fir_id = firlist.get(i);
                loadVictim(fir_id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                fir_id = firlist.get(0);
                loadVictim(fir_id);
            }
        });


        return view;
    }
    private void loadVictim(String firId) {

        VictimDeo victimDeo = new VictimDeo();
        if (!list.isEmpty()){
            list.clear();
            VictimAdapter1 adapter = new VictimAdapter1(list);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
        victimDeo.getAllVictim(firId, getContext(), new Callback() {
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

    }
}
