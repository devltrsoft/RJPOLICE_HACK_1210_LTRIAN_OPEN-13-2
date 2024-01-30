package com.ltrsoft.police_app.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_app.Classes.Criminal;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Criminal2;

import java.util.ArrayList;

public class CriminalAdapter extends RecyclerView.Adapter<CriminalAdapter.viewholder> {
    private ArrayList<Criminal> dataList;

    public CriminalAdapter(ArrayList< Criminal> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.criminal_history_card_view, parent, false);

      return new viewholder(view);
     }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Criminal item = dataList.get(position);
        holder.criminal_name.setText("criminal Name  " + item.getFname());
        holder.crime_date.setText("crime_date: " + item.getDob());
        holder.case_id.setText(" Criminal ID: " + item. getCriminal_id());
        holder.crime_type.setText(" Criminal Complaint ID "+item.getCriminal_complaint_id());
        holder.criminal_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Criminal2 criminal2 = new Criminal2();
                Bundle b=new Bundle();
                String criminal_id=  item.getCriminal_id();
                String  criminal_name=  item.getFname();
                  String address=item.getAddress();
                  String contatct=item.getMobile();
                  String dob=item.getDob();
                  String email=item.getEmail();
                  String adhar=item.getAdhar();
                  String caseId=item.getCriminal_complaint_id();

                  String gender=item.getGender();
                  String country=item.getCountry();
                  String state=item.getState();
                  String district=item.getDistrict();
                  String city=item.getCity();
                b.putString("criminal_id",criminal_id);
                b.putString("criminal_name", criminal_name );
                b.putString("address",address);
                b.putString("contatct",contatct);
                b.putString("dob",dob);
                b.putString("email",email);
                b.putString("adhar",adhar);
                b.putString("caseId",caseId);
                b.putString("gender",gender);
                b.putString("country",country);
                b.putString("state",state);
                b.putString("district",district);
                b.putString("city",city);


                criminal2.setArguments(b);
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
              //  Toast.makeText(activity, "go to  criminal", Toast.LENGTH_SHORT).show();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id. container_main, criminal2).addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
    private TextView case_id,crime_type,criminal_name,crime_date;
    private CardView criminal_card;

    public viewholder(@NonNull View itemView) {
        super(itemView);
        case_id=itemView.findViewById(R.id.case_id);
         crime_type=itemView.findViewById(R.id.crime_type);
         criminal_name=itemView.findViewById(R.id.Criminal_Name);
        crime_date=itemView.findViewById(R.id.crime_date);
        criminal_card=itemView.findViewById(R.id.Criminal_card);
    }
}
}
