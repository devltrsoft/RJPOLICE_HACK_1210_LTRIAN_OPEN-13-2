package com.ltrsoft.police_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.Evidance;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Evidance2;
import com.ltrsoft.police_app.fragment.Evidance3;

import java.util.ArrayList;

public class EvidanceAdapter2 extends RecyclerView.Adapter<EvidanceAdapter2.viewholder>{

    private ArrayList<Evidance> dataList;

    public  EvidanceAdapter2(ArrayList<Evidance> dataList) {
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.evidancecard2,parent,false);
        return  new viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Evidance item = dataList.get(position);

        holder.tvi.setText("Evidence ID: " + item.getEvidance_id());
        holder.textEvidenceName.setText("Evidence Name: " + item.getEvidance_name());
        holder.textEvidenceDate.setText("Evidence Date: " + item.getDiscription());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                Evidance3  third = new Evidance3();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container_main, third).
                        addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
      private   TextView tvi, textEvidenceName, textEvidenceDate,changeddate;
        private  CardView cardView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            tvi = itemView.findViewById(R.id.textEvidenceId);
            textEvidenceName = itemView.findViewById(R.id.textEvidenceName);
            textEvidenceDate = itemView.findViewById(R.id.textEvidenceDate);
            changeddate=itemView.findViewById(R.id.textchangedEvidenceDate);
            cardView = itemView.findViewById(R.id.evidenceCard);
        }
    }
}
