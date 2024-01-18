package com.ltrsoft.police_app.Classes;

public class AllotedCaseHistoryClass {

    String id,name,date;

    public AllotedCaseHistoryClass(String id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
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

    public String getDate() {
        return date;
    }


}
