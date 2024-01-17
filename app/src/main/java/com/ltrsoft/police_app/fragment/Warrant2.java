package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.ltrsoft.police_app.R;


public class Warrant2 extends Fragment {


    public Warrant2() {
        // Required empty public constructor
    }

    private TextView caseIdTextView;
    private TextView fullNameTextView;
    private TextView issueDateTextView;
    private TextView jurisdictionTextView;
    private TextView issuingAuthorityTextView;
    private  TextView warrantType;
    private TextView descriptionTextView;

    // Declare Button variable
    private Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.warrant2, container, false);
         fullNameTextView = view.findViewById(R.id.warrant_name);
        issueDateTextView = view.findViewById(R.id.issued_dat);
        jurisdictionTextView = view.findViewById(R.id.juridiction);
        issuingAuthorityTextView = view.findViewById(R.id.issuing_auth);
        warrantType = view.findViewById(R.id.warrantTyp);
        descriptionTextView = view.findViewById(R.id.wdesc);

        // Find Button element by its ID
        saveButton = view.findViewById(R.id.close);
             Bundle bundle=getArguments();
        fullNameTextView.setText(bundle.getString("warrant_against"));
        issueDateTextView.setText(bundle.getString("issuing_authority"));
        jurisdictionTextView.setText(bundle.getString("court_name"));
        warrantType.setText(bundle.getString("warrant_type_name"));
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.main_container,new Warrant1()).addToBackStack(null).commit();

            }
        });
    return view;
    }
}