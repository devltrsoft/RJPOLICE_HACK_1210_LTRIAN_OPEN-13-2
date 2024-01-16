package com.ltrsoft.police_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ltrsoft.police_app.Classes.Police;
import com.ltrsoft.police_app.Model.PoliceDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

public class Registration extends Fragment {



    public Registration() {
        // Required empty public constructor
    }
    Button register;
    TextView login;
    EditText con_password,user_password,user_mobile,user_email,user_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.registration, container, false);
        register=view.findViewById(R.id.register);
        con_password=view.findViewById(R.id.con_password);
        user_password=view.findViewById(R.id.user_password);
        user_mobile=view.findViewById(R.id.user_mobile);
        user_email=view.findViewById(R.id.user_email);
        user_name=view.findViewById(R.id.user_name);
        login=view.findViewById(R.id.login_text);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                 getActivity().getSupportFragmentManager().beginTransaction()
//                         .replace(R.id.session_container, new Login())
//                         .addToBackStack(null)
//                         .commit();



                final String name1 = user_name.getText().toString().trim();
                final String email1 = user_email.getText().toString().trim();
                final String password1 = user_password.getText().toString().trim();
                final String confirmPassword1=con_password.getText().toString().trim();
                final String phone1 = user_mobile.getText().toString().trim();

                Toast.makeText(getContext(), ""+phone1, Toast.LENGTH_SHORT).show();

                if (!name1.isEmpty()){
                    if (!email1.isEmpty()){
                        if (!phone1.isEmpty()){
                            if (!password1.isEmpty()){
                                if (!confirmPassword1.isEmpty()){

                                    if (password1.equals(confirmPassword1)) {
//                                        Toast.makeText(getContext(), "Signup Success", Toast.LENGTH_SHORT).show();
//                                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new login())
//                                                 .commit();
                                        PoliceDeo policeDeo=new PoliceDeo();
                                        policeDeo.police_registration(new Police(name1, email1, password1, phone1), getContext(), new Callback() {
                                            @Override
                                            public void onSuccess(Object obj) {
                                                String success = (String)obj;
                                                Toast.makeText(getContext(), "success"+success, Toast.LENGTH_SHORT).show();
                                                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new login())
                                                .commit();
                                            }

                                            @Override
                                            public void onErro(String errro) {
                                                Toast.makeText(getContext(), "error "+errro, Toast.LENGTH_SHORT).show();

                                            }
                                        });



                                    }
                                    else {
                                        con_password.setError("Password is not same");
                                    }

                                }else {
                                    con_password.setError("Please insert confirm password");
                                }

                            }else {
                                user_password.setError("Please insert password");
                            }

                        }else {
                            user_mobile.setError("Please insert Phone no");
                        }

                    }else {
                        user_email.setError("Please insert email");
                    }
                }else {
                    user_name.setError("Please insert name");
                }

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new login())
                         .commit();
            }
        });

    return  view;
    }
}