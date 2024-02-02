package com.ltrsoft.police_app.fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.ltrsoft.police_app.Adapter.EvidenceAdapter1;
import com.ltrsoft.police_app.Adapter.IEvidenceAdapter;
import com.ltrsoft.police_app.Adapter.ISuspectAdapter;
import com.ltrsoft.police_app.Adapter.IVictimAdapter;
import com.ltrsoft.police_app.Adapter.IWitnessAdapter;
import com.ltrsoft.police_app.Adapter.SuspectAdapter1;
import com.ltrsoft.police_app.Adapter.WitnessAdapter1;
import com.ltrsoft.police_app.Classes.Evidance;
import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.Classes.Victim;
import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.Model.EvidanceDeo;
import com.ltrsoft.police_app.Model.SuspectDeo;
import com.ltrsoft.police_app.Model.WitnessDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Add_Investigation extends Fragment {
    public Add_Investigation() {
    }
    private CardView suspect_card,witness_card,victim_card,Evidance_card;
    private ArrayList<Suspect>list=new ArrayList<>();
    private ArrayList<Victim>listvictim=new ArrayList<>();
    private ArrayList<Witness>listwitness=new ArrayList<>();
    private ArrayList<Evidance>listevidence=new ArrayList<>();
    private String filelang = "language.txt1";
    String lang;
    private EditText addDiscryption;
    private Button addButton;
    private ImageView mike,Suspect_plus,Witness_plus,Victim_plus,Evidance_plus;
    private ImageView disc,reco;
    private static final int REQUEST_CODE_SPEECH_INPUT = 1;
    private static final int REQUEST_CODE_FOR_DESC = 2;
    private EditText addRecomandation;
    private Button addRecomandationButton;
    private Spinner yourSpinner;
    private Button closeFile;
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

        disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, lang);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to text");

                try {
                    startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
                } catch (Exception e) {
                    Toast.makeText(getContext(), " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        reco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, lang);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to text");

                try {
                    startActivityForResult(intent, REQUEST_CODE_FOR_DESC);
                } catch (Exception e) {
                    Toast.makeText(getContext(), " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        Suspect_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_main, new AddSuspect())
                        .addToBackStack(null)
                        .commit();

            }
        });
        Victim_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_main, new AddVictim())
                        .addToBackStack(null)
                        .commit();

            }
        });
        Witness_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_main, new AddWitness())
                        .addToBackStack(null)
                        .commit();

            }
        });
        Evidance_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_main, new AddEvidence())
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
               // mike.setVisibility( newVisibility);
                addRecomandation.setVisibility( newVisibility);
              //  addRecomandationButton.setVisibility( newVisibility);
                yourSpinner.setVisibility( newVisibility);
                disc.setVisibility(newVisibility);
                reco.setVisibility(newVisibility);

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
                //mike.setVisibility( newVisibility);
                addRecomandation.setVisibility( newVisibility);
                //addRecomandationButton.setVisibility( newVisibility);
                yourSpinner.setVisibility( newVisibility);
                closeFile.setVisibility( newVisibility);
                disc.setVisibility(newVisibility);
                reco.setVisibility(newVisibility);
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
              //  mike.setVisibility( newVisibility);
                addRecomandation.setVisibility( newVisibility);
                //addRecomandationButton.setVisibility( newVisibility);
                yourSpinner.setVisibility( newVisibility);
                disc.setVisibility(newVisibility);
                reco.setVisibility(newVisibility);
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
                disc.setVisibility(newVisibility);
                reco.setVisibility(newVisibility);
             //   mike.setVisibility( newVisibility);
                addRecomandation.setVisibility( newVisibility);
//                addRecomandationButton.setVisibility( newVisibility);
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
        EvidanceDeo evidanceDeo = new EvidanceDeo();
        evidanceDeo.getAllEvidance(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                listevidence=(ArrayList<Evidance>) obj;
                EvidenceAdapter1 adapter=new EvidenceAdapter1((ArrayList<Evidance>)obj);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                Evidance_Recycler.setLayoutManager(layoutManager);
                Evidance_Recycler.setAdapter(adapter);
            }

            @Override
            public void onErro(String errro) {

            }
        });

//        listevidence.add(new Evidance("sample evidence",R.drawable.evidence));
//        listevidence.add(new Evidance("sample evidence",R.drawable.evidence));
//        listevidence.add(new Evidance("sample evidence",R.drawable.evidence));
//        listevidence.add(new Evidance("sample evidence",R.drawable.evidence));
//        listevidence.add(new Evidance("sample evidence",R.drawable.evidence));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        Evidance_Recycler.setLayoutManager(layoutManager);
//        IEvidenceAdapter adapter = new IEvidenceAdapter(listevidence);
//        Evidance_Recycler.setAdapter(adapter);

    }

    private void setWitnessAdapter() {
        WitnessDeo witnessDeo = new WitnessDeo();
        witnessDeo.getAllWitness(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                listwitness = (ArrayList<Witness>)obj;
                WitnessAdapter1 witnessAdapter1 = new WitnessAdapter1(listwitness);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                Witness_Recycler.setLayoutManager(layoutManager);
                Witness_Recycler.setAdapter(witnessAdapter1);
            }
            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "error"+errro.toString(), Toast.LENGTH_SHORT).show();
            }
        });

//        listwitness.add(new Witness("Harun","pune","5673486583"));
//        listwitness.add(new Witness("Harun","pune","5673486583"));
//        listwitness.add(new Witness("Harun","pune","5673486583"));
//        listwitness.add(new Witness("Harun","pune","5673486583"));
//        listwitness.add(new Witness("Harun","pune","5673486583"));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        IWitnessAdapter adapter = new IWitnessAdapter(listwitness);
//        Witness_Recycler.setLayoutManager(layoutManager);
//        Witness_Recycler.setAdapter(adapter);

    }

    private void setVictimAdapter() {
//        listvictim.add(new Victim("Ganesh","latur","347738876324"));
//        listvictim.add(new Victim("Ganesh","latur","347738876324"));
//        listvictim.add(new Victim("Ganesh","latur","347738876324"));
//        listvictim.add(new Victim("Ganesh","latur","347738876324"));
//        listvictim.add(new Victim("Ganesh","latur","347738876324"));
//        listvictim.add(new Victim("Ganesh","latur","347738876324"));
        IVictimAdapter iVictimAdapter = new IVictimAdapter(listvictim);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        Victim_Recycler.setLayoutManager(layoutManager);
        Victim_Recycler.setAdapter(iVictimAdapter);
    }
    private void setSuspectAdapter() {
        SuspectDeo suspectDeo = new SuspectDeo();


        suspectDeo.getAllSuspect(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
                System.out.println("response"+obj.toString());
                // Toast.makeText(getContext(), "response"+obj, Toast.LENGTH_SHORT).show();
                list = (ArrayList<Suspect>)obj;
                SuspectAdapter1 adapter = new SuspectAdapter1(list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                Suspect_recycler.setLayoutManager(layoutManager);
                Suspect_recycler.setAdapter(adapter);
            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "error"+errro.toString(), Toast.LENGTH_SHORT).show();
            }
        });


//        list.add(new Suspect("8380949810","ganesh sagave","latur"));
//        list.add(new Suspect("8380949810","ganesh sagave","latur"));
//        list.add(new Suspect("8380949810","ganesh sagave","latur"));
//        list.add(new Suspect("8380949810","ganesh sagave","latur"));
//        ISuspectAdapter iSuspectAdapter = new ISuspectAdapter(list);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        Suspect_recycler.setLayoutManager(layoutManager);
//        Suspect_recycler.setAdapter(iSuspectAdapter);
    }

    private void setId() {
        disc =view.findViewById(R.id.mikedisc);
        reco = view.findViewById(R.id.mikerec);
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
//        mike = view.findViewById(R.id.mike);
        addRecomandation = view.findViewById(R.id.add_note);
//        addRecomandationButton = view.findViewById(R.id.Add_Recomandation_Button);
        yourSpinner = view.findViewById(R.id.action);
        closeFile = view.findViewById(R.id.close_file);
        Witness_plus=view.findViewById(R.id.witness_plus);
        Suspect_plus=view.findViewById(R.id.Suspect_plus);
        Victim_plus=view.findViewById(R.id.victim_plus);
        Evidance_plus=view.findViewById(R.id.evidance_plus);
     }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == REQUEST_CODE_SPEECH_INPUT) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                addDiscryption.setText(Objects.requireNonNull(result).get(0));
            }

        }
        else if (requestCode == REQUEST_CODE_FOR_DESC){
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                addRecomandation.setText(Objects.requireNonNull(result).get(0));
            }

        }
    }
}