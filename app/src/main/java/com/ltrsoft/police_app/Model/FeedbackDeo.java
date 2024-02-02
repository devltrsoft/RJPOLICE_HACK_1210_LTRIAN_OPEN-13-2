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
import com.ltrsoft.police_app.Classes.Feedback;
import com.ltrsoft.police_app.interface1.Callback;
import com.ltrsoft.police_app.utils.UserDataAccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FeedbackDeo {
    Feedback feedbackone;
    Feedback create_feedback;
    Feedback update_feedback;
    Feedback delete_feedback;
    String Police_id="1";
    String getonefeedback_URL="https://rj.ltr-soft.com/public/police_api/police_feedback/read_by_id.php";

    String Search_URL="";
    String delete_URL="";

    String create_feedback_url="https://rj.ltr-soft.com/public/police_api/police_feedback/create_p_feed.php";
    String update_feedback_url="https://rj.ltr-soft.com/public/police_api/police_feedback/update_p_feed.php";
    String getAll_feedback_URL="https://rj.ltr-soft.com/public/police_api/police_feedback/read_p_feed.php";
    String searchUrl="";
    public ArrayList<Feedback> list = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();
    public ArrayList<Feedback> getAllFeedback(String police_feedback_id, Context context) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,  getAll_feedback_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                                Integer police_feedback_id = jsonObject.getInt("police_feedback_id");
//                                Integer notification_station_id=jsonObject.getInt("notification_station_id");
//                                Integer notification_photo_id=jsonObject.getInt("notification_photo_id");
//                                String notification_description=jsonObject.getString("notification_description");
//                                String notification_type = jsonObject.getString("notification_type");
//                                String notification_photo_path = jsonObject.getString("notification_photo_path");
//
//                                list.add(new Notification(notification_id, notification_station_id,notification_photo_id,
//                                        notification_description,notification_type,notification_photo_path ));
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


    public Feedback getone_Feedback( Feedback  police_feedback_id, Context context ){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,  getonefeedback_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        try{
//                            JSONArray jsonArray=new JSONArray(response);
// //                           for (int i = 0; i < jsonArray.length(); i++) {
////                                JSONObject jsonObject = jsonArray.getJSONObject(i);
////                                Integer notification_id = jsonObject.getInt("notification_id");
////                                Integer notification_station_id=jsonObject.getInt("notification_station_id");
////                                Integer notification_photo_id=jsonObject.getInt("notification_photo_id");
////                                String notification_description=jsonObject.getString("notification_description");
////                                String notification_type = jsonObject.getString("notification_type");
////                                String notification_photo_path = jsonObject.getString("notification_photo_path");
////
////                                list.add(new Notification(notification_id, notification_station_id,notification_photo_id,
////                                        notification_description,notification_type,notification_photo_path ));
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
                map.put("police_feedback_id", String.valueOf(police_feedback_id));
                return map;
            }
        };


        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return feedbackone;

    };

    public  void   create_Feedback(Feedback insertfeedback, Context context, Activity activity, Callback callback){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,   create_feedback_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response.toString());
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                Integer   police_feedback_id = jsonObject. getInt("police_feedback_id");
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
                UserDataAccess userDataAccess =new UserDataAccess();

                map.put("police_id",userDataAccess.getPoliceId(activity));
                map.put("overall_satisfaction", String.valueOf(insertfeedback.getOverallsatisfication()));
                map.put("average_prating", String.valueOf(insertfeedback.getAvarage_prating()));
                map.put("relevance_info", String.valueOf(insertfeedback.getRelavance_info()));
                map.put("security_privacy", String.valueOf(insertfeedback.getSecurity_privacy()));
                map.put("alert_notification", String.valueOf(insertfeedback.getAlert_notification()));
                map.put("training_support", String.valueOf(insertfeedback.getTraining_support()));
                map.put("usability_navigation", String.valueOf(insertfeedback.getUsability_navigation()));

                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



     };
//    public Feedback update_feedback(Feedback updatefeedback,Context context){
//        StringRequest stringRequest = new StringRequest(Request.Method.POST,   update_feedback_url ,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        System.out.println("response"+response.toString());
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText( context, "error " + error.toString(), Toast.LENGTH_SHORT).show();
//            }
//        }) {
//            @Nullable
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> map = new HashMap<>();
//                map.put("police_feedback_id", String.valueOf(updatefeedback.getPolice_feedback_id()));
//                map.put("police_id", String.valueOf(updatefeedback.getPolice_id()));
//                map.put("overall_satisfaction",updatefeedback.getOverallsatisfication() );
//                map.put("average_prating",updatefeedback.getAvarage_prating() );
//                map.put("relevance_info",updatefeedback.getRelavance_info() );
//                map.put("security_privacy",updatefeedback.getSecurity_privacy() );
//                map.put("alert_notification",updatefeedback.getAlert_notification() );
//                map.put("training_support",updatefeedback.getTraining_support() );
//                map.put("usability_navigation",updatefeedback.getUsability_navigation());
//
//                return map;
//            }
//        };
//
//        RequestQueue requestQueue = Volley.newRequestQueue( context);
//        requestQueue.add(stringRequest);
//
//
//
//        return  update_feedback;
//    }
    public ArrayList<String> search_feedback(Feedback search_news, Context context){
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
                map.put("search", String.valueOf( search_news.   getPolice_feedback_id()));
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return search_list;
    };

    public Feedback delete_feedback(int  police_feedback_id,Context context){
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
                map.put("police_feedback_id", String.valueOf( police_feedback_id));


                return map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return delete_feedback;
    }

}
