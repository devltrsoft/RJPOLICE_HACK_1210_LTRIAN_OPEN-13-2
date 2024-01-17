package com.ltrsoft.police_app.Classes;

import java.util.ArrayList;

public class complain_history_class {
    String name, complaint_desc, complaint_id;

    public complain_history_class(String name, String complaint_desc, String complaint_id) {
        this.name = name;
        this.complaint_desc = complaint_desc;
        this.complaint_id = complaint_id;
    }

    public complain_history_class() {
    }

    public complain_history_class(ArrayList<complain_history_class> list) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComplaint_desc() {
        return complaint_desc;
    }

    public void setComplaint_desc(String complaint_desc) {
        this.complaint_desc = complaint_desc;
    }

    public String getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(String complaint_id) {
        this.complaint_id = complaint_id;
    }
}
