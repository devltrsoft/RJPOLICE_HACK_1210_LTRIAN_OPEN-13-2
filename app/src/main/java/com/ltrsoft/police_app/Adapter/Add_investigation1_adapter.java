package com.ltrsoft.police_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.R;

public class Add_investigation1_adapter extends RecyclerView.Adapter <Add_investigation1_adapter.viewholder>{


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.add_investigation1_card,parent,false);

     return new viewholder(view);

     }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class viewholder extends RecyclerView.ViewHolder{

        public viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
