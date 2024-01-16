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
import com.ltrsoft.police_app.Classes.Suspect;
import com.ltrsoft.police_app.interface1.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SuspectDeo {
    String investigation_id,suspect_id;
    Suspect suspectone;
    Suspect create_suspect;
    Suspect update_suspect;
    Suspect delete_suspect;
    String Police_id="1";
    String getoneSuspect_URL="";

     String Search_URL="";
     String delete_URL="";

    String createsuspect_url="http://rj.ltr-soft.com/public/police_api/Investigation_suspect/create_investigation_suspect.php";
  String updatesuspect_url="rj.ltr-soft.com/public/police_api/Investigation_suspect/update_investigation_suspect.php";
    String getAllSuspect_URL="https://rj.ltr-soft.com/public/police_api/Investigation_suspect/read_investigation_suspect.php";
   String searcgUrl="";
    public ArrayList<Suspect>list = new ArrayList<>();
    public ArrayList<String> search_list=new ArrayList<String>();
     public ArrayList<Suspect> getAllSuspect(String fir_id, Context context) {

         StringRequest stringRequest = new StringRequest(Request.Method.POST, getAllSuspect_URL,
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
                                 String fname = jsonObject.getString("suspect_fname");
                                 String mname = jsonObject.getString("suspect_mname");
                                 String lname = jsonObject.getString("suspect_lname");
                                 String address = jsonObject.getString("");

                                 String dob = jsonObject.getString("suspect_dob");
                                 String email = jsonObject.getString("suspect_email");
                                 String adhar = jsonObject.getString("suspect_adhar");
                                 String gender = jsonObject.getString("suspect_gender");

                                 String photo_path = jsonObject.getString("suspect_photo");
                                 String pan = jsonObject.getString("suspect_mobile_no");
                                 String mobile = jsonObject.getString("suspect_mobile_no");
                                 String is_suspect = jsonObject.getString("is_i_suspect");
                                 int fir_id = jsonObject.getInt("fir_id");
                                 int investigation_suspect_id = jsonObject.getInt("investigation_suspect_id");
                                 list.add(new Suspect(country, state, district, city, fname, mname, lname, address,
                                         dob, email, adhar, gender,
                                         photo_path, pan, mobile, is_suspect,
                                         fir_id, investigation_suspect_id));
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


        public Suspect getoneSuspect(int investigation_suspect_id, Context context ){

         StringRequest stringRequest=new StringRequest(Request.Method.POST, getoneSuspect_URL,
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
                            String fname = jsonObject.getString("suspect_fname");
                            String mname = jsonObject.getString("suspect_mname");
                            String lname = jsonObject.getString("suspect_lname");
                            String address = jsonObject.getString("suspect_address");

                            String dob = jsonObject.getString("suspect_dob");
                            String email = jsonObject.getString("suspect_email");
                            String adhar = jsonObject.getString("suspect_adhar");
                            String gender = jsonObject.getString("suspect_gender");

                            String photo_path = jsonObject.getString("suspect_photo");
                            String pan = jsonObject.getString("suspect_mobile_no");
                            String mobile = jsonObject.getString("suspect_mobile_no");
                            String is_suspect = jsonObject.getString("is_i_suspect");
                            int fir_id = jsonObject.getInt("fir_id");
                            int investigation_suspect_id = jsonObject.getInt("investigation_suspect_id");
                             suspectone=new Suspect(country, state, district, city, fname, mname, lname, address,
                                    dob, email, adhar, gender,
                                    photo_path, pan, mobile, is_suspect,
                                    fir_id, investigation_suspect_id);
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
                  map.put("investigation_suspect_id", String.valueOf(investigation_suspect_id));
                  return map;
             }
         };


           RequestQueue requestQueue=Volley.newRequestQueue(context);
           requestQueue.add(stringRequest);
           return suspectone;

         };

      public Suspect createsuspect(Suspect insertsuspect,Context context,Callback callback){
          StringRequest stringRequest = new StringRequest(Request.Method.POST, createsuspect_url ,
                  new Response.Listener<String>() {
                      @Override
                      public void onResponse(String response) {
                          System.out.println("response"+response.toString());
                         try {
                             JSONArray jsonArray=new JSONArray(response);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            String  investigation_suspect_id = jsonObject.getString("investigation_suspect_id");
                         callback.onSuccess(investigation_suspect_id);
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
                  map.put("fir_id", String.valueOf(insertsuspect.getFir_id()));
                 map.put("suspect_fname",insertsuspect.getFname());
                map.put("suspect_mname",insertsuspect.getMname());
                  map.put("suspect_lname",insertsuspect.getLname());
                  map.put("country_id","1");
                          //insertsuspect.getAddress());
                  map.put("state_id","1");

                          //insertsuspect.  getCity());
                  map.put("district_id","1");
                         // insertsuspect. getState());
                  map.put("city_id","1");
                          //insertsuspect. getDistrict());
                  map.put("suspect_gender",insertsuspect.getGender());
                  map.put("suspect_dob",insertsuspect.getDob());
                  map.put("suspect_email",insertsuspect.getEmail());
                  map.put("suspect_mobile_no",insertsuspect. getMobile());
               //   map.put("",insertsuspect. getIs_suspect());
                  map.put("suspect_adhar",insertsuspect.getAdhar());
                  map.put("suspect_address",insertsuspect. getAddress());
                  map.put("suspect_pan_no",insertsuspect.  getPan());
                  map.put("suspect_photo",insertsuspect.  getPhoto_path());
                    map.put("police_id",Police_id);

                  return map;
              }
          };

          RequestQueue requestQueue = Volley.newRequestQueue( context);
          requestQueue.add(stringRequest);



       return create_suspect;
      };
   public Suspect updatesuspect(Suspect updatesuspect, Context context, Callback callback){
       StringRequest stringRequest = new StringRequest(Request.Method.POST,  updatesuspect_url ,
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
               map.put("fir_id", String.valueOf( updatesuspect.getFir_id()));
               map.put("suspect_fname",updatesuspect.getFname());
               map.put("suspect_mname",updatesuspect.getMname());
               map.put("suspect_lname",updatesuspect.getLname());
               map.put("country_id","1");
               //insertsuspect.getAddress());
               map.put("state_id","1");

               //insertsuspect.  getCity());
               map.put("district_id","1");
               // insertsuspect. getState());
               map.put("city_id","1");
               //insertsuspect. getDistrict());
               map.put("suspect_gender",updatesuspect.getGender());
               map.put("suspect_dob",updatesuspect.getDob());
               map.put("suspect_email",updatesuspect.getEmail());
               map.put("suspect_mobile_no",updatesuspect. getMobile());
               //   map.put("",insertsuspect. getIs_suspect());
               map.put("suspect_adhar",updatesuspect.getAdhar());
               map.put("suspect_address",updatesuspect. getAddress());
               map.put("suspect_pan_no",updatesuspect.  getPan());
               map.put("suspect_photo",updatesuspect.  getPhoto_path());
               map.put("police_id",Police_id);
              map.put("investigation_suspect_id", String.valueOf(updatesuspect.getInvestigation_suspect_id()));
               return map;
           }
       };

       RequestQueue requestQueue = Volley.newRequestQueue( context);
       requestQueue.add(stringRequest);



       return update_suspect;
   }
    public ArrayList<String> search_suspect(Suspect search_suspect, Context context){
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
              map.put("search", String.valueOf( search_suspect.getInvestigation_suspect_id()));
              return map;
             }
         };
        RequestQueue requestQueue = Volley.newRequestQueue( context);
        requestQueue.add(stringRequest);



        return search_list;
    };

   public Suspect delete_suspect(int investigation_suspect_id,Context context){
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
               map.put("investigation_suspect_id", String.valueOf(investigation_suspect_id));


               return map;
          }
      };

    RequestQueue requestQueue= Volley.newRequestQueue(context);
    requestQueue.add(stringRequest);


       return delete_suspect;
   }



}
