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
import com.ltrsoft.police_app.Classes.Training_video;
import com.ltrsoft.police_app.utils.UserDataAccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Training_videoDeo {


    Integer  video_id=1;
    Training_video getonevideo;
    Training_video create_video;
    Training_video update_video;
    Training_video delete_video;
     String getonevideo_URL="";

    String Search_URL="";
    String delete_URL="";

    String createvideo_url="https://rj.ltr-soft.com/public/police_api/training_video/create_video.php";
    String updateevideo_url="https://rj.ltr-soft.com/public/police_api/training_video/update_video.php";
    String getAllvideo_URL="https://rj.ltr-soft.com/public/police_api/training_video/read_video.php";
    String searchUrl="";
    public ArrayList<Training_video> list = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();
    public ArrayList<Training_video> getAllEvidance(String fir_id, Context context) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,  getAllvideo_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        try {
//                            JSONArray jsonArray = new JSONArray(response);
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                Integer fir_id = jsonObject.getInt("fir_id");
//                                Integer evidance_id=jsonObject.getInt("evidance_id");
//                                String evidance_name = jsonObject.getString("evidance_name");
//                                String evidance_description = jsonObject.getString("evidance_description");
//                                String evidance_photos_path = jsonObject.getString("evidance_photos_path");
//                                String evidance_photos_description = jsonObject.getString("evidance_photos_description");
//                                String evidance_photos_id=jsonObject.getString("evidance_photos_id");
//                                list.add(new Evidance(fir_id,evidance_id,evidance_name,evidance_description,evidance_photos_path,
//                                        evidance_photos_description,evidance_photos_id));
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            throw new RuntimeException(e);
//
//                        }


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
                map.put("video_id", String.valueOf(video_id));
              //  map.put("evidance_id", String.valueOf(evidance_id));


                return map;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return list;
    }


    public Training_video getoneEvidance( Training_video evidance_id, Context context ){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,  getonevideo_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        try{
//                            JSONArray jsonArray=new JSONArray(response);
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                Integer fir_id = jsonObject.getInt("fir_id");
//                                Integer evidance_id=jsonObject.getInt("evidance_id");
//                                String evidance_name = jsonObject.getString("evidance_name");
//                                String evidance_description = jsonObject.getString("evidance_description");
//                                String evidance_photos_path = jsonObject.getString("evidance_photos_path");
//                                String evidance_photos_description = jsonObject.getString("evidance_photos_description");
//                                String evidance_photos_id=jsonObject.getString("evidance_photos_id");
//                                list.add(new Evidance(fir_id,evidance_id,evidance_name,evidance_description,evidance_photos_path,
//                                        evidance_photos_description,evidance_photos_id));
//
//
//                            }
//                        }
//                        catch ( Exception e){
//                            e.printStackTrace();
//                            throw new RuntimeException(e);
//                        }
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
        return getonevideo;

    };

    public Training_video createvideo(Training_video insertevideo,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,  createvideo_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response.toString());
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                Integer   video_id = jsonObject. getInt("video_id");
                                //  Integer evidance_photos_id=jsonObject.getInt("evidance_photos_id");

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
                map.put("video", String.valueOf(insertevideo.getVideo_path()));
                map.put("video_description",insertevideo.getVideo_description());
                map.put("video_subject",insertevideo.getVideo_subject());
                UserDataAccess userDataAccess=new UserDataAccess();
                Activity activity=(Activity)context;

                map.put("station_id",userDataAccess.getStationId(activity));
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return create_video;
    };
    public Training_video updateevideo(Training_video updatevideo,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,   updateevideo_url ,
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
                map.put("video_id", String.valueOf(updatevideo.getVideo_id()));
                map.put("video", String.valueOf(updatevideo.getVideo_path()));
                map.put("video_description",updatevideo.getVideo_description());
                map.put("video_subject",updatevideo.getVideo_subject());
                UserDataAccess userDataAccess=new UserDataAccess();
                Activity activity=(Activity)context;

                map.put("station_id",userDataAccess.getStationId(activity));
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return  updatevideo;
    }
    public ArrayList<String> search_video(Training_video search_video, Context context){
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
                map.put("search", String.valueOf(  search_video.getVideo_id()));
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return search_list;
    };

    public Training_video delete_video(int  video_id,Context context){
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
                map.put("video_id", String.valueOf( video_id));


                return map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return delete_video;
    }

}
