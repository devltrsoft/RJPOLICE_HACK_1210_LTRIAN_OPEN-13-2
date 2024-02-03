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
import com.ltrsoft.police_app.Classes.Victimtracking;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Victim3;

import java.util.ArrayList;

public class VictimAdapter2 extends RecyclerView.Adapter<VictimAdapter2.viewholder> {
    private ArrayList<Victimtracking> list;
    public VictimAdapter2(ArrayList<Victimtracking>list){
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
        Victimtracking victimClass=list.get(position);
        holder.victim_id.setText("victim id"+victimClass.getInvestigation_victim_id());
        holder.victim_name.setText("changed at    "+victimClass.getDescription());
        holder.victim_date.setText("opration "+victimClass.getOperation());
        holder.victim_changed_date.setText("changed by"+victimClass.getPolice_id());



        holder.Victim2card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Victim3 w = new Victim3();
                Bundle bundle=new Bundle();
                bundle.putString("victim_id",victimClass.getInvestigation_victim_id());
                bundle.putString("type", "investigation");
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
