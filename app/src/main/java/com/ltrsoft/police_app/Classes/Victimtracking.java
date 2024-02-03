package com.ltrsoft.police_app.Classes;

public class Victimtracking {

        String victim_history_id,victim_id,tracking_date,police_id,fir_id,operation,description,created_at,investigation_victim_id;

    public Victimtracking(String victim_history_id, String victim_id, String tracking_date, String police_id, String fir_id, String operation, String description, String created_at, String investigation_victim_id) {
        this.victim_history_id = victim_history_id;
        this.victim_id = victim_id;
        this.tracking_date = tracking_date;
        this.police_id = police_id;
        this.fir_id = fir_id;
        this.operation = operation;
        this.description = description;
        this.created_at = created_at;
        this.investigation_victim_id = investigation_victim_id;
    }

    public String getVictim_history_id() {
        return victim_history_id;
    }

    public void setVictim_history_id(String victim_history_id) {
        this.victim_history_id = victim_history_id;
    }

    public String getVictim_id() {
        return victim_id;
    }

    public void setVictim_id(String victim_id) {
        this.victim_id = victim_id;
    }

    public String getTracking_date() {
        return tracking_date;
    }

    public void setTracking_date(String tracking_date) {
        this.tracking_date = tracking_date;
    }

    public String getPolice_id() {
        return police_id;
    }

    public void setPolice_id(String police_id) {
        this.police_id = police_id;
    }

    public String getFir_id() {
        return fir_id;
    }

    public void setFir_id(String fir_id) {
        this.fir_id = fir_id;
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

    public String getInvestigation_victim_id() {
        return investigation_victim_id;
    }

    public void setInvestigation_victim_id(String investigation_victim_id) {
        this.investigation_victim_id = investigation_victim_id;
    }
}
