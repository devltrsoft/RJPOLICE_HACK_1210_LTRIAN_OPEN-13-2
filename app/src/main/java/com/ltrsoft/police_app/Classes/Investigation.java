package com.ltrsoft.police_app.Classes;

public class Investigation {

    int investigation_id,fir_id,complaint_id;
    String start_date,end_date,location,incedent_reporting,evidance_property,investigation_description;

    public Investigation(int investigation_id, int fir_id, int complaint_id, String start_date, String end_date,
                         String location, String incedent_reporting, String evidance_property, String investigation_description) {
        this.investigation_id = investigation_id;
        this.fir_id = fir_id;
        this.complaint_id = complaint_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.location = location;
        this.incedent_reporting = incedent_reporting;
        this.evidance_property = evidance_property;
        this.investigation_description = investigation_description;
    }

    public int getInvestigation_id() {
        return investigation_id;
    }

    public void setInvestigation_id(int investigation_id) {
        this.investigation_id = investigation_id;
    }

    public int getFir_id() {
        return fir_id;
    }

    public void setFir_id(int fir_id) {
        this.fir_id = fir_id;
    }

    public int getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(int complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIncedent_reporting() {
        return incedent_reporting;
    }

    public void setIncedent_reporting(String incedent_reporting) {
        this.incedent_reporting = incedent_reporting;
    }

    public String getEvidance_property() {
        return evidance_property;
    }

    public void setEvidance_property(String evidance_property) {
        this.evidance_property = evidance_property;
    }

    public String getInvestigation_description() {
        return investigation_description;
    }

    public void setInvestigation_description(String investigation_description) {
        this.investigation_description = investigation_description;
    }
}
