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
import com.ltrsoft.police_app.Classes.Witness;
import com.ltrsoft.police_app.Classes.WitnessTracking;
import com.ltrsoft.police_app.interface1.Callback;
import com.ltrsoft.police_app.utils.UserDataAccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WitnessDeo {
    String investigation_id, suspect_id;
    Witness witnessone;
    Witness create_witness;
    Witness update_witness;
    Witness delete_witness;
     String getwitnessDetailByDate = "https://rj.ltr-soft.com/public/police_api/history_tracking/read_by_witness.php";
    String Search_URL = "";
    String delete_URL = "";

    String createwitness_url = "https://rj.ltr-soft.com/public/police_api/investigation_witness/create__investigation_witness.php";
    String updatesWitness_url = "https://rj.ltr-soft.com/public/police_api/investigation_witness/create__investigation_witness.php";
    String getAllWitness_URL = "https://rj.ltr-soft.com/public/police_api/investigation_witness/read_by_fir.php";
    String getOneWitness_URL = "https://rj.ltr-soft.com/public/police_api/investigation_witness/i_witness_id.php";
    String searcgUrl = "";
    public ArrayList<Witness> list = new ArrayList<>();
    public ArrayList<WitnessTracking> listt= new ArrayList<>();
    public ArrayList<String> search_list = new ArrayList<String>();

    private static String GET_ONE_WITNESS_By_Witness_Id_Url = "https://rj.ltr-soft.com/public//police_api/data/c_witness_id.php";
    private static String GET_Complaint_WITNESS_by_complaint_id = "https://rj.ltr-soft.com/public/police_api/data/complaint_vit_read.php";
    public void GET_Complaint_WITNESS_by_complaint_id(String complaint_id , Context context , Callback userCallBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_Complaint_WITNESS_by_complaint_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("response = "+response.toString());
                if (response != null && !response.isEmpty()&&response.length()>1) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String complaint_witness_id = jsonObject.getString("complaint_witness_id");
                            String complaint_witness_fname = jsonObject.getString("complaint_witness_fname");
                            String complaint_witness_mname = jsonObject.getString("complaint_witness_mname");
                            String complaint_witness_lname = jsonObject.getString("complaint_witness_lname");
                            String complaint_witness_address = jsonObject.getString("complaint_witness_address");
                            String city_name = jsonObject.getString("city_name");
                            String country_name = jsonObject.getString("country_name");
                            String state_name = jsonObject.getString("state_name");
                            String district_name = jsonObject.getString("district_name");
                            String complaint_witness_dob = jsonObject.getString("complaint_witness_dob");
                            String complaint_witness_gender = jsonObject.getString("complaint_witness_gender");
                            String complaint_witness_mobile = jsonObject.getString("complaint_witness_mobile");
                            String complaint_witness_email = jsonObject.getString("complaint_witness_email");
                            String complaint_witness_photo_path = jsonObject.getString("complaint_witness_photo_path");
                            String complaint_witness_pan = jsonObject.getString("complaint_witness_pan");
                            String complaint_witness_adhar = jsonObject.getString("complaint_witness_adhar");
                            String complaint_id = jsonObject.getString("complaint_id");
                            String isWitness = "";
                            list = new ArrayList<>();
                            list.add(new Witness(complaint_witness_id, complaint_witness_fname, complaint_witness_mname, complaint_witness_lname, complaint_witness_address, city_name, country_name, state_name, district_name
                                    , complaint_witness_dob, complaint_witness_gender, complaint_witness_mobile, complaint_witness_email, complaint_witness_photo_path, complaint_witness_pan, complaint_witness_adhar, complaint_id, isWitness));
                        }
                    } catch (JSONException e) {
                        System.out.println("error"+e.toString());
                        userCallBack.onErro(e.toString());
                        e.printStackTrace();
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
                error.printStackTrace();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap hashMap = new HashMap();
                hashMap.put("complaint_id",complaint_id);
//                hashMap.put("complaint_id","1");
                return hashMap;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(stringRequest);
 }

    public void GET_ONE_WITNESS_By_Witness_Id(String witness_id,Context context , Callback userCallBack){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_ONE_WITNESS_By_Witness_Id_Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println("response = "+response.toString());
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for ( int i = 0  ;i < 1 ; i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String complaint_witness_id = jsonObject.getString("complaint_witness_id");
                        String complaint_witness_fname = jsonObject.getString("complaint_witness_fname");
                        String complaint_witness_mname = jsonObject.getString("complaint_witness_mname");
                        String complaint_witness_lname = jsonObject.getString("complaint_witness_lname");
                        String complaint_witness_address = jsonObject.getString("complaint_witness_address");
                        String city_name = jsonObject.getString("city_name");
                        String country_name = jsonObject.getString("country_name");
                        String state_name = jsonObject.getString("state_name");
                        String district_name = jsonObject.getString("district_name");
                        String complaint_witness_dob = jsonObject.getString("complaint_witness_dob");
                        String complaint_witness_gender = jsonObject.getString("complaint_witness_gender");
                        String complaint_witness_mobile = jsonObject.getString("complaint_witness_mobile");
                        String complaint_witness_email = jsonObject.getString("complaint_witness_email");
                        String complaint_witness_photo_path = jsonObject.getString("complaint_witness_photo_path");
                        String complaint_witness_pan = jsonObject.getString("complaint_witness_pan");
                        String complaint_witness_adhar = jsonObject.getString("complaint_witness_adhar");
                        String complaint_id = jsonObject.getString("complaint_id");
                      //  String isWitness = "";
                      String isWitness = jsonObject.getString("isWitness");

                        list.add(new Witness(complaint_witness_id,complaint_witness_fname,complaint_witness_mname,
                                complaint_witness_lname,complaint_witness_address,city_name,country_name,state_name,
                                district_name,complaint_witness_dob,complaint_witness_gender,complaint_witness_mobile,
                                complaint_witness_email,complaint_witness_photo_path,complaint_witness_pan,
                                complaint_witness_adhar,complaint_id,isWitness,"complaint_table"));
                    }
                    System.out.println("sisze = "+list.size());
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
                hashMap.put("complaint_witness_id",witness_id);
                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

   }

    public void getAllWitness( String fir_id,Context context , Callback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, getAllWitness_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("resposne"+response.toString());
                        if (!response.isEmpty()&&response.length()>1) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String country = jsonObject.getString("country_name");

                                    String state = jsonObject.getString("state_name");
                                    String district = jsonObject.getString("district_name");
                                    String city = jsonObject.getString("city_name");
                                    String fname = jsonObject.getString("investigation_witness_fname");
                                    String mname = jsonObject.getString("investigation_witness_mname");
                                    String lname = jsonObject.getString("investigation_witness_lname");
                                    String address = jsonObject.getString("investigation_witness_address");

                                    String dob = jsonObject.getString("investigation_witness_dob");
                                    String email = jsonObject.getString("investigation_witness_email");
                                    String adhar = jsonObject.getString("investigation_witness_adhar");
                                    String gender = jsonObject.getString("investigation_witness_gender");

                                    String photo_path = jsonObject.getString("investigation_witness_photo");
                                    String pan = jsonObject.getString("witness_pan");
                                    String mobile = jsonObject.getString("investigation_witness_mobile");
                                    String is_witness = jsonObject.getString("is_i_witness");
                                    String fir_id = jsonObject.getString("fir_id");

                                    String investigation_witness_id = jsonObject.getString("investigation_witness_id");
                                    list.add(new Witness(country, state, district, city, fname, mname, lname, address,
                                            dob, email, adhar, gender,
                                            photo_path, pan, mobile, is_witness,
                                            fir_id, investigation_witness_id));
                                }
                                callback.onSuccess(list);

                            } catch (JSONException e) {
                                System.out.println("error" + e.toString());
                                callback.onErro(e.toString());
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                        else {
                            callback.onErro("this fir havce no witness");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("resposne"+error.toString());
                callback.onErro(error.toString());
                error.printStackTrace();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("fir_id",fir_id );
                return map;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void  getOneWitness(String witness_id,Context context , Callback callback){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, getOneWitness_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("resposne"+response.toString());
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String country = jsonObject.getString("country_name");

                                    String state = jsonObject.getString("state_name");
                                    String district = jsonObject.getString("district_name");
                                    String city = jsonObject.getString("city_name");
                                    String fname = jsonObject.getString("investigation_witness_fname");
                                    String mname = jsonObject.getString("investigation_witness_mname");
                                    String lname = jsonObject.getString("investigation_witness_lname");
                                    String address = jsonObject.getString("investigation_witness_address");

                                    String dob = jsonObject.getString("investigation_witness_dob");
                                    String email = jsonObject.getString("investigation_witness_email");
                                    String adhar = jsonObject.getString("investigation_witness_adhar");
                                    String gender = jsonObject.getString("investigation_witness_gender");

                                    String photo_path = jsonObject.getString("investigation_witness_photo");
                                    String pan = jsonObject.getString("witness_pan");
                                    String mobile = jsonObject.getString("investigation_witness_mobile");
                                    String is_witness = jsonObject.getString("is_i_witness");
                                    String fir_id = jsonObject.getString("fir_id");

                                    String investigation_witness_id = jsonObject.getString("investigation_witness_id");
                                    list.add(new Witness(country, state, district, city, fname, mname, lname, address,
                                            dob, email, adhar, gender,
                                            photo_path, pan, mobile, is_witness,
                                            fir_id, investigation_witness_id));
                                }
                                callback.onSuccess(list);

                            } catch (JSONException e) {
                                System.out.println("error" + e.toString());
                                callback.onErro(e.toString());
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("resposne"+error.toString());
                callback.onErro(error.toString());
                error.printStackTrace();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("investigation_witness_id",witness_id );
                return map;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public void getWitnessByDate(String witness_id, Context context ,Callback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, getwitnessDetailByDate,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response "+response.toString());
                        if (!response.isEmpty()&&response.length()>1) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String witness_history_id = jsonObject.getString("witness_history_id");
                                    String witness_id = jsonObject.getString("witness_id");
                                    String police_id = jsonObject.getString("police_id");
                                    String tracking_date = jsonObject.getString("tracking_date");
                                    String operation = jsonObject.getString("operation");
                                    String description = jsonObject.getString("description");
                                    String created_at = jsonObject.getString("created_at");
                                    listt.add(new WitnessTracking(witness_history_id, witness_id, police_id, tracking_date, operation, description, created_at));
                                }
                                callback.onSuccess(listt);
                            } catch (Exception e) {
                                callback.onErro(e.toString());
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                        else {
                            callback.onErro("NoData");
                        }
                    }
                },
                new Response.ErrorListener() {
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
//                map.put("witness_id", "3");
                map.put("witness_id", witness_id);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }

    ;

    public Witness createwitness(Witness insertwitness, Context context, Callback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, createwitness_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response" + response.toString());
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String investigation_witness_id = jsonObject.getString("investigation_witness_id");
                            callback.onSuccess(investigation_witness_id);
                            }


                        } catch (Exception e) {
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
                map.put("fir_id","2023-12-14-1"); //String.valueOf(insertwitness.getFir_id()));
                map.put("witness_fname", insertwitness.getFname());
                map.put("witness_mname","aaa"); //insertwitness.getMname());
                map.put("witness_lname","bbb"); //insertwitness.getLname());
                map.put("country_id", "1");
                //insertsuspect.getAddress());
                map.put("state_id", "1");

                //insertsuspect.  getCity());
                map.put("district_id", "1");
                // insertsuspect. getState());
                map.put("city_id", "1");
                //insertsuspect. getDistrict());
                map.put("witness_gender", insertwitness.getGender());
                map.put("witness_dob", insertwitness.getDob());
                map.put("witness_email", insertwitness.getEmail());
                map.put("witness_mobile_no", insertwitness.getMobile());
                //   map.put("",insertsuspect. getIs_suspect());
                map.put("witness_adhar", insertwitness.getAdhar());
                map.put("witness_address", insertwitness.getAddress());
//                map.put("witness_pan_no", insertwitness.getPan());
                map.put("witness_photo", insertwitness.getPhoto_path());
                UserDataAccess userDataAccess=new UserDataAccess();
                Activity activity=(Activity)context;

                map.put("police_id",userDataAccess.getPoliceId(activity));
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return create_witness;
    }

    ;

    public Witness updatewitness(Witness updatewitness, Context context) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, updatesWitness_url,
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
                map.put("fir_id", String.valueOf(updatewitness.getFir_id()));
                map.put("witness_fname", updatewitness.getFname());
                map.put("witness_mname", updatewitness.getMname());
                map.put("witness_lname", updatewitness.getLname());
                map.put("country_id", "1");
                //insertsuspect.getAddress());
                map.put("state_id", "1");

                //insertsuspect.  getCity());
                map.put("district_id", "1");
                // insertsuspect. getState());
                map.put("city_id", "1");
                //insertsuspect. getDistrict());
                map.put("witness_gender", updatewitness.getGender());
                map.put("witness_dob", updatewitness.getDob());
                map.put("witness_email", updatewitness.getEmail());
                map.put("witness_mobile_no", updatewitness.getMobile());
                //   map.put("",insertsuspect. getIs_suspect());
                map.put("witness_adhar", updatewitness.getAdhar());
                map.put("witness_address", updatewitness.getAddress());
                map.put("witness_pan_no", updatewitness.getPan());
                map.put("witness_photo", updatewitness.getPhoto_path());
                UserDataAccess userDataAccess=new UserDataAccess();
                Activity activity=(Activity)context;

                map.put("police_id",userDataAccess.getPoliceId(activity));                map.put("investigation_witness_id", String.valueOf(updatewitness.getInvestigation_witness_id()));
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return update_witness;
    }

    public ArrayList<String> search_witness(Witness search_witness, Context context) {
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
                map.put("search", String.valueOf(search_witness.getInvestigation_witness_id()));
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return search_list;
    }

    ;

    public Witness delete_witness(int investigation_witness_id, Context context) {
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
                map.put("investigation_witness_id", String.valueOf(investigation_witness_id));


                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return delete_witness;

}

}
