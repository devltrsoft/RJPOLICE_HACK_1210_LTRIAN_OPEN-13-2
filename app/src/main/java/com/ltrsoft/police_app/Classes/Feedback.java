package com.ltrsoft.police_app.Classes;

public class Feedback {
    int police_feedback_id,police_id;
    String overallsatisfication,usability_navigation,training_support,alert_notification,security_privacy,
    relavance_info,avarage_prating;

    public Feedback(int police_feedback_id, int police_id, String overallsatisfication, String usability_navigation, String training_support,
                    String alert_notification, String security_privacy, String relavance_info, String avarage_prating) {
        this.police_feedback_id = police_feedback_id;
        this.police_id = police_id;
        this.overallsatisfication = overallsatisfication;
        this.usability_navigation = usability_navigation;
        this.training_support = training_support;
        this.alert_notification = alert_notification;
        this.security_privacy = security_privacy;
        this.relavance_info = relavance_info;
        this.avarage_prating = avarage_prating;
    }

    public int getPolice_feedback_id() {
        return police_feedback_id;
    }

    public void setPolice_feedback_id(int police_feedback_id) {
        this.police_feedback_id = police_feedback_id;
    }

    public int getPolice_id() {
        return police_id;
    }

    public void setPolice_id(int police_id) {
        this.police_id = police_id;
    }

    public String getOverallsatisfication() {
        return overallsatisfication;
    }

    public void setOverallsatisfication(String overallsatisfication) {
        this.overallsatisfication = overallsatisfication;
    }

    public String getUsability_navigation() {
        return usability_navigation;
    }

    public void setUsability_navigation(String usability_navigation) {
        this.usability_navigation = usability_navigation;
    }

    public String getTraining_support() {
        return training_support;
    }

    public void setTraining_support(String training_support) {
        this.training_support = training_support;
    }

    public String getAlert_notification() {
        return alert_notification;
    }

    public void setAlert_notification(String alert_notification) {
        this.alert_notification = alert_notification;
    }

    public String getSecurity_privacy() {
        return security_privacy;
    }

    public void setSecurity_privacy(String security_privacy) {
        this.security_privacy = security_privacy;
    }

    public String getRelavance_info() {
        return relavance_info;
    }

    public void setRelavance_info(String relavance_info) {
        this.relavance_info = relavance_info;
    }

    public String getAvarage_prating() {
        return avarage_prating;
    }

    public void setAvarage_prating(String avarage_prating) {
        this.avarage_prating = avarage_prating;
    }
}
