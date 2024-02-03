package com.ltrsoft.police_app.Adapter;

import android.os.Bundle;
import android.util.Log;
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

import com.ltrsoft.police_app.fragment.AddSuspect;
import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Suspect3;


import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ISuspectAdapter extends RecyclerView.Adapter<ISuspectAdapter.ViewHolder> {



    public ArrayList<Suspect>listsuspect=new ArrayList<>();
    public boolean flag=false;

    public ISuspectAdapter(ArrayList<Suspect> listsuspect) {
        this.listsuspect = listsuspect;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_investigation_suspect_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         Suspect iSuspectClass = listsuspect.get(position);

        holder.name.setText(iSuspectClass.getFname());
        holder.phone.setText(iSuspectClass. getMobile());
        holder.location.setText(iSuspectClass. getAddress());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                if (activity != null) {
                    Suspect3 suspect3 = new Suspect3();
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("suspect_id", iSuspectClass.getComplaint_suspect_id());
                    bundle1.putString("type","complaints" );
                    suspect3.setArguments(bundle1);
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_main, suspect3)
                            .commit();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listsuspect.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name,location,phone;
         public CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.person_name);
            location = itemView.findViewById(R.id.person_location);
            phone = itemView.findViewById(R.id.person_contact);
             cardView = itemView.findViewById(R.id.person_card);
        }
    }
}
