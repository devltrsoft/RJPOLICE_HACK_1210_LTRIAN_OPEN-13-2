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
import com.ltrsoft.police_app.fragment.Suspect3;

import java.util.ArrayList;

public class SuspectAdapter2 extends RecyclerView.Adapter<SuspectAdapter2.ViewHolder> {
    private ArrayList<Suspect> dataList;

    public SuspectAdapter2(ArrayList<Suspect> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suspectsecondycard, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Suspect item = dataList.get(position);
        holder.tvi.setText("Suspect ID: " + item.getInvestigation_suspect_id());
        holder.textSuspectName.setText("Suspect Name: " + item.getFname());
        holder.textSuspectDate.setText("Suspect Date: " + item.getDob());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Suspect3 s = new Suspect3();
                Bundle bundle=new Bundle();
                 bundle.putString("suspect_id",  "3");
//                bundle.putString("name", item.getFname());
//                bundle.putString("gender",item.getGender());
//                bundle.putString("mobile",item.getMobile());
//                bundle.putString("email",item.getEmail());
//                bundle.putString("adhar",item.getAdhar());
//                bundle.putString("cname",item. getCountry());
//                bundle.putString("dname",item. getDistrict());
//                bundle.putString("sname",item.getState());
                s.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container_main, s).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvi, textSuspectName, textSuspectDate,change_date;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvi = itemView.findViewById(R.id.SuspectId);
            textSuspectName = itemView.findViewById(R.id.SuspectName);
            textSuspectDate = itemView.findViewById(R.id.SuspectDate);
            change_date=itemView.findViewById(R.id.change_date);
            cardView = itemView.findViewById(R.id.scard);
        }
    }
}
