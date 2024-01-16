package com.ltrsoft.police_app.Add_complaint.Investigation_adapter;

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

import com.ltrsoft.police_app.Add_complaint.AddSuspect;
import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.R;


import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ISuspectAdapter extends RecyclerView.Adapter<ISuspectAdapter.ViewHolder> {
    private WeakReference<AppCompatActivity> activityReference;

    public ISuspectAdapter(AppCompatActivity activity) {
        this.activityReference = new WeakReference<>(activity);
    }
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

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activityReference != null && activityReference.get() != null) {
                    AppCompatActivity activity = activityReference.get();

                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_container, new AddSuspect())
                            .addToBackStack(null)
                            .commit();
//                Toast.makeText(view.getContext(), "", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.nonsusupect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag){
                    holder.nonsusupect.setText("Suspect");
                    Toast.makeText(view.getContext(), "Suspect is being non suspect", Toast.LENGTH_SHORT).show();
                    flag = false;
                }
                else {
                    holder.nonsusupect.setText("Non Suspect");
                    Toast.makeText(view.getContext(), "Suspect is suspect", Toast.LENGTH_SHORT).show();
                    flag=true;
                }
            }
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
        return listsuspect.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name,location,phone;
        public Button nonsusupect;
        public ImageView edit;
        public CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.person_name);
            location = itemView.findViewById(R.id.person_location);
            phone = itemView.findViewById(R.id.person_contact);
            nonsusupect = itemView.findViewById(R.id.Non_Suspect);
            edit = itemView.findViewById(R.id.Edit_profile);
            cardView = itemView.findViewById(R.id.person_card);
        }
    }
}
