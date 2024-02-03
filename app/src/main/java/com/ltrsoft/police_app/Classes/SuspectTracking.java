package com.ltrsoft.police_app.Classes;

public class SuspectTracking {
    String suspect_history_id,suspect_id,police_id,tracking_date,operation,description,created_at;

    public SuspectTracking(String suspect_history_id, String suspect_id, String police_id, String tracking_date, String operation, String description, String created_at) {
        this.suspect_history_id = suspect_history_id;
        this.suspect_id = suspect_id;
        this.police_id = police_id;
        this.tracking_date = tracking_date;
        this.operation = operation;
        this.description = description;
        this.created_at = created_at;
    }

    public String getSuspect_history_id() {
        return suspect_history_id;
    }

    public void setSuspect_history_id(String suspect_history_id) {
        this.suspect_history_id = suspect_history_id;
    }

    public String getSuspect_id() {
        return suspect_id;
    }

    public void setSuspect_id(String suspect_id) {
        this.suspect_id = suspect_id;
    }

    public String getPolice_id() {
        return police_id;
    }

    public void setPolice_id(String police_id) {
        this.police_id = police_id;
    }

    public String getTracking_date() {
        return tracking_date;
    }

    public void setTracking_date(String tracking_date) {
        this.tracking_date = tracking_date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
