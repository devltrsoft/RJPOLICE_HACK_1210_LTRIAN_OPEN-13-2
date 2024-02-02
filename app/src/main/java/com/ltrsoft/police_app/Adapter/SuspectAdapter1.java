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

import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Suspect2;

import java.util.ArrayList;

public class SuspectAdapter1 extends RecyclerView.Adapter<SuspectAdapter1.ViewHolder> {
    private ArrayList<Suspect> dataList;
    public SuspectAdapter1(ArrayList<Suspect> dataList) {
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suspecthistorycard, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Suspect item = dataList.get(position);
        holder.tvi.setText("Suspect ID: " + item.getInvestigation_suspect_id());
        holder.textSuspectName.setText("Suspect Name: " + item.getFname()+item.getMname());
        holder.textSuspectDate.setText("Suspect Date: " + item.getDob());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Suspect2 s = new Suspect2();
                Bundle bundle = new Bundle();
                s.setArguments(bundle);
                bundle.putString("investigation_suspect_id",item.getInvestigation_suspect_id());
                activity.getSupportFragmentManager().beginTransaction().replace(R.id. container_main, s).addToBackStack(null).commit();
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvi, textSuspectName, textSuspectDate;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvi = itemView.findViewById(R.id.textSuspectId);
            textSuspectName = itemView.findViewById(R.id.textSuspectName);
            textSuspectDate = itemView.findViewById(R.id.textSuspectDate);
            cardView = itemView.findViewById(R.id.suspectCard);
        }
    }
}
