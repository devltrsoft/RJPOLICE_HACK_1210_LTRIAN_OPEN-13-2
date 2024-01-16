package com.ltrsoft.police_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.ltrsoft.police_app.fragment.login;

public class LoginAndRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_registration);
        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
        if (pref.getBoolean("flag",false)){
            Intent main_activity_intent = new Intent( LoginAndRegistrationActivity.this, MainActivity.class);
            startActivity(main_activity_intent);
        }
        else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.session_container, new login())
                    .commit();
}
    }
}