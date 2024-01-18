package com.ltrsoft.police_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.NotAllotedCaseClass;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.NotAllotedDetailPage;

import java.util.ArrayList;

public class NotAllotedCasesAdapter extends RecyclerView.Adapter<NotAllotedCasesAdapter.ViewHolder> {

    public ArrayList <NotAllotedCaseClass>list;

    public NotAllotedCasesAdapter(ArrayList<NotAllotedCaseClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.not_alloted_case_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotAllotedCaseClass notAllotedCaseClass = list.get(position);
        holder.cid.setText(notAllotedCaseClass.getComplainid());
        holder.crimetype.setText(notAllotedCaseClass.getCrimetype());
        holder.notallotcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new NotAllotedDetailPage()).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView notallotcard;
        public TextView cid,crimetype;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cid = itemView.findViewById(R.id.cid);
            crimetype = itemView.findViewById(R.id.crimetype);
            notallotcard = itemView.findViewById(R.id.not_alloted_card);
        }
    }
}
