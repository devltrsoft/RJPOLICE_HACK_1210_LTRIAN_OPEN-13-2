package com.ltrsoft.police_app.Classes;

public class Victim {
    String country,state,district,city,fname,mname,lname,address, dob,
            email,adhar, gender,
            photo_path,pan,mobile,is_victim;
     String  fir_id,investigation_victim_id;

    public Victim(String country, String state, String district, String city, String fname, String mname, String lname,
                  String address, String dob, String email,
                  String adhar, String gender, String photo_path, String pan, String mobile,
                  String is_victim, String fir_id, String investigation_victim_id) {
        this.country = country;
        this.state = state;
        this.district = district;
        this.city = city;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.adhar = adhar;
        this.gender = gender;
        this.photo_path = photo_path;
        this.pan = pan;
        this.mobile = mobile;
        this.is_victim = is_victim;
        this.fir_id = fir_id;
        this.investigation_victim_id = investigation_victim_id;
    }

    public Victim(String country1, String state1, String district1, String city1, String name1, String address1,
                  String email1, String dob1, String mobile1, String addhar1, String gender,String photo_path) {
        this.country = country1;
        this.state = state1;
        this.district = district1;
        this.city = city1;
        this.fname = name1;
         this.address = address1;
        this.dob = dob1;
        this.email = email1;
        this.adhar = addhar1;
        this.gender = gender;
         this.mobile = mobile1;
          this.photo_path=photo_path;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getIs_victim() {
        return is_victim;
    }

    public void setIs_victim(String is_victim) {
        this.is_victim = is_victim;
    }

    public String getFir_id() {
        return fir_id;
    }

    public void setFir_id(String fir_id) {
        this.fir_id = fir_id;
    }

    public String getInvestigation_victim_id() {
        return investigation_victim_id;
    }

    public void setInvestigation_victim_id(String investigation_victim_id) {
        this.investigation_victim_id = investigation_victim_id;
    }
}
