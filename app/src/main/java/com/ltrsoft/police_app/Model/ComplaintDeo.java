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
import com.ltrsoft.police_app.Classes.Complaint;
import com.ltrsoft.police_app.interface1.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComplaintDeo {

    String investigation_id,suspect_id;
    Complaint complainttone;
    Complaint create_complaint;
    Complaint update_complaint;
    Complaint delete_complaint;
    String Police_id="1";
    String getoneComplaint_URL="";

    String Search_URL="";
    String delete_URL="";

    String createComplaint_url="https://rj.ltr-soft.com/public/police_api/data/complaint_insert.php";
    String updatecomplaint_url="https://rj.ltr-soft.com/public/police_api/data/complaint_update.php";
    String getAllComplaint_URL="https://rj.ltr-soft.com/public/police_api/data/complaint_all.php";
    String searcgUrl="";
    public ArrayList<Complaint> list = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();
    public void getAllComplaint(String fir_id, Context context ,Callback callback) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,  getAllComplaint_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Integer user_id=jsonObject.getInt("user_id");
                                Integer status_id=jsonObject.getInt("status_id");
                                Integer complaint_id =jsonObject.getInt("complaint_id");
                                String complaint_type_name= jsonObject.getString("complaint_type_id");

                                String complaint_subject = jsonObject.getString("complaint_subject");
                                String complaint_description = jsonObject.getString("complaint_description");
                                String complaint_against = jsonObject.getString("complaint_against");
                                String incident_date = jsonObject.getString("incident_date");
                                String station_name = jsonObject.getString("station_id");
                                String complaint_location = jsonObject.getString("complaint_location");
                                String complain_contact_no = jsonObject.getString("user_mobile1");

                                String  state = jsonObject.getString("state_name");
                                String country = jsonObject.getString("country_name");
                                String city = jsonObject.getString("state_name");
                                String district = jsonObject.getString("district_name");

                                 list.add(new Complaint(complaint_type_name, station_name, complaint_subject, complaint_location, complain_contact_no,
                                         incident_date, complaint_against, complaint_description,
                                         state, country, city, district,complaint_id, user_id, status_id));
                             }
                            callback.onSuccess(list);
                        } catch (JSONException e) {
                            callback.onErro(e.toString());
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onErro(error.toString());
                error.printStackTrace();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
//                map.put("fir_id", fir_id);
                return map;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    public Complaint getoneComplaint(int  complaint_id, Context context ){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,  getoneComplaint_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Integer user_id=jsonObject.getInt("user_id");
                                Integer status_id=jsonObject.getInt("status_id");
                                Integer complaint_id =jsonObject.getInt("complaint_id");
                                String complaint_type_name= jsonObject.getString("complaint_type_id");

                                String complaint_subject = jsonObject.getString("complaint_subject");
                                String complaint_description = jsonObject.getString("complaint_description");
                                String complaint_against = jsonObject.getString("complaint_against");
                                String incident_date = jsonObject.getString("incident_date");
                                String station_name = jsonObject.getString("station_id");
                                String complaint_location = jsonObject.getString("complaint_location");
                                String complain_contact_no = jsonObject.getString("user_mobile1");

                                String  state = jsonObject.getString("state_name");
                                String country = jsonObject.getString("country_name");
                                String city = jsonObject.getString("state_name");
                                String district = jsonObject.getString("district_name");


                                complainttone=new Complaint(complaint_type_name, station_name, complaint_subject, complaint_location, complain_contact_no,
                                        incident_date, complaint_against, complaint_description,
                                        state, country, city, district,complaint_id, user_id, status_id);
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
                map.put("complaint_id", String.valueOf(complaint_id));
                return map;
            }
        };


        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return complainttone;

    };

    public   void createcomplaint(Complaint insertcomplaint, Context context, Callback callback){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,  createComplaint_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response.toString());
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                String   complaint_id= jsonObject.getString("complaint_id");
                              callback.onSuccess(complaint_id);
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
                map.put("complaint_location", String.valueOf( insertcomplaint.getComplaint_location()));
                map.put("station_id","1");
                map.put("incident_date",insertcomplaint. getIncident_date());
                map.put("complaint_against",insertcomplaint.getComplain_Against());
                map.put("country_id","1");
                //insertsuspect.getAddress());
                map.put("state_id","1");

                //insertsuspect.  getCity());
                map.put("district_id","1");
                // insertsuspect. getState());
                map.put("city_id","1");
                //insertsuspect. getDistrict());
                map.put("complaint_description",insertcomplaint.getComplain_description());
                map.put("complaint_subject",insertcomplaint.getComplain_subject());
                map.put("complaint_type_id", "1");
                 //   map.put("",insertsuspect. getIs_suspect());
                map.put("status_id", "1");
                map.put("user_id", "1");
                        String.valueOf(insertcomplaint.  getUser_id());

                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



     };
    public Complaint updatecomplaint(Complaint updatecomplaint,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,   updatecomplaint_url ,
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
                map.put("complaint_location", String.valueOf( updatecomplaint.getComplaint_location()));
                map.put("station_id","1");
                map.put("incident_date",updatecomplaint. getIncident_date());
                map.put("complaint_against",updatecomplaint.getComplain_Against());
                map.put("country_id","1");
                //insertsuspect.getAddress());
                map.put("state_id","1");

                //insertsuspect.  getCity());
                map.put("district_id","1");
                // insertsuspect. getState());
                map.put("city_id","1");
                //insertsuspect. getDistrict());
                map.put("complaint_description",updatecomplaint.getComplain_description());
                map.put("complaint_subject",updatecomplaint.getComplain_subject());
                map.put("complaint_type_id", "1");
                //   map.put("",insertsuspect. getIs_suspect());
                map.put("status_id", "1");
                map.put("complaint_id", String.valueOf(updatecomplaint.getComplain_id()));
                map.put("user_id", "1");
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return  updatecomplaint;
    }
    public ArrayList<String> search_complaint(Complaint search_complaint, Context context){
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
                map.put("search", String.valueOf( search_complaint.getComplain_id()));
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return search_list;
    };

    public Complaint delete_suspect(int  complaint_id,Context context){
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
                map.put("investigation_suspect_id", String.valueOf( complaint_id));


                return map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return delete_complaint;
    }


}
