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
        Witness  model = dataList.get(position);

        holder.tvi.setText("Witness ID: " + model.getInvestigation_witness_id());
        holder.textWitnessName.setText("Witness Name: " + model.getFname());
        holder.textWitnessDate.setText("Witness Date: " + model.getDob());
        holder.change_date.setText("Change_Date:"+model.getDob());
       holder.witnesscard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Witness3 witness3 = new Witness3();
               Bundle bundle = new Bundle();
               bundle.putString("witness_id", "1");
               bundle.putString("type", "investigation");
//               args.putString("witnessfame", model. getFname());
//               args.putString("witnessmame", model. getMname());
//               args.putString("witnesslame", model.getLname());
//               args.putString("complaint_witness_gender", model.getGender());
//               args.putString("complaint_witness_mobile", model.getMobile());
//               args.putString("complaint_witness_email", model.getEmail());
//               args.putString("complaint_witness_adhar", model.getAdhar());
//               args.putString("complaint_witness_address", model.getAddress());
//               args.putString("city_name", model.getCity());
//               args.putString("country_name", model.getCountry());
//               args.putString("state_name", model.getState());
//               args.putString("district_name", model.getDistrict());
               witness3.setArguments(bundle);
               activity.getSupportFragmentManager().beginTransaction().replace(R.id. container_main, witness3).addToBackStack(null).commit();

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
