package com.ltrsoft.police_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.Victim;
import com.ltrsoft.police_app.R;


import java.util.ArrayList;

public class IVictimAdapter extends RecyclerView.Adapter<IVictimAdapter.ViewHolder> {
    public ArrayList< Victim>list;
    public boolean flag=false;


    public IVictimAdapter(ArrayList<Victim> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.victimcard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Victim iVictimClass = list.get(position);
        holder.name.setText(iVictimClass.getFname());
        holder.location.setText(iVictimClass.getAddress());
        holder.phone.setText(iVictimClass.getMobile());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        holder.nonvictim.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (flag){
//                    holder.nonvictim.setText("Suspect");
//                    Toast.makeText(view.getContext(), "Suspect is being non suspect", Toast.LENGTH_SHORT).show();
//                    flag = false;
//                }
//                else {
//                    holder.nonvictim.setText("Non Suspect");
//                    Toast.makeText(view.getContext(), "Suspect is suspect", Toast.LENGTH_SHORT).show();
//                    flag=true;
//                }            }
//        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = new AppCompatActivity();

           //  activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new ).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name,location,phone;
        public Button nonvictim;
        public ImageView edit;
        public CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.person_name);
            location = itemView.findViewById(R.id.person_location);
            phone = itemView.findViewById(R.id.person_contact);
            nonvictim = itemView.findViewById(R.id.Non_Suspect);
            edit = itemView.findViewById(R.id.Edit_profile);
            cardView = itemView.findViewById(R.id.person_card);
        }
    }
}
