package com.ltrsoft.police_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.MissingPerson;
import com.ltrsoft.police_app.R;

import java.util.ArrayList;

public class MissingAdapter extends RecyclerView.Adapter<MissingAdapter.ViewHolder> {

    ArrayList<MissingPerson> list;

    public MissingAdapter(ArrayList<MissingPerson> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.missing_person_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MissingAdapter.ViewHolder holder, int position) {
        MissingPerson missingPersonClass = list.get(position);
        ArrayList<MissingPerson> missingPersonClasses = list;
        holder.missing_person_pic.setImageResource(R.drawable.policestation);
        holder.person_contact.setText(missingPersonClass.getPerson_contact());
        holder.person_name.setText(missingPersonClass.getPerson_name());
        holder.person_description.setText(missingPersonClass.getPerson_description());
        holder.person_location.setText(missingPersonClass.getPerson_location());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView missing_person_pic;
        CardView person_card;
        public TextView person_name;
        public TextView person_description;
        public TextView person_location;
        public TextView person_contact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize your item views here
            person_card = itemView.findViewById(R.id.person_card);
            person_name = itemView.findViewById(R.id.person_name);
            person_description = itemView.findViewById(R.id.person_desc);
            person_location = itemView.findViewById(R.id.place);
            person_contact = itemView.findViewById(R.id.contact);
            missing_person_pic = itemView.findViewById(R.id.missing_person_pic);
        }
    }
}