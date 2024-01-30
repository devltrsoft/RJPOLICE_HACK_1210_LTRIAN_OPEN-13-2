package com.ltrsoft.police_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ltrsoft.police_app.fragment.NavigationDrawer;
import com.ltrsoft.police_app.fragment.login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        // Get the data from the Intent
//        if (intent.hasExtra("user")) {
//            String message = intent.getStringExtra("user");
//            NavigationDrawer navigationDrawer = new NavigationDrawer();
//            Bundle bundle = new Bundle();
//            bundle.putString("user", message);
//            navigationDrawer.setArguments(bundle);
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.main_container, new login())
//                    .commit();
//        }
//        else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container,new login())
                    // .replace(R.id.main_container,new NavigationDrawer())

                    .commit();
        //}
    }

}