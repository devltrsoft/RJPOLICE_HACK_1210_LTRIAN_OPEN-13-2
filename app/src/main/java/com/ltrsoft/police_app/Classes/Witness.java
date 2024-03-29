package com.ltrsoft.police_app.Classes;

import java.util.ArrayList;

public class Witness {

    String country,state,district,city,fname,mname,lname,address, dob,email,adhar,
            gender,
              photo_path,pan,mobile,is_witness;

        String investigation_witness_id,complaint_witness_id,complaint_id;
        String fir_id;

    public Witness(String country, String state, String district, String city, String fname, String mname, String lname, String address, String dob, String email, String adhar, String gender, String photo_path,
                   String pan, String mobile, String is_witness, String fir_id, String investigation_witness_id) {
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
        this.is_witness = is_witness;
        this.fir_id = fir_id;
        this.investigation_witness_id = investigation_witness_id;
    }

    public Witness(String name1, String address1, String country1,
                   String state1, String district1, String city1, String email1,
                   String dob1, String mobile1, String addhar1, String gender,String photo_path) {
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
        this.photo_path = photo_path;
    }

    public Witness(String harun, String pune, String number) {
    }

    public Witness(ArrayList<Witness> listwitness) {
    }

    public Witness(String complaintWitnessId, String complaintWitnessFname, String complaintWitnessMname,
                   String complaintWitnessLname, String complaintWitnessAddress, String cityName, String countryName,
                   String stateName, String districtName, String complaintWitnessDob, String complaintWitnessGender,
                   String complaintWitnessMobile, String complaintWitnessEmail, String complaintWitnessPhotoPath,
                   String complaintWitnessPan, String complaintWitnessAdhar, String complaint_id, String isWitness,String complaint_table)
    {
        this.country = countryName;
        this.state = stateName;
        this.district = districtName;
        this.city = cityName;
        this.fname = complaintWitnessFname;
        this.mname = complaintWitnessMname;
        this.lname = complaintWitnessLname;
        this.address = complaintWitnessAddress;
        this.dob = complaintWitnessDob;
        this.email = complaintWitnessEmail;
        this.adhar = complaintWitnessAdhar;
        this.gender = complaintWitnessGender;
        this.photo_path = complaintWitnessPhotoPath;
        this.pan = complaintWitnessPan;
        this.mobile = complaintWitnessMobile;
        this.complaint_witness_id = complaintWitnessId;
        this.complaint_id = complaint_id;
        this.is_witness = isWitness;
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

    public String getIs_witness() {
        return is_witness;
    }

    public void setIs_witness(String is_witness) {
        this.is_witness = is_witness;
    }

    public String getFir_id() {
        return fir_id;
    }

    public void setFir_id(String fir_id) {
        this.fir_id = fir_id;
    }

    public String getInvestigation_witness_id() {
        return investigation_witness_id;
    }

    public void setInvestigation_witness_id(String investigation_witness_id) {
        this.investigation_witness_id = investigation_witness_id;
    }
}
