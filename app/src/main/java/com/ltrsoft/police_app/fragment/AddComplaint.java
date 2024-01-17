package com.ltrsoft.police_app.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.ltrsoft.police_app.Classes.Complaint;
import com.ltrsoft.police_app.Model.ComplaintDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AddComplaint extends Fragment {

    private FusedLocationProviderClient mFusedLocationClient;
    private com.google.android.gms.location.LocationRequest mLocationRequest;
    public static final String URL_complain= "https://rj.ltr-soft.com/public/police_api/data/c_type_read.php";
    private String URL = "https://rj.ltr-soft.com/public/police_api/data/complaint_insert.php";
    public EditText complain_name,complain_contact_no,incident_date,complain_Against,complain_description,incident_address;
    private Spinner station_id,complain_Type;
    Button submit,complain_location;
    int PERMISSION_ID = 44;
    private RequestQueue requestQueue1;

    ArrayList<String> list,list_complain;
    private ArrayAdapter adapter,adapter2;

    String lattitude = "", langitude = "";
    String complaint_type_id;
    private  String id;

    private static final String STATION_URL = "https://rj.ltr-soft.com/public/police_api/police_station/read_police_station.php";

    public AddComplaint() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.add_complaint, container, false);

        complain_contact_no = view.findViewById(R.id.complain_contact_no);
        incident_date = view.findViewById(R.id.incident_date);
        complain_Against = view.findViewById(R.id.complain_Against);
        complain_description = view.findViewById(R.id.complain_description);
         incident_address = view.findViewById(R.id.incident_address);
        station_id = view.findViewById(R.id.complain_station_id);
        complain_Type = view.findViewById(R.id.complain_Type);
        // complain_name = view.findViewById(R.id.complain_name);
        submit = view.findViewById(R.id.submit);

        loadSattion();
        loadcomplaintype();

        Bundle bundle = getArguments();
        if (bundle!=null){
            id = bundle.getString("userid");
        }
        view.findViewById(R.id.User_registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentManager fragmentManager=getFragmentManager();
//                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.main_container,new Add_user_complaint_registration());
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String complain_name1= "hello";
        final String complain_desc1=  complain_description.getText().toString().trim();
        final String complain_against1= complain_Against.getText().toString().trim();
        final String incident_date1=  incident_date.getText().toString().trim();
        final String complain_contact_nocomplain_contact_no=  complain_contact_no.getText().toString().trim();
        final String incident_address1= incident_address.getText().toString().trim();
        final String complain_Against1=  complain_Against.getText().toString().trim();


         final  Integer status_id=1;
        final Integer user_id=1;


                ComplaintDeo complaintDeo=new ComplaintDeo();
                complaintDeo.createcomplaint(new Complaint(complain_name1, complain_desc1, complain_against1, incident_date1,
                        complain_contact_nocomplain_contact_no, incident_address1, complain_Against1, status_id, user_id), getContext(), new Callback() {
                    @Override
                    public void onSuccess(Object obj) {
                        String success=(String) obj;
                        Toast.makeText(getContext(), ""+success, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onErro(String errro) {
                        Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();
                    }
                });
                //registratin();


            }
        });
        incident_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        return view;

     }
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                getActivity(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                        // Handle the date selection or update the TextView
                        String dateOfBirth = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        incident_date.setText(dateOfBirth);
                    }
                },
                year,
                month,
                day);

        // Show the date picker dialog
        datePickerDialog.show();
    }


    private void loadcomplaintype() {
        StringRequest request = new StringRequest(Request.Method.POST,URL_complain, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Toast.makeText(getContext(), "response = "+response.toString(), Toast.LENGTH_SHORT).show();
                list_complain= new ArrayList<>();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Integer sta = Integer.valueOf(jsonObject.getString("complaint_type_id"));
                        list_complain.add(String.valueOf(sta));
                    }
                } catch (JSONException e) {
                    Toast.makeText(getContext(), "error json "+e.toString(), Toast.LENGTH_SHORT).show();
                    throw new RuntimeException(e);
                }
                adapter2 = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,list_complain);
                adapter2.setDropDownViewResource(android.R.layout.simple_list_item_1);
                complain_Type.setAdapter(adapter2);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        requestQueue1 = Volley.newRequestQueue(getContext());
        requestQueue1.add(request);
    }




    private void loadSattion() {
        StringRequest request = new StringRequest(Request.Method.POST, STATION_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Toast.makeText(getContext(), "response = "+response.toString(), Toast.LENGTH_SHORT).show();
                list = new ArrayList<>();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String sta = jsonObject.getString("police_station_name");
                        list.add(sta);
                    }
                } catch (JSONException e) {
                    Toast.makeText(getContext(), "error json "+e.toString(), Toast.LENGTH_SHORT).show();
                    throw new RuntimeException(e);
                }
                adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,list);
                adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                station_id.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        requestQueue1 = Volley.newRequestQueue(getContext());
        requestQueue1.add(request);
    }


//    private void registratin() {
//        //final String complain_name1=this.complain_name.getText().toString().trim();
//        final String complain_desc=this. complain_description.getText().toString().trim();
//        final String complain_against=this.complain_Against.getText().toString().trim();
//        final String incident_date=this. incident_date.getText().toString().trim();
//        final String complain_contact_nocomplain_contact_no=this. complain_contact_no.getText().toString().trim();
//        final String incident_address=this.incident_address.getText().toString().trim();
//        final String complain_Against=this. complain_Against.getText().toString().trim();
//
//        // final String status_id="1";
//        final String user_id="1";
//        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//
//                        Log.d("respone",response.toString());
//
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            JSONObject jsonObject1 = jsonObject.getJSONObject("complaint_data");
//                            String complain_id = jsonObject1.getString("complaint_id");
//                            Toast.makeText(getContext(), "complain id = "+complain_id, Toast.LENGTH_SHORT).show();
//                            Log.d("complaint id ",complain_id);
//                            SharedPreferences pref = getActivity().getSharedPreferences("complaint_id", MODE_PRIVATE);
//                            SharedPreferences.Editor editor = pref.edit();
//                            editor.putString("complaint_id", complain_id);
//                            //  editor.putString("complaint_name", complain_name1);
//                            editor.putBoolean("flag", false).apply();
//
//                        } catch (JSONException e) {
//                            Log.d("error ",e.toString());
//                            throw new RuntimeException(e);
//                        }
//                    }
//
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getContext(), "error"+error, Toast.LENGTH_SHORT).show();
//                    }
//                }){
//            @Nullable
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> param = new HashMap<>();
//                // param.put("",complain_name);
//                param.put("complaint_type_id","1");//complaint_type_id);
//                param.put("complaint_description",complain_desc);
//                param.put("complaint_against",complain_Against);
//                param.put("incident_date",incident_date);
//                // param.put("",victim_name);
//                //param.put("status_id",status_id);
//                param.put("complaint_location",incident_address);
//                param.put("station_id","1");
//                if (user_id!=null){
//                    param.put("user_id",user_id);
//                }else {
//                    param.put("user_id","1");
//                }
//                param.put("latitude",langitude);
//                param.put("longitude",langitude);
//
//                return param;
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//        requestQueue.add(stringRequest);
//
//
//
//    }
}