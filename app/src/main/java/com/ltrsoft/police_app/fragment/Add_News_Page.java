package com.ltrsoft.police_app.fragment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.ltrsoft.police_app.Classes.News;
import com.ltrsoft.police_app.Model.NewsDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.interface1.Callback;

import java.util.ArrayList;

public class Add_News_Page extends Fragment {
    private static final String STATION_URL = "https://rj.ltr-soft.com/public/police_api/police_station/read_police_station.php";
    private RequestQueue requestQueue1;

    ArrayList<String> list,list_complain;
    private ArrayAdapter adapter,adapter2;
    public Add_News_Page() {
        // Required empty public constructor
    }
    private EditText Ntitle,Ncatagory,Nstation,Ndescription,Ndate;

    private Button save;

    public static String URL="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.add__news__page, container, false);

        Ntitle=view.findViewById(R.id.Ntitle);
        Ncatagory=view.findViewById(R.id.Ncatagory);
        Nstation=view.findViewById(R.id.Nstation);
        Ndescription=view.findViewById(R.id.Ndescription);
        Ndate=view.findViewById(R.id.Ndate);
        save=view.findViewById(R.id.save);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Add News ");
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String ntitle =  Ntitle.getText().toString().trim();
                final String ncatagory =  Ncatagory.getText().toString().trim();
                final String nstation =  Nstation.getText().toString().trim();
                final String ndescription =  Ndescription.getText().toString().trim();
                final String ndate =  Ndate.getText().toString().trim();
                Add_News_image addNewsImage=new Add_News_image();
                NewsDeo newsDeo=new NewsDeo();
                newsDeo.createnews(new News(ntitle, ncatagory, nstation, ndescription, ndate), getContext(),getActivity(), new Callback() {
                    @Override
                    public void onSuccess(Object obj) {
                        String success=(String) obj;
                      // Toast.makeText(getContext(), ""+success, Toast.LENGTH_SHORT).show();
                        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                        transaction.replace(R.id.container_main,addNewsImage);
                        transaction.commit();
                    }

                    @Override
                    public void onErro(String errro) {
                 Toast.makeText(getContext(), ""+errro, Toast.LENGTH_SHORT).show();

                    }

//                Bundle bundle=new Bundle();
//                bundle.putString("ntitle",ntitle);
//                bundle.putString("ncatagory",ncatagory);
//                bundle.putString("nstation",nstation);
//                bundle.putString("ndescription",ndescription);
//                bundle.putString("ndate",ndate);
//                addNewsImage.setArguments(bundle);
                        });

            }
        });

    return view;
    }
}