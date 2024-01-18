package com.ltrsoft.police_app.Classes;

public class NotAllotedCaseClass {
    String complainid,crimetype;

    public NotAllotedCaseClass(String complainid, String crimetype) {
        this.complainid = complainid;
        this.crimetype = crimetype;
    }

    public String getComplainid() {
        return complainid;
    }

    public void setComplainid(String complainid) {
        this.complainid = complainid;
    }

    public String getCrimetype() {
        return crimetype;
    }

    public void setCrimetype(String crimetype) {
        this.crimetype = crimetype;
    }
}
