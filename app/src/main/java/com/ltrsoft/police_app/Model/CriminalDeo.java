package com.ltrsoft.police_app.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.police_app.Classes.Criminal;
import com.ltrsoft.police_app.interface1.Callback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CriminalDeo {

    private String encodeImage;

        String investigation_id, Criminal_id;
        Criminal criminalone;
        Criminal create_criminal;
        Criminal update_criminal;
        Criminal delete_criminal;
        String Police_id = "1";
        String getoneCriminal_URL = "";

        String Search_URL = "";
        String delete_URL = "";

    private static final String INSERT_CRIMINAL = "https://rj.ltr-soft.com/public/police_api/criminal_detail/create_criminal_detail.php";
        String updatesCriminal_url = "https://rj.ltr-soft.com/public/police_api/criminal_detail/update_criminal_detail.php";
        String getAllCriminal_URL = "https://rj.ltr-soft.com/public/police_api/criminal_complaint/read_criminal_complaint.php";
        String searcgUrl = "";
        public ArrayList<Criminal> list = new ArrayList<>();
        public ArrayList<String> search_list = new ArrayList<String>();

        public  ArrayList<Criminal>getAllWarrant(String fir_id, Context context){

            StringRequest stringRequest = new StringRequest(Request.Method.POST, getAllCriminal_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);


                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String fname = jsonObject.getString("criminal_fname");
                                    String mname= jsonObject.getString("criminal_mname");
                                    String lname=jsonObject.getString("criminal_lname");
                                    String address=jsonObject.getString("criminal_address");
                                    String dob=jsonObject.getString("criminal_dob");
                                    String email=jsonObject.getString("criminal_email");
                                    String adhar=jsonObject.getString("criminal_adhar");
                                    String gender=jsonObject.getString("gender");
                                    String city=jsonObject.getString("city_id");
                                    String district=jsonObject.getString("district_id");
                                    String state=jsonObject.getString("state_id");
                                    String country=jsonObject.getString("country_id");
                                    String photo_path=jsonObject.getString("criminal_photo");
                                    String pan=jsonObject.getString("");
                                    String mobile=jsonObject.getString("");
                                    String is_criminal=jsonObject.getString("");
                                    String punishment=jsonObject.getString("punishment");
                                    String duration=jsonObject.getString("duration");
                                    String punishment_date=jsonObject.getString("");
                                    int criminal_complaint_id=jsonObject.getInt("criminal_complaint_id");
                                    int fir_id = jsonObject.getInt("fir_id");
                                    int criminal_id = jsonObject.getInt("criminal_id");

                                    list.add(new Criminal(fname,mname,lname,address,  dob,email,adhar, gender,city,
                                            district,state,country,  photo_path,pan,mobile,is_criminal,punishment,duration,punishment_date,
                                            criminal_id,criminal_complaint_id,fir_id));

                                }
                            } catch (Exception e) {
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
                    }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> map = new HashMap<>();
                    map.put(" fir_id", String.valueOf( fir_id));
                    return map;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);
            return list;

        }

        public Criminal criminalone(int criminal_id, Context context) {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, getoneCriminal_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);


                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String fname = jsonObject.getString("criminal_fname");
                                    String mname= jsonObject.getString("criminal_mname");
                                    String lname=jsonObject.getString("criminal_lname");
                                    String address=jsonObject.getString("criminal_address");
                                    String dob=jsonObject.getString("criminal_dob");
                                    String email=jsonObject.getString("criminal_email");
                                    String adhar=jsonObject.getString("criminal_adhar");
                                    String gender=jsonObject.getString("gender");
                                    String city=jsonObject.getString("city_id");
                                    String district=jsonObject.getString("district_id");
                                    String state=jsonObject.getString("state_id");
                                    String country=jsonObject.getString("country_id");
                                    String photo_path=jsonObject.getString("criminal_photo");
                                    String pan=jsonObject.getString("");
                                    String mobile=jsonObject.getString("");
                                    String is_criminal=jsonObject.getString("");
                                    String punishment=jsonObject.getString("punishment");
                                    String duration=jsonObject.getString("duration");
                                    String punishment_date=jsonObject.getString("");
                                    int criminal_complaint_id=jsonObject.getInt("criminal_complaint_id");
                                    int fir_id = jsonObject.getInt("fir_id");
                                    int criminal_id = jsonObject.getInt("criminal_id");

                                    list.add(new Criminal(fname,mname,lname,address,  dob,email,adhar, gender,city,
                                            district,state,country,  photo_path,pan,mobile,is_criminal,punishment,duration,punishment_date,
                                            criminal_id,criminal_complaint_id,fir_id));

                                }
                            } catch (Exception e) {
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
                    }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("criminal_id", String.valueOf(Criminal_id));
                    return map;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);

            return criminalone;

        }

        public void createcriminal(Criminal insertcriminal, Context context, Callback callback) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, INSERT_CRIMINAL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                             if (response.contains("success")){
                                 try {
                                     JSONArray jsonArray=new JSONArray(response);
                                     for(int i=0;i<jsonArray.length();i++){
                                         JSONObject jsonObject=jsonArray.getJSONObject(i);
                                         String   police_id = jsonObject.getString("police_id");
                                        callback.onSuccess(police_id);
                                     }



                                 }catch (Exception e){
                                     e.printStackTrace();
                                   callback.onErro(e.toString());
                                 }

                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                callback.onErro(error.toString());

                 }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap hashMap =  new HashMap();
                    hashMap.put("criminal_fname",insertcriminal.getFname());
                    hashMap.put("country_id","1" );
                    hashMap.put("state_id","1");
                    hashMap.put("district_id","1");
                    hashMap.put("city_id","1");

                        hashMap.put("gender",insertcriminal.getGender());

                    hashMap.put("criminal_address", insertcriminal.getAddress());
                    hashMap.put("criminal_dob",  insertcriminal.getDob());
                    if (encodeImage!=null) {
                        hashMap.put("criminal_photo", insertcriminal.getPhoto_path());
                    }
                    hashMap.put("criminal_adhar",insertcriminal.getAdhar());
                    return hashMap;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);

        }



    public Criminal updatecriminal(Criminal updatecriminal, Context context) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, updatesCriminal_url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            System.out.println("response" + response.toString());

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, "error " + error.toString(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("fir_id", String.valueOf(updatecriminal.getFir_id()));
                    map.put("",String.valueOf(updatecriminal.getFname()));
                    map.put("",String.valueOf(updatecriminal.getMname()));
                    map.put("",String.valueOf(updatecriminal.getLname()));
                    map.put("",String.valueOf(updatecriminal.getAddress()));
                    map.put("",String.valueOf(updatecriminal.getDob()));
                    map.put("",String.valueOf(updatecriminal.getEmail()));
                    map.put("",String.valueOf(updatecriminal.getAdhar()));
                    map.put("",String.valueOf(updatecriminal.getGender()));
                    map.put("",String.valueOf(updatecriminal.getCity()));
                    map.put("",String.valueOf(updatecriminal.getDistrict()));
                    map.put("",String.valueOf(updatecriminal.getState()));
                    map.put("",String.valueOf(updatecriminal.getCountry()));
                    map.put("",String.valueOf(updatecriminal.getPhoto_path()));
                    map.put("",String.valueOf(updatecriminal.getPunishment()));
                    map.put("",String.valueOf(updatecriminal.getDuration()));
                    map.put("police_id", Police_id);
                    map.put("investigation_witness_id", String.valueOf(updatecriminal.getCriminal_id()));

                    return map;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);


            return updatecriminal;
        }

        public ArrayList<String> search_criminal(Criminal search_criminal, Context context) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Search_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String search_result = jsonObject.getString("search_result");
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
                    }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("search", String.valueOf(search_criminal.getCriminal_id()));
                    return map;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);


            return search_list;
        }

        public Criminal Delete_criminal(int criminal_id, Context context) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, delete_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(context, "" + response, Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("criminal_id", String.valueOf(Criminal_id));


                    return map;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);


            return delete_criminal;

}










}
