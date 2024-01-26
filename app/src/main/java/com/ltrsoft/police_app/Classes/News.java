package com.ltrsoft.police_app.Classes;

public class News {

    String news_id,station_id,like,news_photo_id;

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getNews_photo_id() {
        return news_photo_id;
    }

    public void setNews_photo_id(String news_photo_id) {
        this.news_photo_id = news_photo_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_category() {
        return news_category;
    }

    public void setNews_category(String news_category) {
        this.news_category = news_category;
    }

    public String getNews_description() {
        return news_description;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public String getNews_photo_path() {
        return news_photo_path;
    }

    public void setNews_photo_path(String news_photo_path) {
        this.news_photo_path = news_photo_path;
    }

    String news_title,news_category,news_description,news_date,news_photo_path;

    public News(String news_id, String news_title, String news_description, String news_photo_path) {
        this.news_id = news_id;
        this.news_title = news_title;
        this.news_description = news_description;
        this.news_photo_path = news_photo_path;
    }
}
