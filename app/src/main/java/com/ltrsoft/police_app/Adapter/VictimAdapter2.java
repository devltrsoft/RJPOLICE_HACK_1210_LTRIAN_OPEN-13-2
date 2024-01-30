package com.ltrsoft.police_app.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.Victim;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Victim3;

import java.util.ArrayList;

public class VictimAdapter2 extends RecyclerView.Adapter<VictimAdapter2.viewholder> {
    private ArrayList<Victim> list;
    public VictimAdapter2(ArrayList<Victim>list){
       this.list=list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.victim2card,parent,false);
         return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Victim victimClass=list.get(position);
        holder.victim_id.setText("victim id"+victimClass.getInvestigation_victim_id());
        holder.victim_name.setText("victim  name    "+victimClass.getFname());
        holder.victim_date.setText("victim date  "+victimClass.getDob());
        holder.victim_changed_date.setText("victim changed date"+victimClass.getDob());



        holder.Victim2card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Victim3 w = new Victim3();

                Bundle bundle=new Bundle();
                bundle.putString("fir_id", victimClass.getFir_id());
                bundle.putString("victim_fname", victimClass.getFname ());
                bundle.putString("complaint_victim_mname", victimClass.getMname());
                bundle.putString("complaint_victim_lname", victimClass.getLname());
                bundle.putString("address",victimClass.getAddress());
                bundle.putString("gender",victimClass.getGender());
                bundle.putString("aadhar",victimClass.getAdhar());
                bundle.putString("photo",victimClass.getPhoto_path());
                bundle.putString("dob",victimClass.getDob());
                bundle.putString("mobile",victimClass.getMobile());
                bundle.putString("state_name",victimClass.getState());
                bundle.putString("district_name",victimClass.getDistrict());
                bundle.putString("country_name",victimClass.getCountry());
                bundle.putString("city_name",victimClass.getCity());
                 w.setArguments(bundle);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id. container_main, w).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends  RecyclerView.ViewHolder{
   private   TextView victim_name,victim_id,victim_date,victim_changed_date;
     private CardView Victim2card;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            victim_id=itemView.findViewById(R.id.Victim_Id);
            victim_name=itemView.findViewById(R.id.Victim_Name);
             victim_date=itemView.findViewById(R.id.Victim_Date);
            victim_changed_date=itemView.findViewById(R.id.Victim_changed_Date);
                Victim2card=itemView.findViewById(R.id.Victim2card);


        }
    }
}
