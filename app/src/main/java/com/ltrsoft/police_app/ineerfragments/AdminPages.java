package com.ltrsoft.police_app.ineerfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Admin_complain_History;
import com.ltrsoft.police_app.fragment.Alloted_case1;
import com.ltrsoft.police_app.fragment.Criminal1;
import com.ltrsoft.police_app.fragment.Evidence1;
import com.ltrsoft.police_app.fragment.Not_Alloted_case;
import com.ltrsoft.police_app.fragment.Suspect1;
import com.ltrsoft.police_app.fragment.Victim1;
import com.ltrsoft.police_app.fragment.Warrant1;


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
               // Toast.makeText(getContext(), "to police  complaint History", Toast.LENGTH_SHORT).show();
                 getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,new Admin_complain_History()).addToBackStack(null).commit();

            }
        });


        notAllotedCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main,new Not_Alloted_case()).addToBackStack(null).commit();

            }
        });

        allotedCasesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main,new Alloted_case1()).addToBackStack(null).commit();

            }
        });
        warrantCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main,new Warrant1()).commit();
               // Toast.makeText(getContext(), "to police  Suspect History", Toast.LENGTH_SHORT).show();

            }
        });
        evidenceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getContext(), "to police Evidance History", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main,new Evidence1()).commit();

            }
        });

        suspectCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getContext(), "to police  Suspect History", Toast.LENGTH_SHORT).show();
                  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main,new Suspect1()).commit();

            }
        });
        victimCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getContext(), "to police Evidance History", Toast.LENGTH_SHORT).show();
                  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main,new Victim1()).commit();

            }
        });
       witnessCard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              // Toast.makeText(getContext(), "to police  witness History", Toast.LENGTH_SHORT).show();
                 getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main,new Warrant1()).commit();

           }
       });

        criminalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getContext(), "to police Criminal History", Toast.LENGTH_SHORT).show();
                  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main,new Criminal1()).commit();

            }
        });


        return view;
    }
}