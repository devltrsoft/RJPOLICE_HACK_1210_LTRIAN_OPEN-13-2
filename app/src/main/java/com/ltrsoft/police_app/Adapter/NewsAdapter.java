package com.ltrsoft.police_app.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.police_app.Classes.News;
import com.ltrsoft.police_app.Model.NewsDeo;
import com.ltrsoft.police_app.R;
import com.ltrsoft.police_app.fragment.NewsViewFragment;
import com.ltrsoft.police_app.interface1.Callback;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    public ArrayList <News>list;
    boolean b=false;
    int likeCount=0;
    public NewsAdapter(ArrayList<News> list) {
        this.list = list;
    }
    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card,parent,false);
        context=parent.getContext();
        return new ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = list.get(position);
//       String imgurl ="https://institute.ltr-soft.com/company_details/"+news.getNews_photo_path();
//        Picasso.get().load(imgurl).into(holder.newsImg);
        holder.newsImg.setImageResource(R.drawable.news1);
        holder.title.setText(news.getNews_date());
        holder.newsDate.setText(news.getNews_description());

        holder.newsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                 NewsViewFragment n = new NewsViewFragment();
                Bundle b = new Bundle();

                // Assuming `newsImg.getNews_photo_path()` returns the image path as a String
                // Pass the image path instead of resource ID if you intend to load it using Glide or Picasso
                b.putString("news_img", news.getNews_photo_path());
                b.putString("news_description", news.getNews_description());
                b.putString("news_title", news.getNews_title());
                n.setArguments(b);

                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,n)
                        .addToBackStack(null)
                        .commit();
            }
        });
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String newsId  = news.getNews_id();
//                if (b) {
//                    likeCount++;
//                } else {
//
//                    likeCount--;
//                }


                Toast.makeText(context, ""+likeCount, Toast.LENGTH_SHORT).show();

                NewsDeo newsDeo=new NewsDeo();
//                newsDeo.sendLikeCountToServer(newsId, likeCount, view.getContext(), new Callback() {
//                    @Override
//                    public void onSuccess(Object obj) {
//
//                    }
//
//                    @Override
//                    public void onErro(String errro) {
//
//                    }
//                });
             }
        });




        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri imageUri = (Uri) view.getTag();
                Intent intent=new Intent();
                intent.setAction(intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Hello");
                intent.setType("text/plain");
                if (intent.resolveActivity(context.getPackageManager())!=null){
                }
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView newsImg,comment,like,share;
        public TextView title,newsDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImg = itemView.findViewById(R.id.newsimg);
            comment = itemView.findViewById(R.id.comment);
            like = itemView.findViewById(R.id.like);
            share = itemView.findViewById(R.id.share);
            title = itemView.findViewById(R.id.title);
            newsDate = itemView.findViewById(R.id.news_date);
        }
    }
}
