package com.ltrsoft.police_app.fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.police_app.Adapter.ISuspectAdapter;
import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.R;

import java.util.ArrayList;

public class Alloted_case2 extends Fragment {

    public Alloted_case2() {
        // Required empty public constructor
    }
    private ArrayList<Suspect> list=new ArrayList<>();

    private CardView suspect_card,witness_card,victim_card,Evidance_card;
    private RecyclerView Suspect_recycler,Witness_Recycler,Victim_Recycler,Evidance_Recycler;
    public  View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          view= inflater.inflate(R.layout.alloted_case2, container, false);
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

                int newVisibility = (  Evidance_Recycler.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;

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

//        listevidence.add(new IEvidenceClass("sample evidence",R.drawable.evidence));
//        listevidence.add(new IEvidenceClass("sample evidence",R.drawable.evidence));
//        listevidence.add(new IEvidenceClass("sample evidence",R.drawable.evidence));
//        listevidence.add(new IEvidenceClass("sample evidence",R.drawable.evidence));
//        listevidence.add(new IEvidenceClass("sample evidence",R.drawable.evidence));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        Evidance_Recycler.setLayoutManager(layoutManager);
//        IEvidenceAdapter adapter = new IEvidenceAdapter(listevidence);
//        Evidance_Recycler.setAdapter(adapter);

    }

    private void setWitnessAdapter() {

//        listwitness.add(new IWitnessClass("Harun","pune","5673486583"));
//        listwitness.add(new IWitnessClass("Harun","pune","5673486583"));
//        listwitness.add(new IWitnessClass("Harun","pune","5673486583"));
//        listwitness.add(new IWitnessClass("Harun","pune","5673486583"));
//        listwitness.add(new IWitnessClass("Harun","pune","5673486583"));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        IWitnessAdapter adapter = new IWitnessAdapter(listwitness);
//        Witness_Recycler.setLayoutManager(layoutManager);
//        Witness_Recycler.setAdapter(adapter);

    }

    private void setVictimAdapter() {
//        listvictim.add(new IVictimClass("Ganesh","latur","347738876324"));
//        listvictim.add(new IVictimClass("Ganesh","latur","347738876324"));
//        listvictim.add(new IVictimClass("Ganesh","latur","347738876324"));
//        listvictim.add(new IVictimClass("Ganesh","latur","347738876324"));
//        listvictim.add(new IVictimClass("Ganesh","latur","347738876324"));
//        listvictim.add(new IVictimClass("Ganesh","latur","347738876324"));
//        IVictimAdapter iVictimAdapter = new IVictimAdapter(listvictim);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        Victim_Recycler.setLayoutManager(layoutManager);
//        Victim_Recycler.setAdapter(iVictimAdapter);
    }
    private void setSuspectAdapter() {

//        list.add(new Suspect("8380949810","ganesh sagave","latur"));
//        list.add(new Suspect("8380949810","ganesh sagave","latur"));
//        list.add(new Suspect("8380949810","ganesh sagave","latur"));
//        list.add(new Suspect("8380949810","ganesh sagave","latur"));
       ISuspectAdapter iSuspectAdapter = new ISuspectAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        Suspect_recycler.setLayoutManager(layoutManager);
        Suspect_recycler.setAdapter(iSuspectAdapter);
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

    }

}