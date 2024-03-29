package com.ltrsoft.police_app.fragment;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ltrsoft.police_app.Adapter.NewsAdapter;
import com.ltrsoft.police_app.Classes.News;
import com.ltrsoft.police_app.Model.NewsDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.Add_News_Page;
import com.ltrsoft.police_app.interface1.Callback;

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
            actionBar.setTitle("     News");
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
        NewsDeo newsDeo=new NewsDeo();
        newsDeo.getNews(getContext(), new Callback() {
            @Override
            public void onSuccess(Object obj) {
//                 ArrayList success=(ArrayList) obj;
//                Toast.makeText(getContext(), "success="+success, Toast.LENGTH_SHORT).show();
                ArrayList<News> newslist=new ArrayList<>();
                newslist=(ArrayList<News>)obj;
                NewsAdapter adapter = new NewsAdapter(newslist);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onErro(String errro) {
                Toast.makeText(getContext(), "error ="
                        +errro, Toast.LENGTH_SHORT).show();

            }
        });
    return view;
    }
}