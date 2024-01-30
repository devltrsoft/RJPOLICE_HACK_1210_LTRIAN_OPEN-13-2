package com.ltrsoft.police_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.AllotedCaseHistoryClass;
import com.ltrsoft.police_app.Classes.Complaint;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Alloted_case2;

import java.util.ArrayList;

public class AllotedCaseAdapter1 extends RecyclerView.Adapter<AllotedCaseAdapter1.ViewHolder> {

    private ArrayList<AllotedCaseHistoryClass> dataList;

    public AllotedCaseAdapter1(ArrayList<AllotedCaseHistoryClass> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allowedcasecard1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         AllotedCaseHistoryClass item = dataList.get(position);

        holder.tvi.setText("Complaint ID: " + item.  getId());
         holder.crimetype.setText(" crime type: " + item.getComplaint_type());
         holder.victim_name.setText("Victim Name :  "+item.getName());
         holder.address.setText("Address :   " +item.getAddress() );
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Alloted_case2 secondFragment = new Alloted_case2();

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container_main, secondFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
      private   TextView tvi, address, victim_name,crimetype;
      private   CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvi = itemView.findViewById(R.id.textCaseId);
            address = itemView.findViewById(R.id.textCaseName);
            victim_name = itemView.findViewById(R.id.textCaseDate);
            crimetype=itemView.findViewById(R.id.crimetype);
            cardView = itemView.findViewById(R.id.alloedcasecard);
        }
    }
}
