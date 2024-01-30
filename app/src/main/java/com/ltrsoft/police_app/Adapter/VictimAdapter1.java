package com.ltrsoft.police_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.Victim;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Victim2;

import java.util.ArrayList;

public class VictimAdapter1 extends RecyclerView.Adapter<VictimAdapter1.ViewHolder> {

    private ArrayList<Victim> dataList;

    public VictimAdapter1(ArrayList<Victim> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.victimhistorycard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Victim item = dataList.get(position);
        holder.tvi.setText("Victim ID: " + item.getInvestigation_victim_id());
        holder.textVictimName.setText("Victim Name: " + item.getFname());
        holder.textVictimDate.setText("Victim Date: " + item.getDob());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Victim2 victim2 = new Victim2();
                //Toast.makeText(activity, "go to victime", Toast.LENGTH_SHORT).show();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id. container_main, victim2).addToBackStack(null)
                        .commit();
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvi, textVictimName, textVictimDate;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvi = itemView.findViewById(R.id.textVictimId);
            textVictimName = itemView.findViewById(R.id.textVictimName);
            textVictimDate = itemView.findViewById(R.id.textVictimDate);
            cardView = itemView.findViewById(R.id.victimCard);
        }
    }
}
