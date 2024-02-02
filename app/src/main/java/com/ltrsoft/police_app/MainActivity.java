package com.ltrsoft.police_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.ltrsoft.police_app.fragment.NavigationDrawer;
import com.ltrsoft.police_app.fragment.login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if (pref.getBoolean("flag", true)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id. main_container, new NavigationDrawer())

                    .commit();


        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new login())

                    .commit();
        }
    }

}