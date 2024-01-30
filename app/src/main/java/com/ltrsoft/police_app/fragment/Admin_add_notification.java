package com.ltrsoft.police_app.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ltrsoft.police_app.Classes.Notification;
import com.ltrsoft.police_app.Model.NotificationDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

public class Admin_add_notification extends Fragment {


    public Admin_add_notification() {
        // Required empty public constructor
    }

    String notification_type1,desc,station_id_1,title1;
    private EditText noti_title,Station_id,Desc,notification_type;
    private Button send;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.admin_add_notification, container, false);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        // Set the title on the ActionBar or Toolbar
        if (actionBar != null) {
            actionBar.setTitle("  Add Notification ");
        }
      noti_title=view.findViewById(R.id.noti_title);
      Station_id=view.findViewById(R.id.Station_id);
      Desc=view.findViewById(R.id.Desc);
      notification_type=view.findViewById(R.id.notification_type);
      send=view.findViewById(R.id.upload);
      send.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
                title1=noti_title.getText().toString();
                station_id_1=Station_id.getText().toString();
                desc=Desc.getText().toString();
                notification_type1=notification_type.getText().toString();
              if (title1.isEmpty()){
                  noti_title.setError("Enter The Notification Title");
                  Toast.makeText(getContext(), "Enter The Notification Title", Toast.LENGTH_SHORT).show();

              }
              else {
                  if (station_id_1.isEmpty()){
                      Station_id.setError("Enter The Station Id");
                      Toast.makeText(getContext(), "Enter The Station Id ", Toast.LENGTH_SHORT).show();

                  }
                  else {
                      if (desc.isEmpty()){
                          Desc.setError("Enter the Discryption");
                          Toast.makeText(getContext(), "Enter the Discryption", Toast.LENGTH_SHORT).show();

                      }
                      else {
                          if (notification_type1.isEmpty()){
                              notification_type.setError("Enter The Notification Type");
                              Toast.makeText(getContext(), "Enter The Notification Type", Toast.LENGTH_SHORT).show();

                          }
                          else {
                              sendrequest();


                          }
                      }
                  }
              }
          }
      });


    return view;
    }

    private void sendrequest() {
        NotificationDeo notificationDeo=new NotificationDeo();
        notificationDeo.createnotification(new Notification(title1, station_id_1, desc, notification_type1), getContext(), new Callback() {
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




    }
}