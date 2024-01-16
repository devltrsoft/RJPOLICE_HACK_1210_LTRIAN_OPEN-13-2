package com.ltrsoft.police_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_app.R;

public class Setting extends Fragment {


    public Setting() {
        // Required empty public constructor
    }

    private Spinner language_spinner;
    private Switch notification_switch;
    private TextView contact_tv;
    private String [] language = {"Select Languge","English","Hindi"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.setting, container, false);
        language_spinner = view.findViewById(R.id.language_spinner);
        notification_switch = view.findViewById(R.id.notification_switch);
        contact_tv = view.findViewById(R.id.contact_tv);

        ArrayAdapter<String> adapter= new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,language);
        language_spinner.setAdapter(adapter);
        language_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i!=0) {
                    Toast.makeText(getContext(), "item " + language[i] + " clicked", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    return view;
    }
}