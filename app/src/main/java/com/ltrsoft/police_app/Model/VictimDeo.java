package com.ltrsoft.police_app.Model;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
 import com.ltrsoft.police_app.Classes.Victim;
import com.ltrsoft.police_app.interface1.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VictimDeo {

    String investigation_id,victim_id;
    Victim victimtone;
    Victim create_victim;
    Victim update_victim;
    Victim delete_victim;
    String Police_id="1";
    String getoneVictim_URL="";

    String Search_URL="";
    String delete_URL="";

    String createvictim_url="https://rj.ltr-soft.com/public/police_api/investigation_victim/create_investigation_victim.php";
    String updatvictim_url="https://rj.ltr-soft.com/public/police_api/investigation_victim/update_investigation_victim.php";
    String getAllvictim_URL="https://rj.ltr-soft.com/public/police_api/Investigation_suspect/read_investigation_suspect.php";
    String searcgUrl="";
    public ArrayList<Victim> list = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();
    public ArrayList<Victim> getAllVictim(String fir_id, Context context) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, getAllvictim_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String country = jsonObject.getString("country_name");

                                String state = jsonObject.getString("state_name");
                                String district = jsonObject.getString("district_name");
                                String city = jsonObject.getString("city_name");
                                String fname = jsonObject.getString("victim_fname");
                                String mname = jsonObject.getString("victim_mname");
                                String lname = jsonObject.getString("victim_lname");
                                String address = jsonObject.getString("victim_address");

                                String dob = jsonObject.getString("victim_dob");
                                String email = jsonObject.getString("victim_email");
                                String adhar = jsonObject.getString("victim_adhar");
                                String gender = jsonObject.getString("victim_gender");

                                String photo_path = jsonObject.getString("victim_photo");
                                String pan = jsonObject.getString("victim_mobile_no");
                                String mobile = jsonObject.getString("victim_mobile_no");
                                String is_suspect = jsonObject.getString("is_i_victim");
                                int fir_id = jsonObject.getInt("fir_id");
                                int investigation_suspect_id = jsonObject.getInt("investigation_victim_id");
                                list.add(new Victim(country, state, district, city, fname, mname, lname, address,
                                        dob, email, adhar, gender,
                                        photo_path, pan, mobile, is_suspect,
                                        fir_id, investigation_suspect_id));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("fir_id", fir_id);


                return map;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return list;
    }


    public Victim getonevictim(int investigation_suspect_id, Context context ){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, getoneVictim_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String country = jsonObject.getString("country_name");


                                String state = jsonObject.getString("state_name");
                                String district = jsonObject.getString("district_name");
                                String city = jsonObject.getString("city_name");
                                String fname = jsonObject.getString("victim_fname");
                                String mname = jsonObject.getString("victim_mname");
                                String lname = jsonObject.getString("victim_lname");
                                String address = jsonObject.getString("victim_address");

                                String dob = jsonObject.getString("victim_dob");
                                String email = jsonObject.getString("victim_email");
                                String adhar = jsonObject.getString("victim_adhar");
                                String gender = jsonObject.getString("victim_gender");

                                String photo_path = jsonObject.getString("victim_photo");
                                String pan = jsonObject.getString("victim_mobile_no");
                                String mobile = jsonObject.getString("victim_mobile_no");
                                String is_suspect = jsonObject.getString("is_i_victim");
                                int fir_id = jsonObject.getInt("fir_id");
                                int investigation_suspect_id = jsonObject.getInt("investigation_victim_id");
                                victimtone=new Victim(country, state, district, city, fname, mname, lname, address,
                                        dob, email, adhar, gender,
                                        photo_path, pan, mobile, is_suspect,
                                        fir_id, investigation_suspect_id);
                            }
                        }
                        catch ( Exception e){
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap <String,  String> map=new HashMap<>();
                map.put("investigation_victim_id", String.valueOf(investigation_suspect_id));
                return map;
            }
        };


        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return victimtone;
    };

    public Victim createvictim(Victim inservictim, Context context, Callback callback){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, createvictim_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response.toString());
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                String  investigation_victim_id = jsonObject.getString("investigation_victim_id");
                            callback.onSuccess(investigation_victim_id);
                            }



                        }catch (Exception e){
                            e.printStackTrace();
                            callback.onErro(e.toString());

                        }


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
                HashMap<String, String> map = new HashMap<>();
                map.put("fir_id", String.valueOf(inservictim.getFir_id()));
                map.put("victim_fname",inservictim.getFname());
                map.put("victim_mname",inservictim.getMname());
                map.put("victim_lname",inservictim.getLname());
                map.put("country_id","1");
                //insertsuspect.getAddress());
                map.put("state_id","1");

                //insertsuspect.  getCity());
                map.put("district_id","1");
                // insertsuspect. getState());
                map.put("city_id","1");
                //insertsuspect. getDistrict());
                map.put("victim_gender",inservictim.getGender());
                map.put("victim_dob",inservictim.getDob());
                map.put("victim_email",inservictim.getEmail());
                map.put("victim_mobile_no",inservictim. getMobile());
                //   map.put("",insertsuspect. getIs_suspect());
                map.put("victim_adhar",inservictim.getAdhar());
                map.put("victim_address",inservictim. getAddress());
                map.put("victim_pan_no",inservictim.  getPan());
                map.put("victim_photo",inservictim.  getPhoto_path());
                map.put("police_id",Police_id);

                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return create_victim;
    };
    public Victim updatevictim(Victim updatevictim,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,   updatvictim_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response.toString());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText( context, "error " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("fir_id", String.valueOf(updatevictim.getFir_id()));
                map.put("victim_fname",updatevictim.getFname());
                map.put("victim_mname",updatevictim.getMname());
                map.put("victim_lname",updatevictim.getLname());
                map.put("country_id","1");
                //insertsuspect.getAddress());
                map.put("state_id","1");

                //insertsuspect.  getCity());
                map.put("district_id","1");
                // insertsuspect. getState());
                map.put("city_id","1");
                //insertsuspect. getDistrict());
                map.put("victim_gender",updatevictim.getGender());
                map.put("victim_dob",updatevictim.getDob());
                map.put("victim_email",updatevictim.getEmail());
                map.put("victim_mobile_no",updatevictim. getMobile());
                //   map.put("",insertsuspect. getIs_suspect());
                map.put("victim_adhar",updatevictim.getAdhar());
                map.put("victim_address",updatevictim. getAddress());
                map.put("victim_pan_no",updatevictim.  getPan());
                map.put("victim_photo",updatevictim.  getPhoto_path());
                map.put("police_id",Police_id);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return update_victim;
    }
    public ArrayList<String> search_victim(Victim search_victim, Context context){
        StringRequest  stringRequest=new StringRequest(Request.Method.POST, Search_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String  search_result = jsonObject.getString("search_result");
                                search_list.add(search_result);
                            }


                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("search", String.valueOf( search_victim.getInvestigation_victim_id()));
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return search_list;
    };

    public Victim delete_victim(int investigation_victim_id,Context context){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, delete_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(context, ""+response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("investigation_suspect_id", String.valueOf(investigation_victim_id));


                return map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return delete_victim;
    }
}
