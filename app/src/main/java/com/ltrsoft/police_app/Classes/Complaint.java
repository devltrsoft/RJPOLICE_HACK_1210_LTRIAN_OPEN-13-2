package com.ltrsoft.police_app.Classes;

public class Complaint {
    String complain_type_name, station_name, complain_subject, complaint_location, complain_contact_no,
            incident_date, complain_Against, complain_description,
            State, Country, City, District;

    int complain_id, user_id, status_id;

    public Complaint(String complain_type_name, String station_name, String complain_subject,
                     String complaint_location, String complain_contact_no, String incident_date,
                     String complain_Against, String complain_description,
                     String state, String country, String city, String district, int complain_id,
                     int user_id, int status_id) {
        this.complain_type_name = complain_type_name;
        this.station_name = station_name;
        this.complain_subject = complain_subject;
        this.complaint_location = complaint_location;
        this.complain_contact_no = complain_contact_no;
        this.incident_date = incident_date;
        this.complain_Against = complain_Against;
        this.complain_description = complain_description;
        State = state;
        Country = country;
        City = city;
        District = district;
        this.complain_id = complain_id;
        this.user_id = user_id;
        this.status_id = status_id;
    }

    public Complaint(String complaint_location, String complain_contact_no,
                     String incident_date, String complain_Against, String complain_description) {
        this.station_name = station_name;
        this.complaint_location = complaint_location;
        this.complain_contact_no = complain_contact_no;
        this.incident_date = incident_date;
        this.complain_Against = complain_Against;
        this.complain_description = complain_description;
    }

    public String getComplain_type_name() {
        return complain_type_name;
    }

    public void setComplain_type_name(String complain_type_name) {
        this.complain_type_name = complain_type_name;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getComplain_subject() {
        return complain_subject;
    }

    public void setComplain_subject(String complain_subject) {
        this.complain_subject = complain_subject;
    }

    public String getComplaint_location() {
        return complaint_location;
    }

    public void setComplaint_location(String complaint_location) {
        this.complaint_location = complaint_location;
    }

    public String getComplain_contact_no() {
        return complain_contact_no;
    }

    public void setComplain_contact_no(String complain_contact_no) {
        this.complain_contact_no = complain_contact_no;
    }

    public String getIncident_date() {
        return incident_date;
    }

    public void setIncident_date(String incident_date) {
        this.incident_date = incident_date;
    }

    public String getComplain_Against() {
        return complain_Against;
    }

    public void setComplain_Against(String complain_Against) {
        this.complain_Against = complain_Against;
    }

    public String getComplain_description() {
        return complain_description;
    }

    public void setComplain_description(String complain_description) {
        this.complain_description = complain_description;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getComplain_id() {
        return complain_id;
    }

    public void setComplain_id(int complain_id) {
        this.complain_id = complain_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }
}
