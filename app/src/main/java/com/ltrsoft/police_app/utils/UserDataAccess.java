package com.ltrsoft.police_app.utils;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.SharedPreferences;

public class UserDataAccess {
    public String getPoliceId(Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        return pref.getString("userID",null);
    }

    public void setPoliceId(String userId, Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("userID", userId)
                .apply();
    }

    public String getStationId(Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        return pref.getString("station_id",null);
    }

    public void setStationId(String stationId, Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("station_id", stationId)
                .apply();
    }
    public String   getuser(  Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        return pref.getString("user",null);
    }

    public void  setuser(String user, Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("user", user)
                .apply();
    }
    public String   getFir_id(  Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        return pref.getString("Fir_id",null);
    }

    public void  setFir_id(String Fir_id, Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("Fir_id", Fir_id)
                .apply();
    }

//    public String getPoliceId(Activity activity) {
//        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
//        return pref.getString("station_id",null);
//    }
//
//    public void setPoliceId(String stationId, Activity activity) {
//
//        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putString("station_id", stationId)
//                .apply();
//    }
}
