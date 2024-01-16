package com.ltrsoft.police_app.Classes;

public class Camera_photo_uploading {
    int camera_uploading_id;
    String Station_name,user_name,photo_path,discription,address;

    public Camera_photo_uploading(int camera_uploading_id, String station_name, String user_name, String photo_path, String discription, String address) {
        this.camera_uploading_id = camera_uploading_id;
        Station_name = station_name;
        this.user_name = user_name;
        this.photo_path = photo_path;
        this.discription = discription;
        this.address = address;
    }

    public int getCamera_uploading_id() {
        return camera_uploading_id;
    }

    public void setCamera_uploading_id(int camera_uploading_id) {
        this.camera_uploading_id = camera_uploading_id;
    }

    public String getStation_name() {
        return Station_name;
    }

    public void setStation_name(String station_name) {
        Station_name = station_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
