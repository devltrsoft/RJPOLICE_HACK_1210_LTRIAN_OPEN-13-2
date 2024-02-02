package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.Model.WitnessDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Witness3 extends Fragment {
    public Witness3() {}
    private TextView wid, wfname, wmname, wlname, waddress, wdob,wgender,wsub,email;
    private TextView city_name,country_name,state_name,district_name,adhar;

    private ImageView imageView;
    private Button button;

   private Button close;
    private ImageView back;
    public ArrayList<Witness>list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v= inflater.inflate(R.layout.witness__history__dates, container, false);
         ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Witness History Detail");
        }

        wid = v.findViewById(R.id.cidno);
        wfname = v.findViewById(R.id.fname);
        wmname =v.findViewById(R.id.mname);
        wlname=v.findViewById(R.id.lname);
        waddress = v.findViewById(R.id.address);
        wdob = v.findViewById(R.id.dob);
        wgender = v.findViewById(R.id.gender);
        wsub = v.findViewById(R.id.mobile);
        email = v.findViewById(R.id.email);
         imageView = v.findViewById(R.id.Profile_pic);
        city_name = v.findViewById(R.id.city);
        country_name = v.findViewById(R.id.country);
        state_name = v.findViewById(R.id.state);
        district_name = v.findViewById(R.id.district);
        adhar = v.findViewById(R.id.addhar);
        Bundle bundle = getArguments();

        if (bundle.getString("type").equals("investigation")) {
            String id = bundle.getString("witness_id");
            Toast.makeText(getContext(), "from investigetion" + id, Toast.LENGTH_SHORT).show();
            WitnessDeo witnessDeo = new WitnessDeo();
            witnessDeo.getOneWitness(id, getContext(), new Callback() {
                @Override
                public void onSuccess(Object obj) {
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                    list= (ArrayList<Witness>) obj;
                    Witness witness = list.get(0);
                    wfname.setText(witness.getFname());
                    wmname.setText(witness.getMname());
                    wlname.setText(witness.getLname());
                    waddress.setText( witness.getAddress());
                    wdob.setText(witness.getDob());
                    wgender.setText( witness. getGender());
                    wsub.setText(  witness. getMobile());
                    email.setText( witness.getEmail());
                    city_name.setText(witness. getCity());
                    country_name.setText(witness.getCountry());
                    state_name.setText(witness. getState());
                    district_name.setText( witness.getDistrict());

                    String imageUrl = bundle.getString("imag");
                    if (imageUrl != null) {
                        Picasso.get().load(imageUrl).into(imageView);
                    }

                }

                @Override
                public void onErro(String errro) {
                    Toast.makeText(getContext(), "error "+errro.toString(), Toast.LENGTH_SHORT).show();
                }
            });

        } else if (bundle.getString("type").equals("complaints")) {

        Toast.makeText(getContext(), "from complaints", Toast.LENGTH_SHORT).show();
    }

//        if (bundle != null) {
//
//        }
    return v;
    }
}