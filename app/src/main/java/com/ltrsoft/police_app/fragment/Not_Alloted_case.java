package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Adapter.NotAllotedCasesAdapter;
import com.ltrsoft.police_app.Classes.NotAllotedCaseClass;
import com.ltrsoft.police_app.R;

import java.util.ArrayList;


public class Not_Alloted_case extends Fragment {
    public RecyclerView recyclerView;
    ArrayList<NotAllotedCaseClass> list = new ArrayList<>();
    public Not_Alloted_case() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.not__alloted_case, container, false);
        recyclerView = view.findViewById(R.id.not_alloted_cases);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        // Set the title on the ActionBar or Toolbar
        if (actionBar != null) {
            actionBar.setTitle("Not Alloted Cases ");
        }

        list.add(new NotAllotedCaseClass("1032039","Murder"));
        list.add(new NotAllotedCaseClass("1032039","Murder"));
        list.add(new NotAllotedCaseClass("1032039","Murder"));
        list.add(new NotAllotedCaseClass("1032039","Murder"));
        list.add(new NotAllotedCaseClass("1032039","Murder"));
        list.add(new NotAllotedCaseClass("1032039","Murder"));
        list.add(new NotAllotedCaseClass("1032039","Murder"));

        NotAllotedCasesAdapter adapter = new NotAllotedCasesAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

   return view;
    }
}