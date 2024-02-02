package com.ltrsoft.police_app.Model;

import android.app.Activity;
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
import com.ltrsoft.police_app.Classes.News;
import com.ltrsoft.police_app.interface1.Callback;
import com.ltrsoft.police_app.utils.UserDataAccess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewsDeo {

     Integer news_id=1;
    News newseone;
    News create_news;
    News update_news;
    News delete_news;

    String Police_id="1";
    String getonenews_URL="";

    String Search_URL="";
    String delete_URL="";

    String createnews_url="https://rj.ltr-soft.com/public/police_api/news/create_news.php";
    String updatenews_url="https://rj.ltr-soft.com/public/police_api/news/update_news.php";
    String getAllnews_URL="https://rj.ltr-soft.com/public/police_api/news/last_news.php";
    String searchUrl="";
    public ArrayList<News> list = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();


    public  void addnewsImage(int news_id,String Photopath,Context context,Callback callback){

        String URL="http://rj.ltr-soft.com/public/police_api/news_photos/create_news_p.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Toast.makeText(getContext(), "Success! " + response, Toast.LENGTH_SHORT).show();
                        Log.d("Response", response);

                        callback.onSuccess("success");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onErro(error.toString());
             }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("news_id", String.valueOf(news_id));
                param.put("photo",  Photopath);
                return param;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


    }


    public void sendLikeCountToServer(int newsId, int likeCount,Context context,Callback callback) {


        String url = "https://your_server/insert_like_count.php";

        // Create a request
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Handle the response from the server if needed
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle the error if the request fails
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Parameters to send to the server
                Map<String, String> params = new HashMap<>();
                params.put("news_id", String.valueOf(newsId));
                params.put("like_count", String.valueOf(likeCount));
                return params;
            }
        };

        // Add the request to the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        queue.add(request);
    }

    public void getNews(Context context, Callback callback) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, getAllnews_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String news_id = jsonObject.getString("news_id");
                                Integer station_id = jsonObject.getInt("station_id");
                                Integer like = jsonObject.getInt("like");
                                String news_photo_path = jsonObject.getString("news_date");
//                                String news_category_name = jsonObject.getString("news_category_name");
                                String news_title = jsonObject.getString("news_title");
                                String news_description = jsonObject.getString("news_description");
                                String news_date = jsonObject.getString("news_date");
                                 list.add(new News(news_id,news_title,news_description,news_photo_path));
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
                error.printStackTrace();
                callback.onErro(error.toString());
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
     }


    public News getonenews( News news_id, Context context ){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,  getonenews_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Integer news_id = jsonObject.getInt("news_id");
                                Integer station_id=jsonObject.getInt("station_id");
                                Integer like=jsonObject.getInt("like");
                                Integer news_photo_id=jsonObject.getInt("news_photos_id");
                                String news_category_name=jsonObject.getString("news_category_name");
                                String news_title = jsonObject.getString("news_title");
                                String news_description = jsonObject.getString("news_description");
                                String news_date = jsonObject.getString("news_date");
//                                 list.add(new News(news_id, station_id,like,news_photo_id,news_title,news_description,news_date,
//                                         news_category_name ));

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
                map.put("news_id", String.valueOf(news_id));
                return map;
            }
        };


        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        return newseone;

    };

    public  void createnews(News insertnews, Context context, Activity activity, Callback callback){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,  createnews_url ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response"+response.toString());
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                Integer   news_id = jsonObject. getInt("news_id");
                               // Integer news_photos_id=jsonObject.getInt("news_photos_id");

                            }

                           callback.onSuccess(news_id);

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
                map.put("news_category_id","1");
                UserDataAccess userDataAccess=new UserDataAccess();
                Activity activity=(Activity)context;

                map.put("station_id",userDataAccess.getStationId(activity));

                 map.put("news_title","news title");
                        //insertnews. getNews_title());
                //UserDataAccess userDataAccess=new UserDataAccess();
                map.put("news_description","hello ");
                       // insertnews.getNews_description());
               // map.put("police_id",userDataAccess.getUserId(activity));
              //   map.put("evidance_photos_description",insertnews.getNews_description());
                map.put("news_date","22");
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



     };
    public News updateNews(News updatenews,Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,   updatenews_url ,
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
                map.put("news_id", String.valueOf(update_news.getNews_id()));
                map.put("news_category_id","1");
                UserDataAccess userDataAccess=new UserDataAccess();
                Activity activity=(Activity)context;

                map.put("station_id",userDataAccess.getStationId(activity));                map.put("news_title",update_news. getNews_title());
                 map.put("evidance_photos_path",updatenews.getNews_photo_path());
                map.put("evidance_photos_description",update_news.getNews_description());
                map.put("news_date",update_news.getNews_date());
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return  updatenews;
    }
    public ArrayList<String> search_news(News search_news, Context context){
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
                map.put("search", String.valueOf( search_news. getNews_id()));
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return search_list;
    };

    public News delete_news(int  news_id,Context context){
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
                map.put("news_id", String.valueOf( news_id));


                return map;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


        return delete_news;
    }
}
