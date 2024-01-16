package com.ltrsoft.police_app.Add_complaint.Investigation_adapter;

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

import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.R;

import java.util.ArrayList;

public class IWitnessAdapter extends RecyclerView.Adapter<IWitnessAdapter.ViewHolder> {

    public ArrayList<Witness>list;
    public boolean flag=false;


    public IWitnessAdapter(ArrayList<Witness> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout. witnesscard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Witness iWitnessClass = list.get(position);
    holder.name.setText(iWitnessClass.getFname());
    holder.location.setText(iWitnessClass.getAddress());
    holder.phone.setText(iWitnessClass.getMobile());
    
    holder.edit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Edit clicked", Toast.LENGTH_SHORT).show();
        }
    });

    holder.nonwitness.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (flag){
                holder.nonwitness.setText("Suspect");
                Toast.makeText(view.getContext(), "Suspect is being non suspect", Toast.LENGTH_SHORT).show();
                flag = false;
            }
            else {
                holder.nonwitness.setText("Non Suspect");
                Toast.makeText(view.getContext(), "Suspect is suspect", Toast.LENGTH_SHORT).show();
                flag=true;
            }        }
    });

    holder.card.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AppCompatActivity activity = new AppCompatActivity();
//            activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new ).commit();
        }
    });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name,location,phone;
        public Button nonwitness;
        public ImageView edit;
        public CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.person_card);
            name = itemView.findViewById(R.id.person_name);
            location = itemView.findViewById(R.id.person_location);
            phone = itemView.findViewById(R.id.person_contact);
            nonwitness = itemView.findViewById(R.id.Non_Suspect);
            edit = itemView.findViewById(R.id.Edit_profile);
        }
    }
}
