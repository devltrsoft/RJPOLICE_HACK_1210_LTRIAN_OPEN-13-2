package com.ltrsoft.police_app.Classes;

public class WitnessTracking {
    String witness_history_id;
    String witness_id;
    String police_id;
    String tracking_date;
    String operation;
    String description;
    String created_at;
    public WitnessTracking(String witness_history_id, String witness_id, String police_id, String tracking_date, String operation, String description, String created_at) {
        this.witness_history_id = witness_history_id;
        this.witness_id = witness_id;
        this.police_id = police_id;
        this.tracking_date = tracking_date;
        this.operation = operation;
        this.description = description;
        this.created_at = created_at;
    }

    public String getWitness_history_id() {
        return witness_history_id;
    }

    public void setWitness_history_id(String witness_history_id) {
        this.witness_history_id = witness_history_id;
    }

    public String getWitness_id() {
        return witness_id;
    }

    public void setWitness_id(String witness_id) {
        this.witness_id = witness_id;
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
