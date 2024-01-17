package com.ltrsoft.police_app.Adapter;

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
        Victim victim2class=list.get(position);
        holder.victim_id.setText("victim id"+victim2class.getInvestigation_victim_id());
        holder.victim_name.setText("victim  name    "+victim2class.getFname());
        holder.victim_date.setText("victim date  "+victim2class.getDob());
        holder.victim_changed_date.setText("victim changed date"+victim2class.getDob());



        holder.Victim2card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();

                Victim3 w = new Victim3();

                activity.getSupportFragmentManager().beginTransaction().replace(R.id. main_container, w).addToBackStack(null).commit();
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
