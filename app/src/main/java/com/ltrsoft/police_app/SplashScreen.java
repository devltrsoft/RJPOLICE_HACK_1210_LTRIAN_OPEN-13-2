package com.ltrsoft.police_app;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);

                    SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    if (pref.getBoolean("flag",false)){
                        Intent main_activity_intent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(main_activity_intent);
                    }
                    else {
                        Intent login_activity_intent = new Intent(SplashScreen.this, LoginAndRegistrationActivity.class);
                        startActivity(login_activity_intent);
                    }
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }
}