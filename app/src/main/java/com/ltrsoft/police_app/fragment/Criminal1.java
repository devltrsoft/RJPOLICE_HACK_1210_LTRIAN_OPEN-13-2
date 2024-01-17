package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Adapter.CriminalAdapter;
import com.ltrsoft.police_app.Classes.Criminal;
import com.ltrsoft.police_app.Model.CriminalDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;
public class Criminal1 extends Fragment {
    public Criminal1() {

    }

    private RecyclerView recyclerView;
    private ArrayList<Criminal> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.criminal__history__dashboard, container, false);
        recyclerView = view.findViewById(R.id.criminal_recycler);

        CriminalDeo criminalDeo = new CriminalDeo();
        criminalDeo.getAllCriminal(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                list = (ArrayList<Criminal>) obj;
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                CriminalAdapter adapter = new CriminalAdapter(list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter( adapter);
            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "error"+errro.toString(), Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }
}