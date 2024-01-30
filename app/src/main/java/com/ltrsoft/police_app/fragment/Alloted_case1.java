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


import com.ltrsoft.police_app.Adapter.AllotedCaseAdapter1;
import com.ltrsoft.police_app.Adapter.AllotedCaseHistoryAdapter;
import com.ltrsoft.police_app.Classes.AllotedCaseHistoryClass;
import com.ltrsoft.police_app.Classes.Complaint;
import com.ltrsoft.police_app.Classes.News;
import com.ltrsoft.police_app.Model.ComplaintDeo;
import com.ltrsoft.police_app.Model.PoliceDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Alloted_case1 extends Fragment {

    private RecyclerView recyclerView;
   private ArrayList<AllotedCaseHistoryClass> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alloted_cases__history, container, false);

        Toast.makeText(getContext(), "hii", Toast.LENGTH_SHORT).show();

        recyclerView = view.findViewById(R.id.alloedrecycleview);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Alloted Cases");
        }

        PoliceDeo policeDeo = new PoliceDeo();
        policeDeo.getAllCriminal(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                ArrayList<AllotedCaseHistoryClass> list = (ArrayList<AllotedCaseHistoryClass>) obj;

                AllotedCaseAdapter1 adapter1 = new AllotedCaseAdapter1(list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter1);

                // Notify the adapter that the data set has changed
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onErro(String error) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
