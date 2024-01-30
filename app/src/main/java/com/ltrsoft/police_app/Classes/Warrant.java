package com.ltrsoft.police_app.Classes;

public class Warrant {

     String warrant_id,fir_id;
    String warrant_type,warrant_against,date_issued,discription,action,court_name,issuing_athority;

    public Warrant(String warrant_id, String fir_id, String warrant_type, String warrant_against,
                   String date_issued, String discription, String action, String court_name, String issuing_athority) {
        this.warrant_id = warrant_id;
        this.fir_id = fir_id;
        this.warrant_type = warrant_type;
        this.warrant_against = warrant_against;
        this.date_issued = date_issued;
        this.discription = discription;
        this.action = action;
        this.court_name = court_name;
        this.issuing_athority = issuing_athority;
    }

    public Warrant(String warrantTypeId, String cases, String fname1, String idate, String judic, String auth, String desc, String courtName1) {
         this.fir_id = cases;
        this.warrant_type = warrantTypeId;
        this.warrant_against = fname1;
        this.date_issued = idate;
        this.discription = desc;
        this.action = judic;
        this.court_name = courtName1;
        this.issuing_athority = auth;
    }

    public String getWarrant_id() {
        return warrant_id;
    }

    public void setWarrant_id(String warrant_id) {
        this.warrant_id = warrant_id;
    }

    public String getFir_id() {
        return fir_id;
    }

    public void setFir_id(String fir_id) {
        this.fir_id = fir_id;
    }

    public String getWarrant_type() {
        return warrant_type;
    }

    public void setWarrant_type(String warrant_type) {
        this.warrant_type = warrant_type;
    }

    public String getWarrant_against() {
        return warrant_against;
    }

    public void setWarrant_against(String warrant_against) {
        this.warrant_against = warrant_against;
    }

    public String getDate_issued() {
        return date_issued;
    }

    public void setDate_issued(String date_issued) {
        this.date_issued = date_issued;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCourt_name() {
        return court_name;
    }

    public void setCourt_name(String court_name) {
        this.court_name = court_name;
    }

    public String getIssuing_athority() {
        return issuing_athority;
    }

    public void setIssuing_athority(String issuing_athority) {
        this.issuing_athority = issuing_athority;
    }
}
