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
import com.ltrsoft.police_app.Classes.Investigation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvestigationDeo {
    String investigation_id,suspect_id;
    Investigation oneinvestigation;
    Investigation create_investigation;
    Investigation update_investigation;
    Investigation delete_investigation;
    String Police_id="1";
    String getoneInvestigation_URL="https://rj.ltr-soft.com//police_api/investigation/read_fir_id.php";

    String Search_URL="";
    String delete_URL="";

    String createinvestigation_url="https://rj.ltr-soft.com/public/police_api/investigation/create_investigation.php";
    String updateinvestigation_url="https://rj.ltr-soft.com/public/police_api/investigation/update_investigation.php";
    String getAllinvestigation_URL="https://rj.ltr-soft.com/public/police_api/investigation/investigation_detail.php";
    String searcgUrl="";
    public ArrayList<Investigation> list = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();
    public ArrayList<Investigation> getAllSuspect(String fir_id, Context context) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,   getAllinvestigation_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Integer investigation_id=jsonObject.getInt("investigation_id");
                                Integer fir_id=jsonObject.getInt("fir_id");
                                Integer complaint_id =jsonObject.getInt("complaint_id");
                                String start_date= jsonObject.getString("investigation_start_date");

                                String end_date = jsonObject.getString("investigation_end_date");
                                String location = jsonObject.getString("location");
                                String incedent_reporting = jsonObject.getString("incedant_reporting");
                                String evidance_property = jsonObject.getString("evidance_property");
                                String investigation_description = jsonObject.getString("investigation_description");


                                list.add(new Investigation( investigation_id,fir_id,complaint_id,
                                start_date,end_date,location,incedent_reporting,evidance_property,investigation_description));

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


    public Investigation getoneinvestigation(int   fir_id, Context context ){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,   getoneInvestigation_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Integer investigation_id=jsonObject.getInt("investigation_id");
                                Integer fir_id=jsonObject.getInt("fir_id");
                                Integer complaint_id =jsonObject.getInt("complaint_id");
                                String start_date= jsonObject.getString("investigation_start_date");

                                String end_date = jsonObject.getString("investigation_end_date");
                                String location = jsonObject.getString("location");
                                String incedent_reporting = jsonObject.getString("incedant_reporting");
                                String evidance_property = jsonObject.getString("evidance_property");
                                String investigation_description = jsonObject.getString("investigation_description");


                                list.add(new Investigation( investigation_id,fir_id,complaint_id,
                                        start_date,end_date,location,incedent_reporting,evidance_property,investigation_description));



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
                map.put("fir_id", String.valueOf(fir_id));
                return map;
            }
        };


        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return  oneinvestigation;

    };

    public  Investigation createinvestigation(Investigation insertinvestigation,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,  createinvestigation_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response.toString());
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                String    fir_id= jsonObject.getString("fir_id");

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


                map.put("investigation_id", String.valueOf( insertinvestigation.getInvestigation_id()));
                 map.put("fir_id", String.valueOf(insertinvestigation. getFir_id()));
                map.put("complaint_id", String.valueOf(insertinvestigation. getComplaint_id()));
                map.put("start_date",insertinvestigation.getStart_date());
                //insertsuspect.getAddress());
                map.put("end_date",insertinvestigation.getEnd_date());

                //insertsuspect.  getCity());
                map.put("location",insertinvestigation.getLocation());
                // insertsuspect. getState());
                map.put("incedent_reporting",insertinvestigation.getIncedent_reporting());
                //insertsuspect. getDistrict());
                map.put("evidance_property",insertinvestigation.getEvidance_property());
                map.put("investigation_description",insertinvestigation.getInvestigation_description());
                map.put("complaint_type_id", "1");
                //   map.put("",insertsuspect. getIs_suspect());

                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return create_investigation;
    };
    public Investigation updatecomplaint(Investigation updateinvestigation,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,   updateinvestigation_url ,
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

                map.put("investigation_id", String.valueOf( updateinvestigation.getInvestigation_id()));
                map.put("fir_id", String.valueOf(updateinvestigation. getFir_id()));
                map.put("complaint_id", String.valueOf(updateinvestigation. getComplaint_id()));
                map.put("start_date",updateinvestigation.getStart_date());
                //insertsuspect.getAddress());
                map.put("end_date",updateinvestigation.getEnd_date());

                //insertsuspect.  getCity());
                map.put("location",updateinvestigation.getLocation());
                // insertsuspect. getState());
                map.put("incedent_reporting",updateinvestigation.getIncedent_reporting());
                //insertsuspect. getDistrict());
                map.put("evidance_property",updateinvestigation.getEvidance_property());
                map.put("investigation_description",updateinvestigation.getInvestigation_description());
                map.put("complaint_type_id", "1");
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return  updateinvestigation;
    }
    public ArrayList<String> search_complaint(Investigation search_investigation, Context context){
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
                map.put("search", String.valueOf( search_investigation. getFir_id()));
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return search_list;
    };

    public Investigation delete_suspect(int  investigation_id,Context context){
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
                map.put("investigation_id", String.valueOf(  investigation_id));


                return map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return  delete_investigation;
    }



}
