package com.ltrsoft.police_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Witness3;

import java.util.ArrayList;


public class WitnessAdapter2 extends RecyclerView.Adapter<WitnessAdapter2.ViewHolder> {


    private ArrayList<Witness> dataList;

    public WitnessAdapter2(ArrayList<Witness> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.witnesssecondcard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Witness item = dataList.get(position);

        holder.tvi.setText("Witness ID: " + item.getInvestigation_witness_id());
        holder.textWitnessName.setText("Witness Name: " + item.getFname());
        holder.textWitnessDate.setText("Witness Date: " + item.getDob());
        holder.change_date.setText("Change_Date:"+item.getDob());
       holder.witnesscard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Witness3 witnessHistoryDates = new Witness3();
               activity.getSupportFragmentManager().beginTransaction().replace(R.id. main_container, witnessHistoryDates).addToBackStack(null).commit();

           }
       });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvi, textWitnessName, textWitnessDate,change_date;

     CardView witnesscard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvi = itemView.findViewById(R.id.id);
            textWitnessName = itemView.findViewById(R.id.name);
            textWitnessDate = itemView.findViewById(R.id.date);
            witnesscard=itemView.findViewById(R.id.wcard);
            change_date=itemView.findViewById(R.id.change_date);
        }
    }
}
