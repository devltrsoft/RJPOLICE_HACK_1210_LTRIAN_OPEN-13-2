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
import com.ltrsoft.police_app.Classes.Warrant;
import com.ltrsoft.police_app.interface1.Callback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WarrantDeo {


String Warrant_type_id="https://rj.ltr-soft.com/public/police_api/warrant_type/read_warrant_type.php";
    ArrayList list1=new ArrayList();

        String investigation_id, Warrant_id;
        Warrant warrantone;
        Warrant create_warrant;
        Warrant update_warrant;
        Warrant delete_warrant;
        String police_id = "1";
        String getoneWarrant_URL = "";

        String Search_URL = "";
        String delete_URL = "";

        String createwarrant_url = "https://rj.ltr-soft.com/public/police_api/warrant/create_warrant.php";
        String updatesWarrant_url = "https://rj.ltr-soft.com/public/police_api/investigation_witness/create__investigation_witness.php";
        String getAllWarrant_URL = "https://rj.ltr-soft.com/public/police_api/warrant/read_warrant.php";
        String searcgUrl = "";
        public ArrayList<Warrant> list = new ArrayList<>();
        public ArrayList<String> search_list = new ArrayList<String>();

        public void  getAllWarrant(  Context context,Callback callback){

            StringRequest stringRequest = new StringRequest(Request.Method.POST, getAllWarrant_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);


                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String warrent_type = jsonObject.getString("warrant_type_name");
                                    String warrent_against=jsonObject.getString("warrant_against");
                                    String date_issued=jsonObject.getString("date_issued");
                                    String discription=jsonObject.getString("description");
                                    String action=jsonObject.getString("action");
                                    String court_name=jsonObject.getString("court_name");
                                    String issuing_authority=jsonObject.getString("issuing_authority");
                                    String fir_id =  jsonObject.getString("fir_id");
                                    String warrent_id = jsonObject.getString("warrant_id");

                                    list.add(new Warrant(warrent_id,fir_id, date_issued,discription,action,court_name,
                                            issuing_authority,warrent_against ,warrent_type));
                                       callback.onSuccess(list);
                                }
                            } catch (Exception e) {
                                callback.onErro(e.toString());
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                    },
                    new Response.ErrorListener() {
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
                  //  map.put(" fir_id", String.valueOf( fir_id));
                    return map;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);

        }

        public Warrant warrentone(int warrant_id, Context context) {

            StringRequest stringRequest = new StringRequest(Request.Method.POST, getoneWarrant_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);


                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    String warrent_type = jsonObject.getString("warrant_type");
                                    String warrent_against=jsonObject.getString("warrant_against");
                                    String date_issued=jsonObject.getString("date_issued");
                                    String discription=jsonObject.getString("description");
                                    String action=jsonObject.getString("action");
                                    String court_name=jsonObject.getString("court_name");
                                    String issuing_authority=jsonObject.getString("issuing_authority");
                                    String fir_id = jsonObject.getString("fir_id");
                                    String warrent_id = jsonObject.getString("investigation_witness_id");

                                    list.add(new Warrant(warrent_id, fir_id,date_issued,discription,action,court_name,
                                            issuing_authority,warrent_against ,warrent_type));

                                }
                            } catch (Exception e) {
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
                    }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("warrent_id", String.valueOf(Warrant_id));
                    return map;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);

            return warrantone;

        }

        public void createwarrant(Warrant insertwarrant, Context context, Callback callback) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, createwarrant_url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                           System.out.println("response" + response.toString());
//                            try {
//                                JSONArray jsonArray = new JSONArray(response);
//                                for (int i = 0; i < jsonArray.length(); i++) {
//                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                    String warrant_id = jsonObject.getString("warrant_id");
//                                  callback.onSuccess(warrant_id);
//                                }
//
//
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                              callback.onErro(e.toString());
//                            }
//
                      callback.onSuccess(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                  //  Toast.makeText(context, "error " + error.toString(), Toast.LENGTH_SHORT).show();
                callback.onErro(error.toString());
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("fir_id",  "2023-12-14-1");//insertwarrant.getFir_id());
                    map.put("warrant_type_id", "1");//insertwarrant.getWarrant_type());
                    map.put("warrant_against", insertwarrant.getWarrant_against());
                    map.put("date_issued", insertwarrant.getDate_issued());
                    map.put("description", insertwarrant.getDiscription());
                    map.put("action", insertwarrant.getAction());
                    map.put("court_name", insertwarrant.getCourt_name());
                    map.put("issuing_authority", insertwarrant.getIssuing_athority());



                    return map;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);


         }

        public Warrant updatewarrant(Warrant updatewarrant, Context context) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, updatesWarrant_url,
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
                    map.put("fir_id", String.valueOf(updatewarrant.getFir_id()));
                    map.put("warrent_type", updatewarrant.getWarrant_type());
                    map.put("warrant_against", updatewarrant.getWarrant_against());
                    map.put("date_issued", updatewarrant.getDate_issued());
                    map.put("description", updatewarrant.getDiscription());
                    map.put("action", updatewarrant.getAction());
                    map.put("court_name", updatewarrant.getCourt_name());
                    map.put("issuing_authority", updatewarrant.getIssuing_athority());
                    map.put("police_id", police_id);
                    map.put("investigation_witness_id", String.valueOf(updatewarrant.getWarrant_id()));

                    return map;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);


            return updatewarrant;
        }
        public ArrayList<String> search_warrent(Warrant search_warrent, Context context) {
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
                    map.put("search", String.valueOf(search_warrent.getWarrant_id()));
                    return map;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);


            return search_list;
        }

        public Warrant Delete_warrant(int warrant_id, Context context) {
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
                    map.put("warrant_id", String.valueOf(Warrant_id));


                    return map;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);


            return delete_warrant;

}

public void read_wrarrant_type(Context context, Callback callback){
            StringRequest stringRequest=new StringRequest(Request.Method.POST,
                    Warrant_type_id, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                  try{
                      JSONArray jsonArray=new JSONArray(response);

                      for (int i=0;i< jsonArray.length();i++){
                          JSONObject jsonObject=jsonArray.getJSONObject(i);
                          String warrant_type_name=jsonObject.getString("warrant_type_name");
                           list1.add(warrant_type_name);

                      }
                  }catch (Exception e){
                      callback.onErro(e.toString());
                  }
                  callback.onSuccess(list1);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

}



    }


