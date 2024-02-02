package com.ltrsoft.police_app.Classes;

public class Police {
    static String batch_number;
    static String station_name;
    static String authority;
    static String fname;
    static String mname;
    static  String lname;
    static  String address;
    static String photo_path;
    static String country;
    static String state;
    static String district;
    static String city;
    static String email;
    static String password;
    static String gender;
    static String dob;
    static String mobile1;
    static String mobile2;
    static String adhar;
    static String police_lattitude;
    static String police_langitude;
    static String police_fcm_token;
    static String position_name;
    static String pan;
    static String police_id;

    public Police(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Police(String batch_number, String station_name, String authority, String fname, String mname,
                  String lname, String address, String photo_path, String country, String state, String district,
                  String city, String email, String password, String gender, String dob, String mobile1, String mobile2,
                  String adhar, String police_lattitude,
                  String police_langitude, String police_fcm_token, String position_name, String pan, String police_id) {
        this.batch_number = batch_number;
        this.station_name = station_name;
        this.authority = authority;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.address = address;
        this.photo_path = photo_path;
        this.country = country;
        this.state = state;
        this.district = district;
        this.city = city;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.adhar = adhar;
        this.police_lattitude = police_lattitude;
        this.police_langitude = police_langitude;
        this.police_fcm_token = police_fcm_token;
        this.position_name = position_name;
        this.pan = pan;
        this.police_id = police_id;
    }

    public Police(String fname, String email, String password, String mobile1) {
        this.fname = fname;
        this.email = email;
        this.password = password;
        this.mobile1 = mobile1;
    }

    public Police(String batchNumber, String stationId, String policeFname, String policeMname, String policeLname, String policeEmail, String policeGender, String policeDob, String policeMobile1, String policeMobile2, String policeAddress, String cityName, String districtName, String stateName, String positionName, String policeAdhar, Integer policeId) {
    }

    public Police(String policeId) {
        this.police_id = policeId;
    }

    public static String getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }

    public static String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public static String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public static String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public static String getLname() {
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

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public static String getAdhar() {
        return adhar;
    }

    public void setAdhar(String adhar) {
        this.adhar = adhar;
    }

    public String getPolice_lattitude() {
        return police_lattitude;
    }

    public void setPolice_lattitude(String police_lattitude) {
        this.police_lattitude = police_lattitude;
    }

    public String getPolice_langitude() {
        return police_langitude;
    }

    public void setPolice_langitude(String police_langitude) {
        this.police_langitude = police_langitude;
    }

    public String getPolice_fcm_token() {
        return police_fcm_token;
    }

    public void setPolice_fcm_token(String police_fcm_token) {
        this.police_fcm_token = police_fcm_token;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String setPolice_id() {
        return  police_id;
    }

    public void setPolice_id(String police_id) {
        this.police_id = police_id;
    }


}
