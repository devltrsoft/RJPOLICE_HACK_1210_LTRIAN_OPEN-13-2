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

import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Witness2;

import java.util.ArrayList;

public class WitnessAdapter1 extends RecyclerView.Adapter<WitnessAdapter1.ViewHolder> {

    private ArrayList<Witness> dataList;

    public WitnessAdapter1(ArrayList<Witness> dataList) {
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.witnesshistorycard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Witness item = dataList.get(position);

        holder.tvi.setText("Witness ID: " + item.getInvestigation_witness_id());
        holder.textWitnessName.setText("Witness Name: " + item.getFname());
        holder.textWitnessDate.setText("Witness Date: " + item.getDob());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Bundle bundle = new Bundle();
                bundle.putString("witness_id", "1");
                Witness2 witnessSecond = new Witness2();
                witnessSecond.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id. container_main, witnessSecond).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvi, textWitnessName, textWitnessDate;

        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvi = itemView.findViewById(R.id.textWitnessId);
            textWitnessName = itemView.findViewById(R.id.textWitnessName);
            textWitnessDate = itemView.findViewById(R.id.textWitnessDate);
            cardView = itemView.findViewById(R.id.witnessCard);
        }
    }
}
