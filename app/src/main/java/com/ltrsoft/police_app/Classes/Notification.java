package com.ltrsoft.police_app.Classes;

public class Notification {

    int notification_id,notification_photo_id,police_id,user_id;
    String station_name,notification_title,notification_description,notification_type,notification_photo_path;

    public Notification(int notification_id, int notification_photo_id, int police_id, int user_id,
                        String station_name, String notification_title,
                        String notification_description, String notification_type, String notification_photo_path) {
        this.notification_id = notification_id;
        this.notification_photo_id = notification_photo_id;
        this.police_id = police_id;
        this.user_id = user_id;
        this.station_name = station_name;
        this.notification_title = notification_title;
        this.notification_description = notification_description;
        this.notification_type = notification_type;
        this.notification_photo_path = notification_photo_path;
    }

    public Notification(Integer notificationId, Integer notificationStationId, Integer notificationPhotoId, String notificationDescription, String notificationType, String notificationPhotoPath) {
    }

    public int getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(int notification_id) {
        this.notification_id = notification_id;
    }

    public int getNotification_photo_id() {
        return notification_photo_id;
    }

    public void setNotification_photo_id(int notification_photo_id) {
        this.notification_photo_id = notification_photo_id;
    }

    public int getPolice_id() {
        return police_id;
    }

    public void setPolice_id(int police_id) {
        this.police_id = police_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getNotification_title() {
        return notification_title;
    }

    public void setNotification_title(String notification_title) {
        this.notification_title = notification_title;
    }

    public String getNotification_description() {
        return notification_description;
    }

    public void setNotification_description(String notification_description) {
        this.notification_description = notification_description;
    }

    public String getNotification_type() {
        return notification_type;
    }

    public void setNotification_type(String notification_type) {
        this.notification_type = notification_type;
    }

    public String getNotification_photo_path() {
        return notification_photo_path;
    }

    public void setNotification_photo_path(String notification_photo_path) {
        this.notification_photo_path = notification_photo_path;
    }
}
