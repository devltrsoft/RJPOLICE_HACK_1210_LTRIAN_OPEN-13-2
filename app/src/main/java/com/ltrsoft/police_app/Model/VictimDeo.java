package com.ltrsoft.police_app.Model;

import android.app.Activity;
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
import com.ltrsoft.police_app.Classes.Victimtracking;
import com.ltrsoft.police_app.interface1.Callback;
import com.ltrsoft.police_app.utils.UserDataAccess;

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
    public final static String GET_ONE_COMPLAINT_VICTIM_BY_VICTIMID_URL = "https://rj.ltr-soft.com/public//police_api/data/c_victim_id.php";
     String getoneVictim_URL="https://rj.ltr-soft.com/public/police_api/data/complaint_by_date.php";
     String getVictimTracking_URL="https://rj.ltr-soft.com/public/police_api/history_tracking/read_by_victim.php";
    String Search_URL="";
    String delete_URL="";
    String createvictim_url="https://rj.ltr-soft.com/public/police_api/investigation_victim/create_investigation_victim.php";
    String updatvictim_url="https://rj.ltr-soft.com/public/police_api/investigation_victim/update_investigation_victim.php";
    String getAllvictim_URL="https://rj.ltr-soft.com/public/police_api/investigation_victim/victim_fir_id.php";
    String getOneInvstvictim_URL="https://rj.ltr-soft.com/public/police_api/investigation_victim/i_victim_id.php";
    public final static String GET_ALL_Complaint_VICTIM_URL_by_complaint_id = "https://rj.ltr-soft.com/public/police_api/data/complaint_victim_r.php";
    String searcgUrl="";

    public ArrayList<Victim> list = new ArrayList<>();
    public ArrayList<Victimtracking> listtr = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();
    public void GET_ONE_COMPLAINT_VICTIM_BY_VICTIMID(String victim_id , Context context , Callback userCallBack){
        //Toast.makeText(context, "victim id"+victim_id, Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_ONE_COMPLAINT_VICTIM_BY_VICTIMID_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("resposne = "+response.toString());
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String cmp_id = jsonObject.getString("cmp_id");
                        String complaint_victim_fname = jsonObject.getString("complaint_victim_fname");
                        String complaint_victim_mname = jsonObject.getString("complaint_victim_mname");
                        String complaint_victim_lname = jsonObject.getString("complaint_victim_lname");
                        String address = jsonObject.getString("address");
                        String gender = jsonObject.getString("gender");
                        String aadhar = jsonObject.getString("aadhar");
                        String photo = jsonObject.getString("photo");
                        String dob = jsonObject.getString("dob");
                        String mobile = jsonObject.getString("mobile");
                        String state_name = jsonObject.getString("state_name");
                        String district_name = jsonObject.getString("district_name");
                        String city_name = jsonObject.getString("city_name");
                        list.add(new Victim(cmp_id,complaint_victim_fname,complaint_victim_mname,complaint_victim_lname,address,gender,aadhar,
                                photo,dob,mobile,state_name,district_name,city_name));

                    }
                    userCallBack.onSuccess(list);
                } catch (JSONException e) {
                    userCallBack.onErro(e.toString());
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                userCallBack.onErro(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap hashMap = new HashMap();
//                hashMap.put("complaint_victim_id","1");
                hashMap.put("complaint_victim_id",victim_id);
                return hashMap;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


}

    public void get_Complaint_victim_by_complaint_id(String complaint_id, Context context , Callback userCallBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_ALL_Complaint_VICTIM_URL_by_complaint_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("response = "+response.toString());
                if (!response.isEmpty()&&response.length()>1) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        System.out.println("lenlgth = " + jsonArray.length());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String victim_id = jsonObject.getString("complaint_victim_id");
                            String complaint_victim_fname = jsonObject.getString("complaint_victim_fname");
                            String complaint_victim_mname = jsonObject.getString("complaint_victim_mname");
                            String complaint_victim_lname = jsonObject.getString("complaint_victim_lname");
                            String address = jsonObject.getString("address");
                            String gender = jsonObject.getString("gender");
                            String aadhar = jsonObject.getString("aadhar");
                            String photo = jsonObject.getString("photo");
                            String dob = jsonObject.getString("dob");
                            String mobile = jsonObject.getString("mobile");
                            String state_name = jsonObject.getString("state_name");
                            String district_name = jsonObject.getString("district_name");
                            String city_name = jsonObject.getString("city_name");
                            list.add(new Victim(victim_id, complaint_victim_fname, complaint_victim_mname, complaint_victim_lname, address, gender, aadhar,
                                    photo, dob, mobile, state_name, district_name, city_name));
                        }
                    } catch (JSONException e) {
                        System.out.println("error = " + e.toString());
                        userCallBack.onErro(e.toString());
                        throw new RuntimeException(e);
                    }
                    userCallBack.onSuccess(list);
                }
                else {
                    list = new ArrayList<>();
                    userCallBack.onSuccess(list);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error"+error.toString());
                userCallBack.onErro(error.toString());
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap();
//                map.put("complaint_id",complaint_id);
                map.put("complaint_id",complaint_id);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(stringRequest);
    }

    public void getAllVictim( String fir_d,Context context,Callback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, getAllvictim_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.isEmpty()) {
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
                                    String pan = jsonObject.getString("victim_pan");
                                    String mobile = jsonObject.getString("victim_mobile_no");
                                    String is_suspect = jsonObject.getString("is_i_victim");
                                    String fir_id =jsonObject.getString("fir_id");
                                    String investigation_victim_id = jsonObject.getString("investigation_victim_id");
                                    list.add(new Victim(country, state, district, city, fname, mname, lname, address,
                                            dob, email, adhar, gender,
                                            photo_path, pan, mobile, is_suspect,
                                            fir_id,investigation_victim_id ));
                                }
                                callback.onSuccess(list);
                            } catch (JSONException e) {
                                callback.onErro(e.toString());
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                        else {
                            callback.onErro("THis FIR have no victim ");
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
                map.put("fir_id",fir_d);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void getVictimByDate(String victim_id,Context context,Callback callback ){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, getVictimTracking_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.isEmpty()&&response.length()>1) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String victim_history_id = jsonObject.getString("victim_history_id");
                                    String victim_id = jsonObject.getString("victim_id");
                                    String tracking_date = jsonObject.getString("tracking_date");
                                    String police_id = jsonObject.getString("police_fname");
                                    String fir_id = jsonObject.getString("fir_id");
                                    String operation = jsonObject.getString("operation");
                                    String description = jsonObject.getString("description");
                                    String created_at = jsonObject.getString("created_at");
                                    String investigation_victim_id = jsonObject.getString("investigation_victim_id");
                                    listtr.add(new Victimtracking(victim_history_id, victim_id, tracking_date, police_id, fir_id, operation, description, created_at, investigation_victim_id));
                                }
                                callback.onSuccess(listtr);
                            } catch (Exception e) {
                                callback.onErro(e.toString());
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }else {
//                            callback.onErro("this victim have no history");
                            listtr.add(new Victimtracking("1",victim_id,"12-02-3","xyz","012931","created at","desc","237498",victim_id));
                            callback.onSuccess(listtr);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onErro(error.toString());
                        error.printStackTrace();
                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap <String,  String> map=new HashMap<>();
                map.put("victim_id",victim_id);
                return map;
            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void getVictimByComplaint_id(String complaint_id,Context context,Callback callback ){

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
                                String fname = jsonObject.getString("complaint_victim_fname");
                                String mname = jsonObject.getString("complaint_victim_mname");
                                String lname = jsonObject.getString("complaint_victim_lname");
                                String address = jsonObject.getString("address");

                                String dob = jsonObject.getString("dob");
                                String email = jsonObject.getString("email");
                                String adhar = jsonObject.getString("aadhar");
                                String gender = jsonObject.getString("gender");

                                String photo_path = jsonObject.getString("photo");
                                String pan = jsonObject.getString("mobile");
                                String mobile = jsonObject.getString("mobile");
                                String is_suspect = jsonObject.getString("is_c_victim");
                                String fir_id = "100" ;//jsonObject.getString("fir_id");
                                String investigation_suspect_id =  "100";//jsonObject.getString("investigation_suspect_id");
                                list.add(new Victim(country, state, district, city, fname, mname, lname, address,
                                        dob, email, adhar, gender,
                                        photo_path, pan, mobile, is_suspect,
                                        fir_id, investigation_suspect_id));
                            }
                            callback.onSuccess(list);
                        }
                        catch ( Exception e){
                            callback.onErro(e.toString());
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onErro(error.toString());
                        error.printStackTrace();
                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap <String,  String> map=new HashMap<>();
                map.put("complaint_id","complaint_id");
                return map;
            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    };
    public Victim createvictim(Victim inservictim, Context context, Callback callback){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, createvictim_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response.toString());
//                        System.out.println("response"+response.toString());
//                        try {
//                            JSONArray jsonArray=new JSONArray(response);
//                            for(int i=0;i<jsonArray.length();i++){
//                                JSONObject jsonObject=jsonArray.getJSONObject(i);
//                                String  investigation_victim_id = jsonObject.getString("investigation_victim_id");
//                            callback.onSuccess(investigation_victim_id);
//                            }
//                        }catch (Exception e){
//                            e.printStackTrace();
//                            callback.onErro(e.toString());
//
//                        }
//

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
                map.put("fir_id",  "2023-12-14-1");
                map.put("victim_fname",inservictim.getFname());
               // map.put("victim_mname",inservictim.getMname());
               // map.put("victim_lname",inservictim.getLname());
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
//                map.put("victim_pan_no",inservictim.  getPan());
//                map.put("victim_photo",inservictim.  getPhoto_path());
                UserDataAccess userDataAccess=new UserDataAccess();
                Activity activity=(Activity)context;

                map.put("police_id",userDataAccess.getPoliceId(activity));
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
                UserDataAccess userDataAccess=new UserDataAccess();
                Activity activity=(Activity)context;

                map.put("police_id",userDataAccess.getPoliceId(activity));
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
    public void getOneVictim( String victim_id,Context context,Callback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, getOneInvstvictim_URL,
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
                                    String pan = jsonObject.getString("victim_pan");
                                    String mobile = jsonObject.getString("victim_mobile_no");
                                    String is_suspect = jsonObject.getString("is_i_victim");
                                    String fir_id =jsonObject.getString("fir_id");
                                    String investigation_victim_id = jsonObject.getString("investigation_victim_id");
                                    list.add(new Victim(country, state, district, city, fname, mname, lname, address,
                                            dob, email, adhar, gender,
                                            photo_path, pan, mobile, is_suspect,
                                            fir_id,investigation_victim_id ));
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
//                map.put("investigation_victim_id",victim_id);
                map.put("investigation_victim_id","1");
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
