package com.ltrsoft.police_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.Complaint;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Alloted_case2;

import java.util.ArrayList;

public class AllotedCaseAdapter1 extends RecyclerView.Adapter<AllotedCaseAdapter1.ViewHolder> {

    private ArrayList<Complaint> dataList;

    public AllotedCaseAdapter1(ArrayList<Complaint> dataList) {
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
         Complaint item = dataList.get(position);

        holder.tvi.setText("Case ID: " + item. getComplain_id());
         holder.textCaseDate.setText("Case Date: " + item.getIncident_date());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Alloted_case2 secondFragment = new Alloted_case2();

                activity.getSupportFragmentManager().beginTransaction().replace(R.id. main_container, secondFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvi, textCaseName, textCaseDate;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvi = itemView.findViewById(R.id.textCaseId);
            textCaseName = itemView.findViewById(R.id.textCaseName);
            textCaseDate = itemView.findViewById(R.id.textCaseDate);
            cardView = itemView.findViewById(R.id.alloedcasecard);
        }
    }
}
