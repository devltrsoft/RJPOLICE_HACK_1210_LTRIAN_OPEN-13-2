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

import com.ltrsoft.police_app.Adapter.SuspectAdapter1;
import com.ltrsoft.police_app.Adapter.WitnessAdapter1;
import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.Model.PoliceDeo;
import com.ltrsoft.police_app.Model.SuspectDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;
import com.ltrsoft.police_app.utils.UserDataAccess;

import java.util.ArrayList;

public class Suspect1 extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Suspect> list=new ArrayList<>() ;
   private Spinner fir_spinner;
    ArrayList <String>  firlist=new ArrayList();
    String fir_id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.suspect__history__dashboard, container, false);
        recyclerView = view.findViewById(R.id.suspectHistoryRecycler);
        fir_spinner=view.findViewById(R.id.fir_id_spiiner);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(" Suspect History");
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
                loadSuspectBYFirId(fir_id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
//                fir_id=firlist.get(0);
//                loadSuspectBYFirId(fir_id);
            }
        });
        return view;
    }

    public void loadSuspectBYFirId(String fir_id){
        SuspectDeo suspectDeo = new SuspectDeo();
        if (!list.isEmpty()) {
            list.clear();
            SuspectAdapter1 adapter = new SuspectAdapter1(list);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }
        suspectDeo.getsuspect_by_Fir_id(fir_id, getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                list = (ArrayList<Suspect>)obj;
                if (!list.isEmpty()) {
                    SuspectAdapter1 adapter = new SuspectAdapter1(list);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }else {

                }
            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "error"+errro.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
