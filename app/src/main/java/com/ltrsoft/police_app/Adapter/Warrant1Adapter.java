package com.ltrsoft.police_app.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.ltrsoft.police_app.Classes.Warrant;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Warrant2;

import java.util.ArrayList;

public class Warrant1Adapter extends RecyclerView.Adapter<Warrant1Adapter.ViewHolder> {

    private ArrayList<Warrant> dataList;

    public Warrant1Adapter(ArrayList<Warrant> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.warrant1card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Warrant item = dataList.get(position);

        holder.tvi.setText("Warrant ID: " + item.getWarrant_id());
        holder.textWarrantName.setText("Warrant Name: " + item. getWarrant_against());
        holder.textWarrantDate.setText("Warrant Date: " + item.getDate_issued());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                 Warrant2 w = new Warrant2();
                Bundle bundle=new Bundle();
                bundle.putString("warrant_type",item.getWarrant_type());
                bundle.putString("issue_date",item.getDate_issued());
                bundle.putString("fir_id",item. getFir_id());
                 bundle.putString("discription",item.getDiscription());

                bundle.putString("issuing_authority",item.getIssuing_athority());
                bundle.putString("court_name",item.getCourt_name());
                bundle.putString("warrant_against",item.getWarrant_against());
                w.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id. container_main, w).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvi, textWarrantName, textWarrantDate;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvi = itemView.findViewById(R.id.textWarrantId);
            textWarrantName = itemView.findViewById(R.id.textWarrantName);
            textWarrantDate = itemView.findViewById(R.id.textWarrantDate);
            cardView = itemView.findViewById(R.id.warrantCard);
        }
    }
}
