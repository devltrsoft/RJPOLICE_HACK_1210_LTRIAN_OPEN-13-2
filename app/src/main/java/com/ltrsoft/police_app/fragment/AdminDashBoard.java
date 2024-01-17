package com.ltrsoft.police_app.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.ineerfragments.Add_Complain_page;
import com.ltrsoft.police_app.ineerfragments.Emergancy_page;

public class AdminDashBoard extends Fragment {
    public AdminDashBoard() {    }

    private ImageView add_btn;
    private ImageView Cadd;
    private GoogleMap mMap;

    private BottomNavigationView adminBottomDashNav;
    private FloatingActionButton socialMedia,camera,missing;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.admin, container, false);
        adminBottomDashNav=view.findViewById(R.id.Admin_menu);
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.Admin_dashboard, new Emergancy_page()).commit();
//        add_btn1 = view.findViewById(R.id.cadd);
        Cadd=view.findViewById(R.id.cadd);
        socialMedia = view.findViewById(R.id.social_media);
        camera = view.findViewById(R.id.camera_btn);
        missing = view.findViewById(R.id.missing_btn);
            Cadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_Complain_page add_complain_page = new Add_Complain_page();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Admin_dashboard, add_complain_page).commit();
            }
        }
       );

        adminBottomDashNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.ecall) {
//                    Toast.makeText(getContext(), "Ecall Clicked", Toast.LENGTH_SHORT).show();
                    Emergancy_page emergencyPage = new Emergancy_page();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Admin_dashboard, emergencyPage).commit();

                } else if (id == R.id.ecomplaint) {
                    Toast.makeText(getContext(), "Compalint Clicked", Toast.LENGTH_SHORT).show();
//                    AdminPages adminAthority = new AdminPages();
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Admin_dashboard, adminAthority).commit();
                } else if (id == R.id.enews) {
//                    Toast.makeText(getContext(), "News", Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id. container_main,  new News_page()).addToBackStack(null).commit();
                } else if (id == R.id.message) {
//                    Toast.makeText(getContext(), " selection clicked", Toast.LENGTH_SHORT).show();
                    // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_main,  new Selection_page()).addToBackStack(null).commit();
                }
                return false;
            }
        });
        socialMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://ltr-soft.com/"));
                startActivity(intent);
            }
        });

        missing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_main,
                                new Missing_pages()).addToBackStack(null).commit();
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_main,
                                new Camera()).addToBackStack(null).commit();
            }
        });

        return view;
    }
}