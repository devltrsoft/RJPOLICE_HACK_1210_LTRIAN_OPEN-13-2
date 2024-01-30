package com.ltrsoft.police_app.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.AllotedCaseHistoryClass;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Alloted_case2;
import com.ltrsoft.police_app.fragment.Criminal2;

import java.util.ArrayList;

public class AllotedCaseAdapter1 extends RecyclerView.Adapter<AllotedCaseAdapter1.viewholder> {
    private ArrayList<AllotedCaseHistoryClass> dataList;

    public AllotedCaseAdapter1(ArrayList<AllotedCaseHistoryClass> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allowedcasecard1, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        AllotedCaseHistoryClass item = dataList.get(position);
        holder.complaint_id.setText("Complaint ID: " + item.getId());
        holder.victim_name.setText("Victim Name: " + item.getName());
        holder.address.setText("Address: " + item.getAddress());
        holder.complaint_type.setText("Complaint Type: " + item.getComplaint_type());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "hiii", Toast.LENGTH_SHORT).show();

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Alloted_case2 allotedCase2=new Alloted_case2();

         activity.getSupportFragmentManager().beginTransaction().replace(R.id.container_main,allotedCase2).addToBackStack(null
         ).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        private TextView complaint_id, complaint_type, victim_name, address;
        private CardView cardView;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            complaint_id = itemView.findViewById(R.id.textCaseId);
            complaint_type = itemView.findViewById(R.id.textCaseName);
            victim_name = itemView.findViewById(R.id.textCaseDate);
            address = itemView.findViewById(R.id.crime_type);
            cardView = itemView.findViewById(R.id.alloedcasecard);
        }
    }
}
