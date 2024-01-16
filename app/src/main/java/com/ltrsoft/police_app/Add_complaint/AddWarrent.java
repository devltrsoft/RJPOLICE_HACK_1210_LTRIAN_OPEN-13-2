package com.ltrsoft.police_app.Add_complaint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.ltrsoft.police_app.Classes.Criminal;
import com.ltrsoft.police_app.Classes.Warrant;
import com.ltrsoft.police_app.Model.WarrantDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class AddWarrent extends Fragment {

    public AddWarrent() {}
    public EditText Discription,authority,judician,issued_date,fname,caseIDs,court_name;
    public Spinner Warrant_Type;
    public String desc,auth,judic,idate,name,cases,warrenttype;
    public ArrayAdapter<String> adapter ;
    public ArrayList list = new ArrayList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.add_warrent, container, false);
        Warrant_Type = view.findViewById(R.id.Warrant_Type);
        Discription = view.findViewById(R.id.Discription);
        authority = view.findViewById(R.id.authority);
        judician = view.findViewById(R.id.judician);
        issued_date = view.findViewById(R.id.issued_date);
        fname = view.findViewById(R.id.fname);
        caseIDs = view.findViewById(R.id.caseIDs);
        court_name=view.findViewById(R.id.court_name);

        setAdapterr();

        desc = Discription.getText().toString();
        auth = authority.getText().toString();
        judic = judician.getText().toString();
        idate = issued_date.getText().toString();
        cases = caseIDs.getText().toString();
//        warrenttype = Warrant_Type.getSelectedItem().toString();
//      String  court_name1=court_name.getText().toString();
//       String fname1=fname.getText().toString();
//       String case_id=caseIDs.getText().toString();
//        int parsedCaseId = Integer.parseInt(case_id);
//      int warrant_type_id=Integer.parseInt(warrenttype);
//        WarrantDeo warrantDeo1=new WarrantDeo();
//        warrantDeo1.createwarrant(new Warrant(parsedCaseId, warrant_type_id, fname1, cases, idate, judic, auth, desc, court_name1), getContext(), new Callback() {
//            @Override
//            public void onSuccess(Object obj) {
//
//            }
//
//            @Override
//            public void onErro(String errro) {
//
//            }
//        });
////
//

        return view;
    }
    private void setAdapterr() {
        list.add("Warrent 1");
        list.add("Warrent 1");
        list.add("Warrent 1");
        list.add("Warrent 1");
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,list);
    }
}