package com.ltrsoft.police_app.Classes;

public class Training_video {
    int video_id,station_id;
    String video_path,video_subject,video_description;

    public Training_video(int video_id, int station_id, String video_path, String video_subject, String video_description) {
        this.video_id = video_id;
        this.station_id = station_id;
        this.video_path = video_path;
        this.video_subject = video_subject;
        this.video_description = video_description;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    public String getVideo_subject() {
        return video_subject;
    }

    public void setVideo_subject(String video_subject) {
        this.video_subject = video_subject;
    }

    public String getVideo_description() {
        return video_description;
    }

    public void setVideo_description(String video_description) {
        this.video_description = video_description;
    }
}
