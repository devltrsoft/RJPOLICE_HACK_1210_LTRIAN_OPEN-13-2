package com.ltrsoft.police_app.Classes;

public class Feedback {
    int police_feedback_id,police_id;
     Float overallsatisfication,usability_navigation,training_support,alert_notification,security_privacy,
    relavance_info,avarage_prating;

    public Feedback(int police_feedback_id, int police_id, Float overallsatisfication, Float usability_navigation, Float training_support,
                    Float alert_notification, Float security_privacy, Float relavance_info, Float avarage_prating) {
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

    public Feedback(Float overallsatisfication, Float usability_navigation, Float training_support,
                    Float alert_notification, Float security_privacy,Float relavance_info,Float avarage_prating) {
        this.overallsatisfication = overallsatisfication;
        this.usability_navigation = usability_navigation;
        this.training_support = training_support;
        this.alert_notification = alert_notification;
        this.security_privacy = security_privacy;
        this.relavance_info=relavance_info;
        this.avarage_prating=avarage_prating;
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

    public Float getOverallsatisfication() {
        return overallsatisfication;
    }

    public void setOverallsatisfication(Float overallsatisfication) {
        this.overallsatisfication = overallsatisfication;
    }

    public Float getUsability_navigation() {
        return usability_navigation;
    }

    public void setUsability_navigation(Float usability_navigation) {
        this.usability_navigation = usability_navigation;
    }

    public Float getTraining_support() {
        return training_support;
    }

    public void setTraining_support(Float training_support) {
        this.training_support = training_support;
    }

    public Float getAlert_notification() {
        return alert_notification;
    }

    public void setAlert_notification(Float alert_notification) {
        this.alert_notification = alert_notification;
    }

    public Float getSecurity_privacy() {
        return security_privacy;
    }

    public void setSecurity_privacy(Float security_privacy) {
        this.security_privacy = security_privacy;
    }

    public Float getRelavance_info() {
        return relavance_info;
    }

    public void setRelavance_info(Float relavance_info) {
        this.relavance_info = relavance_info;
    }

    public Float getAvarage_prating() {
        return avarage_prating;
    }

    public void setAvarage_prating(Float avarage_prating) {
        this.avarage_prating = avarage_prating;
    }
}
