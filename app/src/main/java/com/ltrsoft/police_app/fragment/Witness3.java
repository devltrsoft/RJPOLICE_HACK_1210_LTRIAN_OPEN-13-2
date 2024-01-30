package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ltrsoft.police_app.R;
import com.squareup.picasso.Picasso;

public class Witness3 extends Fragment {
    public Witness3() {}
    private TextView wid, wfname, wmname, wlname, waddress, wdob,wgender,wsub,email;
    private TextView city_name,country_name,state_name,district_name,adhar;

    private ImageView imageView;
    private Button button;

   private Button close;
    private ImageView back;
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
        if (bundle != null) {
            wfname.setText(bundle.getString("witnessfame"));
            wmname.setText(bundle.getString("witnessfame"));
            wlname.setText(    bundle.getString("witnessmame"));
            waddress.setText(  bundle.getString("witnesslame"));
            wdob.setText(  bundle.getString("witnessfame"));
            wgender.setText(  bundle.getString("complaint_witness_gender"));
            wsub.setText(   bundle.getString("complaint_witness_mobile"));
            email.setText( bundle.getString("complaint_witness_email"));
            city_name.setText( bundle.getString("city_name"));
            country_name.setText( bundle.getString("country_name"));
            state_name.setText( bundle.getString("state_name"));
            district_name.setText( bundle.getString("district_name"));

            String imageUrl = bundle.getString("imag");
            if (imageUrl != null) {
                Picasso.get().load(imageUrl).into(imageView);
            }
        }
    return v;
    }
}