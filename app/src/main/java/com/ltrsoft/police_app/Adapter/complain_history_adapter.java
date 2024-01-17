package com.ltrsoft.police_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.ltrsoft.police_app.Classes.complain_history_class;
import com.ltrsoft.police_app.R;

import java.util.ArrayList;

public class complain_history_adapter extends RecyclerView.Adapter<complain_history_adapter.ViewHolderr> {



    public ArrayList<complain_history_class> listcomplaint=new ArrayList<>();

    public complain_history_adapter(ArrayList< complain_history_class> listcomplaint) {
        this. listcomplaint =  listcomplaint;
    }
    @NonNull
    @Override
    public ViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_comlain_history_card,parent,false);
        return new ViewHolderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderr holder, int position) {
         complain_history_class complainHistoryClass =  listcomplaint.get(position);

        holder.name.setText( complainHistoryClass.getName());
        holder. complaint_desc.setText( complainHistoryClass.getComplaint_desc());
        holder. complaint_id.setText( complainHistoryClass.getComplaint_id());
    }

    @Override
    public int getItemCount() {
        return listcomplaint.size();
    }

    public class ViewHolderr extends RecyclerView.ViewHolder{
        private TextView name, complaint_desc, complaint_id;

        public ViewHolderr(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            complaint_desc=itemView.findViewById(R.id.information);
            complaint_id=itemView.findViewById(R.id.complaint_id);
        }
    }
}
