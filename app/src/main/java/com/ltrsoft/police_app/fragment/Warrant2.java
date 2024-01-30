package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_app.R;


public class Warrant2 extends Fragment {


    public Warrant2() {
        // Required empty public constructor
    }

    public TextView Discription,authority,judician,issued_date,fname,caseIDs,court_name;
    public TextView Warrant_Type;

    // Declare Button variable
    private Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.warrant2, container, false);
        Warrant_Type = view.findViewById(R.id.Warrant_Type);
        Discription = view.findViewById(R.id.Discription);
        authority = view.findViewById(R.id.authority);
         issued_date = view.findViewById(R.id.issued_date);
        fname = view.findViewById(R.id.fname);
        caseIDs = view.findViewById(R.id.caseIDs);
        court_name=view.findViewById(R.id.court_name);
        // Find Button element by its ID
        saveButton = view.findViewById(R.id.close);
             Bundle bundle=getArguments();
        fname.setText(bundle.getString("warrant_against"));
        authority.setText(bundle.getString("issuing_authority"));
        court_name.setText(bundle.getString("court_name"));
        Warrant_Type.setText(bundle.getString("warrant_type_name"));
        caseIDs.setText(bundle.getString("fir_id"));

        issued_date.setText(bundle.getString("issue_date"));
        Warrant_Type.setText(bundle.getString("warrant_type"));
        Discription.setText(bundle.getString("discription"));

        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("  Warrant History Detail");
        }
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.main_container,new Warrant1()).addToBackStack(null).commit();

            }
        });
    return view;
    }
}