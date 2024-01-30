package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.ltrsoft.police_app.Adapter.EvidenceAdapter1;
import com.ltrsoft.police_app.Adapter.SuspectAdapter1;
import com.ltrsoft.police_app.Adapter.VictimAdapter1;
import com.ltrsoft.police_app.Adapter.WitnessAdapter1;
import com.ltrsoft.police_app.Classes.Evidance;
import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.Classes.Victim;
import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.Model.EvidanceDeo;
import com.ltrsoft.police_app.Model.SuspectDeo;
import com.ltrsoft.police_app.Model.VictimDeo;
import com.ltrsoft.police_app.Model.WitnessDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Investigation1 extends Fragment {
    private ArrayList<Suspect> list=new ArrayList<>();
    private ArrayList<Victim> victim_list = new ArrayList<>();
    private ArrayList<Evidance> evidances_list=new ArrayList<>();

    private CardView suspect_card,witness_card,victim_card,Evidance_card;
    private RecyclerView Suspect_recycler,Witness_Recycler,Victim_Recycler,Evidance_Recycler;
    public  View view;
    private Button close;
    private RecyclerView recyclerView;
//    private ArrayList<InvistigationHeostryClass> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      view = inflater.inflate( R.layout.investigation1, container, false);


        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("  Investigation History");
        }
        setId();
        setSuspectAdapter();
        setVictimAdapter();
        setWitnessAdapter();
        setEvidenceAdapter();
        victim_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toggle visibility for others

                int newVisibility = (witness_card.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
                witness_card.setVisibility(newVisibility);
                Evidance_card.setVisibility( newVisibility);

                int oppositeVisibility = (newVisibility == View.VISIBLE) ? View.GONE : View.VISIBLE;
                Victim_Recycler.setVisibility(oppositeVisibility);

                updateCardClickability( suspect_card, oppositeVisibility != View.VISIBLE);
            }
        });

        witness_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toggle visibility for others

                int newVisibility = ( Evidance_card.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
                Evidance_card.setVisibility( newVisibility);

                int oppositeVisibility = (newVisibility == View.VISIBLE) ? View.GONE : View.VISIBLE;
                Witness_Recycler.setVisibility(oppositeVisibility);
                updateCardClickability(victim_card, oppositeVisibility != View.VISIBLE);
                updateCardClickability( suspect_card, oppositeVisibility != View.VISIBLE);
            }
        });
        Evidance_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toggle visibility for others

                int newVisibility = (  close  .getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;

                int oppositeVisibility = (newVisibility == View.VISIBLE) ? View.GONE : View.VISIBLE;
                Evidance_Recycler.setVisibility(oppositeVisibility);
                updateCardClickability(victim_card, oppositeVisibility != View.VISIBLE);
                updateCardClickability(witness_card, oppositeVisibility != View.VISIBLE);
                updateCardClickability( suspect_card, oppositeVisibility != View.VISIBLE);
            }
        });
        suspect_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toggle visibility for others

                int newVisibility = (victim_card.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
                victim_card.setVisibility(newVisibility);
                witness_card.setVisibility(newVisibility);
                //Victim_Recycler.setVisibility(newVisibility);
                Evidance_card.setVisibility( newVisibility);

                //Witness_Recycler.setVisibility(newVisibility);
                // Evidance_Recycler.setVisibility(newVisibility);

                int oppositeVisibility = (newVisibility == View.VISIBLE) ? View.GONE : View.VISIBLE;
                Suspect_recycler.setVisibility(oppositeVisibility);
            }
        });

        return  view;
    }

    private void updateCardClickability(CardView cardView, boolean clickable) {
        cardView.setClickable(clickable);
        cardView.setFocusable(clickable);
    }
    private void setEvidenceAdapter() {

        EvidanceDeo evidanceDeo=new EvidanceDeo();
        evidanceDeo.getAllEvidance(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                evidances_list=(ArrayList<Evidance>) obj;
                EvidenceAdapter1 adapter=new EvidenceAdapter1((ArrayList<Evidance>)obj);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                Evidance_Recycler.setLayoutManager(layoutManager);
                Evidance_Recycler.setAdapter(adapter);
            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setWitnessAdapter() {

        WitnessDeo witnessDeo=new WitnessDeo();
        witnessDeo.getAllWitness(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                ArrayList<Witness>list1 = (ArrayList<Witness>)obj;
                WitnessAdapter1 witnessAdapter1 = new WitnessAdapter1(list1);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                Witness_Recycler.setLayoutManager(layoutManager);
                Witness_Recycler.setAdapter(witnessAdapter1);

            }
            @Override
            public void onErro(String errro) {

            }
        });

    }

    private void setVictimAdapter() {
        VictimDeo victimDeo=new VictimDeo();
        victimDeo.getAllVictim(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                victim_list = (ArrayList<Victim>) obj;
                VictimAdapter1 adapter = new VictimAdapter1((ArrayList<Victim>) obj);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                Victim_Recycler.setLayoutManager(layoutManager);
                Victim_Recycler.setAdapter(adapter);
            }

            @Override
            public void onErro(String errro) {

            }
        });
    }
    private void setSuspectAdapter() {

        SuspectDeo suspectDeo=new SuspectDeo();
        suspectDeo.getAllSuspect(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                /// System.out.println("response"+obj.toString());
                // Toast.makeText(getContext(), "response"+obj, Toast.LENGTH_SHORT).show();
                list = (ArrayList<Suspect>)obj;
                SuspectAdapter1 adapter = new SuspectAdapter1(list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                Suspect_recycler.setLayoutManager(layoutManager);
                Suspect_recycler.setAdapter(adapter);
            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "response"+errro, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setId() {
        suspect_card=view.findViewById(R.id.suspect_card);
        victim_card=view.findViewById(R.id.victim_card);
        witness_card=view.findViewById(R.id.witness_card);
        Evidance_card=view.findViewById(R.id.evidance_card);
        Evidance_Recycler=view.findViewById(R.id.Evidance_recycler);
        Victim_Recycler=view.findViewById(R.id.victim_recycler);
        Witness_Recycler=view.findViewById(R.id.Witness_recycler);
        Suspect_recycler=view.findViewById(R.id.suspect_recycler);
        close=view.findViewById(R.id.close);
    }

}
