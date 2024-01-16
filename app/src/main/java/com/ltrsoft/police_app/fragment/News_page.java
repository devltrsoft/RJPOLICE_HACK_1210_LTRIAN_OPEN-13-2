package com.ltrsoft.police_app.fragment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ltrsoft.police_app.Classes.News;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Add_News_Page;

import java.util.ArrayList;

public class News_page extends Fragment {

    private FloatingActionButton floating;

    private RecyclerView recyclerView;
    ArrayList<News> list = new ArrayList<>();
    private final static String NEWS_READ_URL = "https://rj.ltr-soft.com/public/police_api/news/select_news.php";


    public News_page() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view= inflater.inflate(R.layout.news_page, container, false);
        floating=view.findViewById(R.id.floating);
        recyclerView = view.findViewById(R.id.recycler_news);
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("News  Page");
        }
        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.container_main, new Add_News_Page());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        if (list != null) {
            list.clear();
        }

    return view;
    }
}