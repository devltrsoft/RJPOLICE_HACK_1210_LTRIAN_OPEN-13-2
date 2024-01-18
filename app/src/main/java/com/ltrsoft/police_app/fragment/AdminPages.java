package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_app.R;


public class AdminPages extends Fragment {
    public AdminPages() {}

    private CardView notAllotedCard, allotedCasesCard, adminComplaintCard,
            evidenceCard, suspectCard, witnessCard, victimCard, warrantCard, criminalCard;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.admin_pages, container, false);
        notAllotedCard = view.findViewById(R.id.Not_alloted);
        allotedCasesCard = view.findViewById(R.id.Alloted_cases);
        adminComplaintCard = view.findViewById(R.id.Admin_complaint);
        evidenceCard = view.findViewById(R.id.Evidance);
        suspectCard = view.findViewById(R.id.suspect);
        witnessCard = view.findViewById(R.id.witness);
        victimCard = view.findViewById(R.id.victim);
        warrantCard = view.findViewById(R.id.Warrant);
        criminalCard = view.findViewById(R.id.criminal);
        adminComplaintCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "to police  complaint History", Toast.LENGTH_SHORT).show();
                 getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Admin_complain_History()).addToBackStack(null).commit();

            }
        });


        notAllotedCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Not_Alloted_case()).addToBackStack(null).commit();

            }
        });

        allotedCasesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Alloted_case2()).addToBackStack(null).commit();

            }
        });
        warrantCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Warrant1()).commit();
                Toast.makeText(getContext(), "to police  Suspect History", Toast.LENGTH_SHORT).show();

            }
        });
        evidenceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "to police Evidance History", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Evidence1()).commit();

            }
        });

        suspectCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "to police  Suspect History", Toast.LENGTH_SHORT).show();
                  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Suspect1()).commit();

            }
        });
        victimCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "to police Evidance History", Toast.LENGTH_SHORT).show();
                  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Victim1()).commit();

            }
        });
       witnessCard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getContext(), "to police  witness History", Toast.LENGTH_SHORT).show();
                 getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Warrant1()).commit();

           }
       });

        criminalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "to police Criminal History", Toast.LENGTH_SHORT).show();
                  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Criminal1()).commit();

            }
        });


        return view;
    }
}