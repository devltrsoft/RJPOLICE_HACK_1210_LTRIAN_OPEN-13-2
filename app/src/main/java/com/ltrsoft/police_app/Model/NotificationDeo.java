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
import com.ltrsoft.police_app.Classes.Notification;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NotificationDeo {

    Integer notification_id=1;
     Notification notificationeone;
    Notification create_notification;
    Notification update_notification;
    Notification delete_notification;
    String Police_id="1";
    String getonotification_URL="https://rj.ltr-soft.com/public/police_api/notification/last_notification.php";

    String Search_URL="";
    String delete_URL="";

    String createnotification_url="https://rj.ltr-soft.com/public/police_api/notification/create_notification.php";
    String updatenotification_url="https://rj.ltr-soft.com/public/police_api/notification/update_notification.php";
    String getAllnotification_URL="https://rj.ltr-soft.com/public/police_api/notification/select_notification.php";
    String searchUrl="";
    public ArrayList<Notification> list = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();
    public ArrayList<Notification> getNotification(String notification_id, Context context) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,  getAllnotification_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                Integer notification_id = jsonObject.getInt("notification_id");
                                Integer notification_station_id=jsonObject.getInt("notification_station_id");
                                Integer notification_photo_id=jsonObject.getInt("notification_photo_id");
                                String notification_description=jsonObject.getString("notification_description");
                                String notification_type = jsonObject.getString("notification_type");
                                String notification_photo_path = jsonObject.getString("notification_photo_path");

                                list.add(new Notification(notification_id, notification_station_id,notification_photo_id,
                                        notification_description,notification_type,notification_photo_path ));
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
                //  map.put("news_id", news_id);


                return map;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return list;
    }


    public Notification getonotification( Notification notification_id, Context context ){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,  getonotification_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Integer notification_id = jsonObject.getInt("notification_id");
                                Integer notification_station_id=jsonObject.getInt("notification_station_id");
                                Integer notification_photo_id=jsonObject.getInt("notification_photo_id");
                                String notification_description=jsonObject.getString("notification_description");
                                String notification_type = jsonObject.getString("notification_type");
                                String notification_photo_path = jsonObject.getString("notification_photo_path");

                                list.add(new Notification(notification_id, notification_station_id,notification_photo_id,
                                        notification_description,notification_type,notification_photo_path ));

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
                map.put("notification_id", String.valueOf(notification_id));
                return map;
            }
        };


        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return notificationeone;

    };

    public Notification createnotification(Notification insertnotification,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,  createnotification_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response.toString());
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                Integer   notification_id = jsonObject. getInt("notification_id");
                               // Integer news_photos_id=jsonObject.getInt("news_photos_id");

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
                map.put("notification_title",insertnotification.getNotification_title());
                map.put("station_id", "1");
                map.put("notification_description",insertnotification.getNotification_description());
                // map.put("police_id",Police_id);
//                map.put("evidance_photos_path",insertnews.getNews_photo_path());
//                map.put("evidance_photos_description",insertnews.getNews_description());
//                map.put("news_date",insertnews.getNews_date());
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return create_notification;
    };
    public Notification updatenotification(Notification updatenotification,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,   updatenotification_url ,
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
                map.put("notification_id", String.valueOf(updatenotification.getNotification_id()));
                map.put("notification_title",updatenotification.getNotification_title());
                map.put("station_id", "1");
                map.put("notification_description",updatenotification.getNotification_description());
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return  updatenotification;
    }
    public ArrayList<String> search_news(Notification search_news, Context context){
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
                map.put("search", String.valueOf( search_news.  getNotification_id()));
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return search_list;
    };

    public Notification delete_notification(int  notification_id,Context context){
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
                map.put("news_id", String.valueOf( notification_id));


                return map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return delete_notification;
    }
}
