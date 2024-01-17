package com.ltrsoft.police_app.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.police_app.Adapter.MissingAdapter;
import com.ltrsoft.police_app.Classes.MissingPerson;
import com.ltrsoft.police_app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Missing_pages extends Fragment {
    private RecyclerView person_card_recycler;
    private String URl="https://rj.ltr-soft.com/public/police_api/data/read_missing.php";
    ArrayList<MissingPerson> list=new ArrayList<>();
    public Missing_pages() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.missing_pages, container, false);
        person_card_recycler=view.findViewById(R.id.missing_person_recycle);
        if (list!=null){
            list.clear();
        }
        loadCases();
     return view;
    }
    private void loadCases() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response",""+response.toString());
                        Toast.makeText(getContext(), "response = "+response.toString(), Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0 ;i < jsonArray.length() ; i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String person_name = jsonObject.getString("complaint_subject");
                                String person_description = jsonObject.getString("complaint_description");
                                String person_contact = jsonObject.getString("user_mobile1");
                                String person_location = jsonObject.getString("user_address");
                                list.add(new MissingPerson(R.drawable.poli1,person_name,person_description,person_contact,person_location));
                            }

                        } catch (JSONException e) {
                            Toast.makeText(getContext(), "json error"+e.toString(), Toast.LENGTH_SHORT).show();
                            throw new RuntimeException(e);
                        }
                        MissingAdapter adapter=new MissingAdapter(list);
                        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
                        person_card_recycler.setLayoutManager(layoutManager);
                        person_card_recycler.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext() ,"volley error"+error.toString(), Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                return param;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
}