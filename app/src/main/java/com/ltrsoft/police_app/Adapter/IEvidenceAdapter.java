package com.ltrsoft.police_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.Evidance;
import com.ltrsoft.police_app.R;

import java.util.ArrayList;

public class IEvidenceAdapter extends RecyclerView.Adapter<IEvidenceAdapter.ViewHolder> {
    public ArrayList<Evidance>list;
    public boolean flag=false;

    public IEvidenceAdapter(ArrayList<Evidance> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ievidencecard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         Evidance iEvidenceClass = list.get(position);
//        holder.desc.setText(iEvidenceClass.getEvidence());
       holder.evidenceimg.setImageResource(iEvidenceClass.getEvidance_id());
        holder.nonsusupect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag){
                    holder.nonsusupect.setText("Evidance");
                    Toast.makeText(view.getContext(), "Suspect is being non suspect", Toast.LENGTH_SHORT).show();
                    flag = false;
                }
                else {
                    holder.nonsusupect.setText("Non Evidance");
                    Toast.makeText(view.getContext(), "Suspect is suspect", Toast.LENGTH_SHORT).show();
                    flag=true;
                }            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = new AppCompatActivity();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new ).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView desc;
        public Button nonsusupect;
        public ImageView evidenceimg;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            desc = itemView.findViewById(R.id.person_name);
            nonsusupect = itemView.findViewById(R.id.Non_Suspect);
            evidenceimg = itemView.findViewById(R.id.person_pic);
            cardView = itemView.findViewById(R.id.person_card);


        }
    }


}
