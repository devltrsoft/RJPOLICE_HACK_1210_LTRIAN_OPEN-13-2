package com.ltrsoft.police_app.Add_complaint;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationView;
import com.ltrsoft.police_app.Add_complaint.Investigation_adapter.IEvidenceAdapter;
import com.ltrsoft.police_app.Add_complaint.Investigation_adapter.ISuspectAdapter;
import com.ltrsoft.police_app.Add_complaint.Investigation_adapter.IVictimAdapter;
import com.ltrsoft.police_app.Add_complaint.Investigation_adapter.IWitnessAdapter;
import com.ltrsoft.police_app.Classes.Evidance;
import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.Classes.Victim;
import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.Model.AddVictim;
import com.ltrsoft.police_app.R;

import java.util.ArrayList;

public class Add_Investigation extends Fragment {

    public Add_Investigation() {
    }
    private CardView suspect_card,witness_card,victim_card,Evidance_card;
    private ArrayList<Suspect>list=new ArrayList<>();
    private ArrayList<Victim>listvictim=new ArrayList<>();
    private ArrayList<Witness>listwitness=new ArrayList<>();
    private ArrayList<Evidance>listevidence=new ArrayList<>();

    private EditText addDiscryption;
    private Button addButton;
    private ImageView mike,Suspect_plus,Witness_plus,Victim_plus,Evidance_plus;
    private EditText addRecomandation;
    private Button addRecomandationButton;
    private Spinner yourSpinner;
    private Button closeFile;
    NavigationView navigationView2;
    private RecyclerView Suspect_recycler,Witness_Recycler,Victim_Recycler,Evidance_Recycler;
    public  View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          view= inflater.inflate(R.layout.add__investigation, container, false);
        setId();
        setSuspectAdapter();
        setVictimAdapter();
        setWitnessAdapter();
        setEvidenceAdapter();
        navigationView2.setVisibility(View.VISIBLE);

        Suspect_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, new AddSuspect())
                        .addToBackStack(null)
                        .commit();

            }
        });
        Victim_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, new AddVictim())
                        .addToBackStack(null)
                        .commit();

            }
        });
        Witness_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, new AddWitness())
                        .addToBackStack(null)
                        .commit();

            }
        });
        Evidance_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, new AddEvidence())
                        .addToBackStack(null)
                        .commit();

            }
        });
//
//           Evidance_Recycler.setVisibility(View.VISIBLE);
//           Witness_Recycler.setVisibility(View.GONE);
//        Suspect_recycler.setVisibility(View.GONE);
//        Victim_Recycler.setVisibility(View.GONE);
//        suspect_card.setVisibility(View.GONE);
//        victim_card.setVisibility(View.GONE);
//        witness_card.setVisibility(View.GONE);
//        Evidance_card.setVisibility(View.GONE);

        victim_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toggle visibility for others

                int newVisibility = (witness_card.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
                witness_card.setVisibility(newVisibility);
                Evidance_card.setVisibility( newVisibility);
                addDiscryption.setVisibility( newVisibility);
                addButton.setVisibility( newVisibility);
                mike.setVisibility( newVisibility);
                addRecomandation.setVisibility( newVisibility);
                addRecomandationButton.setVisibility( newVisibility);
                yourSpinner.setVisibility( newVisibility);
                closeFile.setVisibility( newVisibility);
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
                addDiscryption.setVisibility( newVisibility);
                addButton.setVisibility( newVisibility);
                mike.setVisibility( newVisibility);
                addRecomandation.setVisibility( newVisibility);
                addRecomandationButton.setVisibility( newVisibility);
                yourSpinner.setVisibility( newVisibility);
                closeFile.setVisibility( newVisibility);
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

                int newVisibility = ( addDiscryption.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
                addDiscryption.setVisibility( newVisibility);
                addButton.setVisibility( newVisibility);
                mike.setVisibility( newVisibility);
                addRecomandation.setVisibility( newVisibility);
                addRecomandationButton.setVisibility( newVisibility);
                yourSpinner.setVisibility( newVisibility);
                closeFile.setVisibility( newVisibility);
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
                addDiscryption.setVisibility( newVisibility);
                addButton.setVisibility( newVisibility);
                mike.setVisibility( newVisibility);
                addRecomandation.setVisibility( newVisibility);
                addRecomandationButton.setVisibility( newVisibility);
                yourSpinner.setVisibility( newVisibility);
                closeFile.setVisibility( newVisibility);
                //Witness_Recycler.setVisibility(newVisibility);
                // Evidance_Recycler.setVisibility(newVisibility);

                int oppositeVisibility = (newVisibility == View.VISIBLE) ? View.GONE : View.VISIBLE;
                Suspect_recycler.setVisibility(oppositeVisibility);
            }
        });


    return view;
    }
    private void updateCardClickability(CardView cardView, boolean clickable) {
        cardView.setClickable(clickable);
        cardView.setFocusable(clickable);
    }

    private void setEvidenceAdapter() {

        listevidence.add(new Evidance("sample evidence",R.drawable.evidence));
        listevidence.add(new Evidance("sample evidence",R.drawable.evidence));
        listevidence.add(new Evidance("sample evidence",R.drawable.evidence));
        listevidence.add(new Evidance("sample evidence",R.drawable.evidence));
        listevidence.add(new Evidance("sample evidence",R.drawable.evidence));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        Evidance_Recycler.setLayoutManager(layoutManager);
        IEvidenceAdapter adapter = new IEvidenceAdapter(listevidence);
        Evidance_Recycler.setAdapter(adapter);

    }

    private void setWitnessAdapter() {

        listwitness.add(new Witness("Harun","pune","5673486583"));
        listwitness.add(new Witness("Harun","pune","5673486583"));
        listwitness.add(new Witness("Harun","pune","5673486583"));
        listwitness.add(new Witness("Harun","pune","5673486583"));
        listwitness.add(new Witness("Harun","pune","5673486583"));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        IWitnessAdapter adapter = new IWitnessAdapter(listwitness);
        Witness_Recycler.setLayoutManager(layoutManager);
        Witness_Recycler.setAdapter(adapter);

    }

    private void setVictimAdapter() {
        listvictim.add(new Victim("Ganesh","latur","347738876324"));
        listvictim.add(new Victim("Ganesh","latur","347738876324"));
        listvictim.add(new Victim("Ganesh","latur","347738876324"));
        listvictim.add(new Victim("Ganesh","latur","347738876324"));
        listvictim.add(new Victim("Ganesh","latur","347738876324"));
        listvictim.add(new Victim("Ganesh","latur","347738876324"));
        IVictimAdapter iVictimAdapter = new IVictimAdapter(listvictim);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        Victim_Recycler.setLayoutManager(layoutManager);
        Victim_Recycler.setAdapter(iVictimAdapter);
    }
    private void setSuspectAdapter() {

        list.add(new Suspect("8380949810","ganesh sagave","latur"));
        list.add(new Suspect("8380949810","ganesh sagave","latur"));
        list.add(new Suspect("8380949810","ganesh sagave","latur"));
        list.add(new Suspect("8380949810","ganesh sagave","latur"));
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
        addDiscryption = view.findViewById(R.id.Add_discryption);
        addButton = view.findViewById(R.id.Add_button);
        mike = view.findViewById(R.id.mike);
        addRecomandation = view.findViewById(R.id.add_note);
        addRecomandationButton = view.findViewById(R.id.Add_Recomandation_Button);
        yourSpinner = view.findViewById(R.id.action);
        closeFile = view.findViewById(R.id.close_file);
        Witness_plus=view.findViewById(R.id.witness_plus);
        Suspect_plus=view.findViewById(R.id.Suspect_plus);
        Victim_plus=view.findViewById(R.id.victim_plus);
        Evidance_plus=view.findViewById(R.id.evidance_plus);
        navigationView2=view.findViewById(R.id.navigationView2);
    }
}