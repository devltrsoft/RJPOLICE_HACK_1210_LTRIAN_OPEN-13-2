package com.ltrsoft.police_app.Model;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.police_app.Classes.Police;
import com.ltrsoft.police_app.interface1.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PoliceDeo {

    Police Police_one;
    Police create_police;
    Police update_police;
    Police delete_police;
    String Police_id="1";
    String police_login_url="https://rj.ltr-soft.com/public/police_api/login/police_login.php";
    static String getonepolice_URL="http://rj.ltr-soft.com/public/police_api/data/police_read.php";
      String Polioce_registration_URL="https://rj.ltr-soft.com/public/police_api/data/police_insert.php";
    String Search_URL="";
    String delete_URL="";

    String createpolice_url="https://rj.ltr-soft.com/public/police_api/data/police_insert.php";
    String updatepolice_url="https://rj.ltr-soft.com/public/police_api/data/police_update.php";
    String getAllpolice_URL="https://rj.ltr-soft.com/public/police_api/data/police_all.php";
    String searcgUrl="";
    public static ArrayList<Police> list = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();
//    public ArrayList<Police> getAllnotification(String notification_id, Context context) {
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST,  getAllpolice_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONArray jsonArray = new JSONArray(response);
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                String country = jsonObject.getString("country_name");
//
//                                String state = jsonObject.getString("state_name");
//                                String district = jsonObject.getString("district_name");
//                                String city = jsonObject.getString("city_name");
//                                String fname = jsonObject.getString("suspect_fname");
//                                String mname = jsonObject.getString("suspect_mname");
//                                String lname = jsonObject.getString("suspect_lname");
//                                String address = jsonObject.getString("");
//
//                                String dob = jsonObject.getString("suspect_dob");
//                                String email = jsonObject.getString("suspect_email");
//                                String adhar = jsonObject.getString("suspect_adhar");
//                                String gender = jsonObject.getString("suspect_gender");
//
//                                String photo_path = jsonObject.getString("suspect_photo");
//                                String pan = jsonObject.getString("suspect_mobile_no");
//                                String mobile = jsonObject.getString("suspect_mobile_no");
//                                String is_suspect = jsonObject.getString("is_i_suspect");
//                                int fir_id = jsonObject.getInt("fir_id");
//                                int investigation_suspect_id = jsonObject.getInt("investigation_suspect_id");
//                                list.add(new Suspect(country, state, district, city, fname, mname, lname, address,
//                                        dob, email, adhar, gender,
//                                        photo_path, pan, mobile, is_suspect,
//                                        fir_id, investigation_suspect_id));
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            throw new RuntimeException(e);
//
//                        }
//
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        }) {
//            @Nullable
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> map = new HashMap<>();
//                map.put("fir_id", fir_id);
//
//
//                return map;
//            }
//
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
//        requestQueue.add(stringRequest);
//        return list;
//    }
//
//
    public static void getonepolice( int police_id, Context context, Callback callback){
      police_id=1;
        int finalPolice_id = police_id;
        StringRequest stringRequest=new StringRequest(Request.Method.POST, getonepolice_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                               Integer police_id=jsonObject.getInt("police_id");
                               String batch_number=jsonObject.getString("batch_number");
                              String  station_id=jsonObject.getString("station_id");
                                String  police_fname=jsonObject.getString("police_fname");
                                String  police_mname=jsonObject.getString("police_mname");
                                String  police_lname=jsonObject.getString("police_lname");
                                String  police_email=jsonObject.getString("police_email");
                                String  police_gender=jsonObject.getString("police_gender");
                                 String  police_dob=jsonObject.getString("police_dob");
                                String  police_mobile1=jsonObject.getString("police_mobile1");
                                String  police_mobile2=jsonObject.getString("police_mobile2");
                                String  police_address=jsonObject.getString("police_address");
                                String city_name=jsonObject.getString("city_name");
                                String district_name=jsonObject.getString("district_name");
                                String state_name=jsonObject.getString("state_name");
                                String position_name=jsonObject.getString("position_name");
                                String  police_adhar=jsonObject.getString("police_adhar");

                                Police police1=new Police(batch_number,station_id,police_fname,police_mname,police_lname,police_email,police_gender,
                                        police_dob,police_mobile1,police_mobile2,police_address,city_name,district_name,state_name,position_name
                                ,police_adhar,police_id);
                                callback.onSuccess(police1);
                            }
                        }
                        catch ( Exception e){
                         callback.onErro(e.toString());
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       // error.printStackTrace();
                    callback.onErro(error.toString());
                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap <String,  String> map=new HashMap<>();
                map.put("police_id", String.valueOf(finalPolice_id));
                return map;
            }
        };


        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);;

    };

    public Police createpolice(Police insertpolice,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, createpolice_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response.toString());
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                String   police_id = jsonObject.getString("police_id");

                            }



                        }catch (Exception e){
                            e.printStackTrace();

                        }


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
                map.put("batch_number",insertpolice.getBatch_number()  );
                map.put("police_fname",insertpolice.getFname());
                map.put("police_mname",insertpolice.getMname());
                map.put("police_lname",insertpolice.getLname());
                map.put("country_id","1");
                //insertsuspect.getAddress());
                map.put("state_id","1");

                //insertsuspect.  getCity());
                map.put("district_id","1");
                // insertsuspect. getState());
                map.put("city_id","1");
                //insertsuspect. getDistrict());
                map.put("police_gender",insertpolice.getGender());
                map.put("police_dob",insertpolice.getDob());
                map.put("police_email",insertpolice.getEmail());
                map.put("police_mobile1",insertpolice. getMobile1());
                map.put("police_mobile2",insertpolice. getMobile2());

                //   map.put("",insertsuspect. getIs_suspect());
                map.put("police_adhar",insertpolice.getAdhar());
                map.put("police_address",insertpolice. getAddress());
                map.put("position_id","1");
                        //insertpolice.  getPan());
                map.put("police_photo_path",insertpolice.  getPhoto_path());
                map.put("police_fcm_token","22");
                map.put("police_latitude",insertpolice.getPolice_lattitude());
                map.put("police_longitude",insertpolice.getPolice_langitude());

                //police_fcm_token)

                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return create_police;
    };
    public Police updatesuspect(Police update_police,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,  updatepolice_url ,
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
                map.put("batch_number",update_police.getBatch_number()  );
                map.put("police_fname",update_police.getFname());
                map.put("police_mname",update_police.getMname());
                map.put("police_lname",update_police.getLname());
                map.put("country_id","1");
                //insertsuspect.getAddress());
                map.put("state_id","1");

                //insertsuspect.  getCity());
                map.put("district_id","1");
                // insertsuspect. getState());
                map.put("city_id","1");
                //insertsuspect. getDistrict());
                map.put("police_gender",update_police.getGender());
                map.put("police_dob",update_police.getDob());
                map.put("police_email",update_police.getEmail());
                map.put("police_mobile1",update_police. getMobile1());
                map.put("police_mobile2",update_police. getMobile2());

                //   map.put("",insertsuspect. getIs_suspect());
                map.put("police_adhar",update_police.getAdhar());
                map.put("police_address",update_police. getAddress());
                map.put("position_id","1");
                //insertpolice.  getPan());
                map.put("police_photo_path",update_police.  getPhoto_path());
                map.put("police_fcm_token","22");
                map.put("police_latitude",update_police.getPolice_lattitude());
                map.put("police_longitude",update_police.getPolice_langitude());
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return update_police;
    }
//   // public ArrayList<String> search_police(Police search_police, Context context){
//        StringRequest  stringRequest=new StringRequest(Request.Method.POST, Search_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONArray jsonArray = new JSONArray(response);
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                String  search_result = jsonObject.getString("search_result");
//                                search_list.add(search_result);
//                            }
//
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }){
//            @Nullable
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> map = new HashMap<>();
//                map.put("search", String.valueOf( search_police. getPolice_id()));
//                return map;
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue( context);
//        requestQueue.add(stringRequest);
//
//
//
//        return search_list;
//    };
//
//    public Police delete_police(int  police_id,Context context){
//        StringRequest stringRequest=new StringRequest(Request.Method.POST, delete_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Toast.makeText(context, ""+response, Toast.LENGTH_SHORT).show();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }){
//            @Nullable
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String,String>map=new HashMap<>();
//                map.put("police_id", String.valueOf(police_id));
//
//
//                return map;
//            }
//        };
//
//        RequestQueue requestQueue= Volley.newRequestQueue(context);
//        requestQueue.add(stringRequest);
//
//
//        return delete_police;
//    }
    public void police_login(Police login , Context context, Callback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, police_login_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String msg = jsonObject.getString("Message");
                            String id = jsonObject.getString("police_id");
                            if (msg.equals("100")) {
                                callback.onSuccess(id);
                            } else if (msg.equals("200")) {
                                callback.onErro("invalid password");


                            } else {
                                callback.onErro(" user not found");



                            }
                        } catch (JSONException e) {
                            callback.onErro(e.toString());

                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                         callback.onErro(error.toString());
                    }

                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", login.getEmail());
                params.put("password", login.getPassword());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


    }

    public void police_registration(Police registration,Context context,Callback callback){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,  Polioce_registration_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
//                        System.out.println(response);
                        if (response.contains("success")) {
                        callback.onSuccess("registration success");





                        } else {
                            callback.onErro("unexpected response");
                         }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                 if (error.networkResponse != null && error.networkResponse.statusCode == 500) {
                     String responseData = new String(error.networkResponse.data);
                     callback.onErro("networl error");

                } else {
                     callback.onErro("volley error");
                 }
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("user_fname", registration.getFname());
                param.put("user_email",  registration. getEmail());
                param.put("user_password", registration.getPassword());
                param.put("user_mobile1", registration.getMobile1());
                return param;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);


    }




}
