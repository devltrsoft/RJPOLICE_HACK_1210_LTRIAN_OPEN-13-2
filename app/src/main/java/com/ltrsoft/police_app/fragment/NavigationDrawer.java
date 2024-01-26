package com.ltrsoft.police_app.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.ltrsoft.police_app.LoginAndRegistrationActivity;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.dashboards.AdminDashBoard;
import com.ltrsoft.police_app.dashboards.Dashboard;

public class  NavigationDrawer extends Fragment {

    public NavigationDrawer() {
        // Required empty public constructor
    }

    public DrawerLayout drawerLayout;
    public Toolbar toolbar;
    public NavigationView navigationView;
    public ActionBarDrawerToggle toggle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.navigation_drawer, container, false);

        toolbar = view.findViewById(R.id.toolbar);
        Dashboard dashboardFragment = new Dashboard() ;

//        AdminDashBoard dashboardFragment = new AdminDashBoard();
        getFragmentManager().beginTransaction().replace(R.id.container_main, dashboardFragment).commit();
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);


        navigationView = view.findViewById(R.id.navigation);
        drawerLayout = view.findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getContext().getColor(R.color.white));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                if (id == R.id.home) {
                    getFragmentManager().beginTransaction().replace(R.id.container_main, dashboardFragment).addToBackStack(null).commit();
                }
                else if (id == R.id.profile) {
                   getFragmentManager().beginTransaction().replace(R.id.container_main, new ProfileDetail()).addToBackStack(null).commit();
                }else if (id == R.id.setting) {
                  getFragmentManager().beginTransaction().replace(R.id.container_main, new Setting()).addToBackStack(null).commit();
                }
                else if (id == R.id.logout) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Logout Dailoge");
                    builder.setMessage("Do You Want To Logout?");
                    builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SharedPreferences pref = getActivity().getSharedPreferences("login", MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putBoolean("flag", false)
                                    .apply();
                            editor.commit();
//                            getFragmentManager().beginTransaction().replace(R.id.main_container, new login()).commit();
                            Intent main_activity_intent = new Intent( getActivity(), LoginAndRegistrationActivity.class);
                                   startActivity(main_activity_intent);
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                            
                        }
                    });
                    builder.show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            }
        });
        return view;
    }

}