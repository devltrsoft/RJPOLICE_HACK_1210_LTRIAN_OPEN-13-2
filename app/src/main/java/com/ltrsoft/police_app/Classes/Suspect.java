package com.ltrsoft.police_app.Classes;

public class Suspect {

    String country,state,district,city,fname,mname,lname,address,
             dob,email,adhar, gender,
            photo_path,pan,mobile,is_suspect;
       int  fir_id,investigation_suspect_id;

    public Suspect(String country, String state, String district, String city, String fname,
                   String mname, String lname, String address, String dob, String email, String adhar, String gender, String photo_path, String pan,
                   String mobile, String is_suspect, int fir_id, int investigation_suspect_id) {
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
        this.is_suspect = is_suspect;
        this.fir_id = fir_id;
        this.investigation_suspect_id = investigation_suspect_id;
    }

    public Suspect(String country1, String state1, String district1, String city1, String name1, String address1, String email1, String dob1, String mobile1, String addhar1, String gender) {
    }

    public Suspect(String number, String ganeshSagave, String latur) {
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

    public String getIs_suspect() {
        return is_suspect;
    }

    public void setIs_suspect(String is_suspect) {
        this.is_suspect = is_suspect;
    }

    public int getFir_id() {
        return fir_id;
    }

    public void setFir_id(int fir_id) {
        this.fir_id = fir_id;
    }

    public int getInvestigation_suspect_id() {
        return investigation_suspect_id;
    }

    public void setInvestigation_suspect_id(int investigation_suspect_id) {
        this.investigation_suspect_id = investigation_suspect_id;
    }
}
