package com.ltrsoft.police_app.Model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.police_app.interface1.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpinnerDeo {
    private ArrayList <String> list=new ArrayList();
    private ArrayList <String> listofstate=new ArrayList();
    private ArrayList <String> listofdistrict=new ArrayList();
    private ArrayList <String>  citylist=new ArrayList();

    public static  final String URL1 ="https://rj.ltr-soft.com/public/police_api/country/select_country.php ";
    public static  final String URL2 ="https://rj.ltr-soft.com/public/police_api/state/select_state.php";
    public static  final String URL3 ="https://rj.ltr-soft.com/public/police_api/district/select_district.php";
    public static final String city_url="https://rj.ltr-soft.com/public/police_api/city/select_city.php";

    public static RequestQueue queue;
    public Context context;
    public SpinnerDeo(Context context) {
        this.context = context;
        queue = Volley.newRequestQueue(context);
    }
    public  void getCountryAdapter(Context context, Callback callback){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, URL1, null,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            Log.d("response",response.toString());
                            JSONObject jsonObject = response.getJSONObject(i);
                            String name = jsonObject.getString("country_name");
                            list.add(name);
                        } catch (JSONException e) {
                           // e.printStackTrace();
                      callback.onErro(e.toString());
                        }}
                    callback.onSuccess(list);
                }

            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            callback.onErro(error.toString());
            //System.out.println("Volley Error "+error.toString());
        }
    }
    );
    queue = Volley.newRequestQueue(context);
    queue.add(jsonArrayRequest);
 }

public void getStateList(int no,Context context,Callback callback){
    StringRequest stringRequest1 = new StringRequest(Request.Method.POST, URL2, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
//                            Toast.makeText(MainActivity.this, "response = "+response.toString(), Toast.LENGTH_SHORT).show();
//                            System.out.println("response = "+response.toString());
            try {
                JSONArray jsonArray = new JSONArray(response);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    listofstate.add(jsonArray.getJSONObject(i).getString("state_name"));
                }
            } catch (JSONException e) {
                callback.onErro(e.toString());

            }
            callback.onSuccess(listofstate);

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
        callback.onErro(error.toString());
         }
    }) {
        @Nullable
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("country_id","1");
//            String id = String.valueOf(no);
//            hashMap.put("country_id",id);
            return hashMap;
        }
    };
    queue.add(stringRequest1);
 }

public void getDistrict(int no,Context context,Callback callback){
    StringRequest stringRequest2 = new StringRequest(Request.Method.POST, URL3, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            //    Toast.makeText(MainActivity.this, "response = "+response.toString(), Toast.LENGTH_SHORT).show();
            //  System.out.println("response = "+response.toString());
            String district_name;
            try {
                JSONArray jsonArray = new JSONArray(response);
                //   Toast.makeText(MainActivity.this, "statecode = "+statecode.get(i), Toast.LENGTH_SHORT).show();
                for (int i=0;i<jsonArray.length();i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    district_name = jsonObject.getString("district_name");
                    String district_id = jsonObject.getString("district_id");
                    listofdistrict.add(district_name);
                }
            } catch (JSONException e) {
               callback.onErro(e.toString());
                // throw new RuntimeException(e);
            }
            callback.onSuccess(listofdistrict);
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
      // Log.d("error ",error.toString());
        callback.onErro(error.toString());
        }
    }){
        @Nullable
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("state_id","1");
//            hashMap.put("state_id",String.valueOf(no));
            return hashMap;
        }
    };
    queue.add(stringRequest2);
 }

    public void getCity(int no,Context context,Callback callback){
        StringRequest stringRequest2 = new StringRequest(Request.Method.POST, city_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //    Toast.makeText(MainActivity.this, "response = "+response.toString(), Toast.LENGTH_SHORT).show();
                //  System.out.println("response = "+response.toString());
                String  city_name;
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    //   Toast.makeText(MainActivity.this, "statecode = "+statecode.get(i), Toast.LENGTH_SHORT).show();
                    for (int i=0;i<jsonArray.length();i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        city_name = jsonObject.getString("city_name");
                       // String district_id = jsonObject.getString("district_id");
                        citylist.add(city_name);
                    }
                } catch (JSONException e) {
                    callback.onErro(e.toString());
                    // throw new RuntimeException(e);
                }
                callback.onSuccess(listofdistrict);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Log.d("error ",error.toString());
                callback.onErro(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("district_id","1");
//            hashMap.put("state_id",String.valueOf(no));
                return hashMap;
            }
        };
        queue.add(stringRequest2);
    }
}
