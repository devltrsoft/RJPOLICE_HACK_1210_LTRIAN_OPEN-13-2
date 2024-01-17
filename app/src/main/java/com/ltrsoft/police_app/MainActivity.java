package com.ltrsoft.police_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ltrsoft.police_app.fragment.NavigationDrawer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, new NavigationDrawer())
                .commit();
    }
}