package com.ltrsoft.police_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_app.Classes.Evidance;
import com.ltrsoft.police_app.Model.EvidanceDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Evidance3 extends Fragment {
    public Evidance3() {}
    private Button close;
    ArrayList <Evidance>list;
    public TextView name,description;
    public ImageView img;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.evidance3, container, false);
       close=view.findViewById(R.id.close);
       name = view.findViewById(R.id.evidance_name);
       description = view.findViewById(R.id.description);
       img = view.findViewById(R.id.Evidance_photo);

        EvidanceDeo evidanceDeo = new EvidanceDeo();
        evidanceDeo.getoneEvidance(getArguments().getString("evidence_id"), getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                list = (ArrayList<Evidance>) obj;
                Evidance evidance = list.get(0);
                name.setText(evidance.getEvidance_name());
                description.setText(evidance.getDiscription());
                img.setImageResource(R.drawable.tutorial);
            }
            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "error while loading details", Toast.LENGTH_SHORT).show();
            }
        });

    return view;
    }
}