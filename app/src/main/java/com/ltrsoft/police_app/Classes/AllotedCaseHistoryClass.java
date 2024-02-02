package com.ltrsoft.police_app.Classes;

public class AllotedCaseHistoryClass {

    String id;
    String name;
    String address;
    String complaint_type;

    public AllotedCaseHistoryClass(String id, String name, String  address, String complaint_type) {
        this.id = id;
        this.name = name;
        this.address=address;
         this.complaint_type = complaint_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplaint_type() {
        return complaint_type;
    }

    public void setComplaint_type(String complaint_type) {
        this.complaint_type = complaint_type;
    }
}
