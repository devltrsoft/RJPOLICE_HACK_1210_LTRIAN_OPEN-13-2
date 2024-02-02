package com.ltrsoft.police_app.utils;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.SharedPreferences;

public class IsAdmin {
    public Boolean isAdmin(Activity activity){
        SharedPreferences pref = activity.getSharedPreferences("login", MODE_PRIVATE);
        boolean b = pref.getBoolean("Admin",false);
        return b;
    }
    public void setAdmin(Activity activity,Boolean b){
        SharedPreferences pref = activity.getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("Admin", b)
                .apply();
    }

}
