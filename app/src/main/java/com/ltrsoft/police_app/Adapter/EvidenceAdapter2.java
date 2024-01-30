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

import com.ltrsoft.police_app.Classes.Evidance;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Evidance2;
import com.ltrsoft.police_app.fragment.Evidance3;

import java.util.ArrayList;

public class EvidenceAdapter2 extends RecyclerView.Adapter<EvidenceAdapter2.ViewHolder> {

    private ArrayList<Evidance> dataList;

    public EvidenceAdapter2(ArrayList<Evidance> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evidence_card_view_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Evidance item = dataList.get(position);

        holder.textEvidenceId.setText("Evidence ID: " + item.getEvidance_id());
        holder.textEvidenceName.setText("Evidence Name: " + item.getEvidance_name());
        holder.textEvidenceDate.setText("Evidence Date: " + item.getDate());
        holder.textEvidenceChangeDate.setText("EvidenceChangeDate"+item.getChangeDate());

        holder.evidenceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Success", Toast.LENGTH_SHORT).show();
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Evidance3 thirdFragment = new Evidance3();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_main, thirdFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textEvidenceId, textEvidenceName, textEvidenceDate,textEvidenceChangeDate;
        CardView evidenceCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textEvidenceId = itemView.findViewById(R.id.textEvidenceId);
            textEvidenceName = itemView.findViewById(R.id.textEvidenceName);
            textEvidenceDate = itemView.findViewById(R.id.textEvidenceDate);
            textEvidenceChangeDate=itemView.findViewById(R.id.changedate);
            evidenceCard = itemView.findViewById(R.id.evidenceCard);

        }
    }
}
