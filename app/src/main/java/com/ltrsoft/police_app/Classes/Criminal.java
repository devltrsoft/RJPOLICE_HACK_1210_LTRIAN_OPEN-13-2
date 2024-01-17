package com.ltrsoft.police_app.Classes;

import android.widget.EditText;

public class Criminal {
       String fname,mname,lname,address,  dob,email,adhar, gender,city,
               district,state,country,  photo_path,pan,mobile,is_criminal,punishment,duration,punishment_date;
    int criminal_id,criminal_complaint_id;
       String fir_id;


    public Criminal(String fname, String mname, String lname, String address, String dob, String email, String adhar, String gender, String city, String district, String state, String country, String photo_path, String pan, String mobile, String is_criminal, String punishment,
                    String duration, String punishment_date, int criminal_id, int criminal_complaint_id, String fir_id) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.adhar = adhar;
        this.gender = gender;
        this.city = city;
        this.district = district;
        this.state = state;
        this.country = country;
        this.photo_path = photo_path;
        this.pan = pan;
        this.mobile = mobile;
        this.is_criminal = is_criminal;
        this.punishment = punishment;
        this.duration = duration;
        this.punishment_date = punishment_date;
        this.criminal_id = criminal_id;
        this.criminal_complaint_id = criminal_complaint_id;
        this.fir_id = fir_id;
    }


    public Criminal(String fname, String address, String dob, String email, String adhar, String photo_path, String mobile,String fir_id,String gender) {
        this.fname = fname;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.adhar = adhar;
        this.photo_path = photo_path;
        this.mobile = mobile;
        this.fir_id= fir_id;
        this.gender=gender;
    }

    public Criminal(String cname, String caddress, String ccontatct, String cdob, String cemail, String cadharc, String encodeImage, String gender1, int caseId) {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdhar() {
        return adhar;
    }

    public void setAdhar(String adhar) {
        this.adhar = adhar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIs_criminal() {
        return is_criminal;
    }

    public void setIs_criminal(String is_criminal) {
        this.is_criminal = is_criminal;
    }

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPunishment_date() {
        return punishment_date;
    }

    public void setPunishment_date(String punishment_date) {
        this.punishment_date = punishment_date;
    }

    public int getCriminal_id() {
        return criminal_id;
    }

    public void setCriminal_id(int criminal_id) {
        this.criminal_id = criminal_id;
    }

    public int getCriminal_complaint_id() {
        return criminal_complaint_id;
    }

    public void setCriminal_complaint_id(int criminal_complaint_id) {
        this.criminal_complaint_id = criminal_complaint_id;
    }

    public String getFir_id() {
        return fir_id;
    }

    public void setFir_id(String fir_id) {
        this.fir_id = fir_id;
    }
}
