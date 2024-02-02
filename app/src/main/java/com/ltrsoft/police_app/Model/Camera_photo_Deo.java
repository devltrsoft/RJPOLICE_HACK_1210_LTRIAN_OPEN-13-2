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
import com.ltrsoft.police_app.Classes.Camera_photo_uploading;
import com.ltrsoft.police_app.utils.UserDataAccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Camera_photo_Deo {
    Integer camera_uploading_id=1;
     Camera_photo_uploading camerareadone ;
     Camera_photo_uploading camera_photo_allread;
     Camera_photo_uploading update_camera_photo;
    Camera_photo_uploading delete_camera_photo;
    Camera_photo_uploading create_camera_photo;
    UserDataAccess userDataAccess=new UserDataAccess();

    String getoneCamera_URL="";

    String Search_URL="";
    String delete_URL="";

    String createCamera_url="https://rj.ltr-soft.com/public/police_api/camera_uploading/insert_camera.php";
    String updateCamera_url="https://rj.ltr-soft.com/public/police_api/camera_uploading/update_camera.php";
    String getAllCamera_URL="https://rj.ltr-soft.com/public/police_api/camera_uploading/read_camera.php";
    String searchUrl="";
    public ArrayList<Camera_photo_uploading> list = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();
    public ArrayList<Camera_photo_uploading> getAllcameraphoto (String fir_id, Context context) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,   getAllCamera_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Integer camera_uploading_id = jsonObject.getInt("camera_uploading_id");
                                String user_fname=jsonObject.getString("user_fname");
                                String user_mname=jsonObject.getString("user_mname");
                                String user_lname=jsonObject.getString("user_lname");
                               String user_name=user_fname+user_fname+user_lname;
                                String photo_path = jsonObject.getString("photo_path");
                                 String station_code = jsonObject.getString("station_code");
                                String discription = jsonObject.getString("description");
                                String  address=jsonObject.getString("address");
                                list.add(new Camera_photo_uploading(camera_uploading_id, user_name,photo_path,station_code,discription,
                                         address));
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


                return map;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return list;
    }


    public Camera_photo_uploading getonephoto( Camera_photo_uploading camera_uploading_id, Context context ){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,   getoneCamera_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Integer camera_uploading_id = jsonObject.getInt("camera_uploading_id");
                                String user_fname=jsonObject.getString("user_fname");
                                String user_mname=jsonObject.getString("user_mname");
                                String user_lname=jsonObject.getString("user_lname");
                                String user_name=user_fname+user_fname+user_lname;
                                String photo_path = jsonObject.getString("photo_path");
                                String station_code = jsonObject.getString("station_code");
                                String discription = jsonObject.getString("description");
                                String  address=jsonObject.getString("address");
                                list.add(new Camera_photo_uploading(camera_uploading_id, user_name,photo_path,station_code,discription,
                                        address));
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
                map.put("camera_uploading_id", String.valueOf(camera_uploading_id));
                return map;
            }
        };


        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return camerareadone ;

    };

    public  Camera_photo_uploading createsuspect(Camera_photo_uploading insertcamera_photo,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,   createCamera_url ,
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
                map.put("station_id", "1");
                map.put("user_id", "1");
                map.put("photo_path",insertcamera_photo.getPhoto_path());
                map.put("description",insertcamera_photo.getDiscription());
                map.put("address",insertcamera_photo.getAddress());
                 return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return create_camera_photo;
    };
    public Camera_photo_uploading updatecamera_update(Camera_photo_uploading camera_uploading_id,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,     updateCamera_url ,
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
                map.put("station_id", "1");
                map.put("user_id", "1");
                map.put("photo_path", update_camera_photo.getPhoto_path());
                map.put("description", update_camera_photo.getDiscription());
                map.put("address",update_camera_photo.getAddress());
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return update_camera_photo;
    }
    public ArrayList<String> search_camera_photo(Camera_photo_uploading search_camera_photo, Context context){
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
              //  map.put("search", String.valueOf(  search_camera_photo.getCamera_uploading_id);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return search_list;
    };

    public Camera_photo_uploading delete_suspect(int   camera_uploading_id,Context context){
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
                map.put("evidance_id", String.valueOf( camera_uploading_id));


                return map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return  delete_camera_photo;
    }

}
