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
import com.ltrsoft.police_app.Classes.Evidance;
import com.ltrsoft.police_app.interface1.Callback;
import com.ltrsoft.police_app.utils.UserDataAccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EvidanceDeo {
    String investigation_id,suspect_id;
    Integer evidance_id=1;
    Evidance evidanceone;
    Evidance create_evidance;
    Evidance update_evidance;
    Evidance delete_evidance;
     String getoneEvidance_URL="";

    ArrayList<Evidance> evidanceArrayList=new ArrayList<>();


    String Search_URL="";
    String delete_URL="";
    public static final String Get_one_complaint_evidance_by_evidanceid="https://rj.ltr-soft.com/public/police_api/evidance/read_evidance.php";
    public static final String URL="https://rj.ltr-soft.com/public/police_api/evidance/read_evidance.php";
    String createEvidance_url="https://rj.ltr-soft.com/public/police_api/evidance/create_evidance.php";
    String updateevidance_url="https://rj.ltr-soft.com/public/police_api/evidance/update_evidance.php";
    String getAllevidance_URL_BY_FIRID="https://rj.ltr-soft.com/public/police_api/evidance/read_by_fir.php";
    String searchUrl="";
    public ArrayList<Evidance> list = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();
    public static final String GET_ALL_Complaint_EVIDENCE_by_complaint_id="https://rj.ltr-soft.com/public/police_api/data/complaint_id_photo.php";

    public void Get_one_complaint_evidance_by_evidanceid(String evidenceId, Context context,Callback callback){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Get_one_complaint_evidance_by_evidanceid, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    String path = jsonObject.getString("complaint_photo_path");
                    String idd = jsonObject.getString("complaint_id");
                    String description = jsonObject.getString("evidence_description");
                    evidanceArrayList.add(new Evidance(idd,path,description));

                } catch (JSONException e) {
                    callback.onErro(e.toString());

                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap <String , String> hashMap = new HashMap();
                hashMap.put("evidence_id",evidenceId);
                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
 }


    public void GET_ALL_Complaint_EVIDENCE_by_complaint_id(String complaint_id, Context context , Callback callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_ALL_Complaint_EVIDENCE_by_complaint_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               // System.out.println("response = "+response.toString());
                if (!response.isEmpty()&&response.length()>1) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String complaint_photo_id = jsonObject.getString("complaint_photo_id");
                            String complaint_photo_path = jsonObject.getString("complaint_photo_path");
                            String complaint_photo_description = jsonObject.getString("complaint_photo_description");
                             evidanceArrayList.add(new Evidance(complaint_photo_id,complaint_photo_path,complaint_photo_description));
                        }
                    } catch (JSONException e) {
                        callBack.onErro(e.toString());
                        throw new RuntimeException(e);
                    }
                    callBack.onSuccess(evidanceArrayList);
                }
                else {
                    evidanceArrayList = new ArrayList<>();
                    callBack.onSuccess(evidanceArrayList);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onErro(error.toString());
                System.out.println("error "+error.toString());
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
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
}

    public void getAllEvidance(String firID,Context context,Callback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,  getAllevidance_URL_BY_FIRID,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.isEmpty()) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String fir_id = jsonObject.getString("fir_id");
                                    String evidance_id = jsonObject.getString("evidance_id");
                                    String evidance_name = jsonObject.getString("evidance_name");
                                    String evidance_description = jsonObject.getString("evidance_description");
                                    String evidance_photos_path = jsonObject.getString("evidance_photos_path");
                                    String evidance_photos_description = jsonObject.getString("evidance_photos_description");
                                    String evidance_photos_id = jsonObject.getString("evidance_photos_id");
                                    String evidencechangedate = jsonObject.getString("updated_at");
                                    list.add(new Evidance(evidance_id, fir_id, evidance_name, evidance_description, evidance_photos_path,
                                            evidance_photos_description, evidance_photos_id, evidencechangedate));
                                }
                                callback.onSuccess(list);
                            } catch (JSONException e) {
                                callback.onErro(e.toString());
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                        else {
                            callback.onErro("This FIR have no evidence");
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
                map.put("fir_id",firID);
                return map;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
    public Evidance getoneEvidance( Evidance evidance_id, Context context ){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,  getoneEvidance_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String fir_id = jsonObject.getString("fir_id");
                                String evidance_id=jsonObject.getString("evidance_id");
                                String evidance_name = jsonObject.getString("evidance_name");
                                String evidance_description = jsonObject.getString("evidance_description");
                                String evidance_photos_path = jsonObject.getString("evidance_photos_path");
                                String evidance_photos_description = jsonObject.getString("evidance_photos_description");
                                String evidance_photos_id=jsonObject.getString("evidance_photos_id");
                                list.add(new Evidance( evidance_id,fir_id,evidance_name,evidance_description,evidance_photos_path,
                                        evidance_photos_description,evidance_photos_id));


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
                map.put("evidance_id", String.valueOf(evidance_id));
                return map;
            }
        };


        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return evidanceone;

    };

    public Evidance createevidance(Evidance insertevidance, Context context, Callback callback){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,  createEvidance_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response.toString());
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                Integer   evidance_id = jsonObject. getInt("evidance_id");
                                Integer evidance_photos_id=jsonObject.getInt("evidance_photos_id");
                                 callback.onSuccess(evidance_id);
                            }



                        }catch (Exception e){
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
               map.put("fir_id", String.valueOf(insertevidance.getFir_id()));
               map.put("evidance_name",insertevidance.getEvidance_name());
               map.put("evidance_description",insertevidance.getDiscription());
                UserDataAccess userDataAccess=new UserDataAccess();
                Activity activity=(Activity)context;

                map.put("police_id",userDataAccess.getPoliceId(activity));
                map.put("evidance_photos_path",insertevidance.getEvidance_photos_path());
               //map.put("evidance_photos_description",insertevidance.getEvidance_photos_description());
                 return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return create_evidance;
    };
    public Evidance updateevidance(Evidance updateevidance,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,   updateevidance_url ,
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
                map.put("fir_id", String.valueOf(updateevidance.getFir_id()));
                map.put("evidance_name",updateevidance.getEvidance_name());
                map.put("evidance_description",updateevidance.getDiscription());
                UserDataAccess userDataAccess=new UserDataAccess();
                Activity activity=(Activity)context;

                map.put("police_id",userDataAccess.getPoliceId(activity));                map.put("evidance_photos_path",updateevidance.getEvidance_photos_path());
                map.put("evidance_photos_description",updateevidance.getEvidance_photos_description());
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return update_evidance;
    }
    public ArrayList<String> search_evidance(Evidance search_evidance, Context context){
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
                map.put("search", String.valueOf( search_evidance.getEvidance_id()));
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return search_list;
    };

    public Evidance delete_evidance(int  evidance_id,Context context){
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
                map.put("evidance_id", String.valueOf( evidance_id));


                return map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return delete_evidance;
    }

}
