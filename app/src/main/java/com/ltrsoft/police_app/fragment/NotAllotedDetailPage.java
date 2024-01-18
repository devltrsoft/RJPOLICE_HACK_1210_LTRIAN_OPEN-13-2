package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


import com.ltrsoft.police_app.R;

import java.util.ArrayList;

public class NotAllotedDetailPage extends Fragment {
 public NotAllotedDetailPage() {    }
    public TextView cmpoid,crimetype;
 public Spinner police;
 public Button allot;
 ArrayList <String> list = new ArrayList<>();
 ArrayAdapter adapter ;
  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alloted_detail_page, container, false);
     Bundle bundle =getArguments();
     cmpoid.setText(bundle.getString("case_id"));
        cmpoid = view.findViewById(R.id.complainid);
        crimetype = view.findViewById(R.id.crimetype);
        police = view.findViewById(R.id.availbalepolice);
        allot = view.findViewById(R.id.allotbtn);

        list.add("Encounter Specialist");
        list.add("SI Daya");
        list.add("ACP Padyuman");
      list.add("SI Daya");
      list.add("Encounter Specialist");
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1,list);
        adapter.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
        police.setAdapter(adapter);

allot.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(), "Police Alloted", Toast.LENGTH_SHORT).show();
    }
});
      return view;
    }
}