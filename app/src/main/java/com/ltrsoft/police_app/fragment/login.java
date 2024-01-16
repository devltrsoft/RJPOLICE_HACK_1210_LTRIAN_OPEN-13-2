package com.ltrsoft.police_app.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.ltrsoft.police_app.MainActivity;
import com.ltrsoft.police_app.Model.PoliceDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;
import com.ltrsoft.police_app.utils.UserDataAccess;

public class login extends Fragment {


    public login() {
        // Required empty public constructor
    }

    Button loginbtn;
    EditText Email,Password;
    TextView registration,forgot_password;

    private static String URL = "https://rj.ltr-soft.com/public/police_api/login/user_login.php";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          View view= inflater.inflate(R.layout.login, container, false);


        loginbtn=view.findViewById(R.id.loginbtn);
        registration=view.findViewById(R.id.registration);
        forgot_password=view.findViewById(R.id.forgot_password);
        Email=view.findViewById(R.id.email);
        Password=view.findViewById(R.id.password);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String mEmail = Email.getText().toString().trim();
                String mPass = Password.getText().toString().trim();


                if (!mEmail.isEmpty() || !mPass.isEmpty()) {

                    PoliceDeo policeDeo = new PoliceDeo();
                    policeDeo.police_login(new Police(mEmail, mPass), getContext(), new Callback() {
                        @Override
                        public void onSuccess(Object obj) {
                            String success = (String)obj;
                            SharedPreferences pref = getActivity().getSharedPreferences("login", MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putBoolean("flag", true)
                                    .apply();

                            String police_id = (String)obj;
                            UserDataAccess access = new UserDataAccess();
                            access.setUserId(police_id ,getActivity());

                            Toast.makeText(getContext(), "success"+success, Toast.LENGTH_SHORT).show();
                            Intent main_activity_intent = new Intent( getActivity(), MainActivity.class);
                            startActivity(main_activity_intent);

                        }

                        @Override
                        public void onErro(String errro) {
                            Toast.makeText(getContext(), "error "+errro, Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Email.setError("Please insert email");
                    Password.setError("Please insert Password");
                }
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.session_container, new Registration())
                        .commit();
            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.session_container, new Forgot_Password())
                        .addToBackStack(null)
                        .commit();
            }
        });

      return  view;
    }
}