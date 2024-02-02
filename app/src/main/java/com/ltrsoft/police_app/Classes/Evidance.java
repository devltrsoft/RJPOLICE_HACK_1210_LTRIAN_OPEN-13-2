package com.ltrsoft.police_app.Classes;

public class Evidance {

    String evidance_id;
    String fir_id,evidance_name,discription,evidance_photos_path,evidance_photos_description,
            evidance_photos_id,ChangeDate,date;

//    public Evidance(String evidanceName, String evidanceDesc, String photoPath, String firId) {
//    }

    public Evidance(String evidanceId, String firId, String evidanceName, String evidanceDescription, String evidancePhotosPath, String evidancePhotosDescription, String evidancePhotosId, String evidencechangedate) {

        this.evidance_name = evidanceName;
        this.discription = evidanceDescription;
        this.evidance_photos_path = evidancePhotosPath;
        this.fir_id = firId;
        this.evidance_id=evidanceId;
    }

    public Evidance(String evidanceName, String evidanceDesc, String photoPath, String firId) {
  this.evidance_name=evidanceName;
  this.discription=evidanceDesc;
    }


    public String getChangeDate() {
        return ChangeDate;
    }

    public void setChangeDate(String changeDate) {
        ChangeDate = changeDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Evidance(String sampleEvidence, int evidence) {
    }

    public Evidance(String complaint_photo_id, String complaint_photo_path, String complaint_photo_description) {

        this.evidance_photos_id = complaint_photo_id;
        this.discription = complaint_photo_description;
        this.evidance_photos_path = complaint_photo_path;

    }

    public String getEvidance_id() {
        return evidance_id;
    }

    public void setEvidance_id(String evidance_id) {
        this.evidance_id = evidance_id;
    }

    public String getFir_id() {
        return fir_id;
    }

    public void setFir_id(String fir_id) {
        this.fir_id = fir_id;
    }

    public String getEvidance_name() {
        return evidance_name;
    }

    public void setEvidance_name(String evidance_name) {
        this.evidance_name = evidance_name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getEvidance_photos_path() {
        return evidance_photos_path;
    }

    public void setEvidance_photos_path(String evidance_photos_path) {
        this.evidance_photos_path = evidance_photos_path;
    }

    public String getEvidance_photos_description() {
        return evidance_photos_description;
    }

    public void setEvidance_photos_description(String evidance_photos_description) {
        this.evidance_photos_description = evidance_photos_description;
    }

    public String getEvidance_photos_id() {
        return evidance_photos_id;
    }

    public void setEvidance_photos_id(String evidance_photos_id) {
        this.evidance_photos_id = evidance_photos_id;
    }

    public Evidance(String evidance_id, String fir_id, String evidance_name, String discription,
                    String evidance_photos_path, String evidance_photos_description, String evidance_photos_id) {
        this.evidance_id = evidance_id;
        this.fir_id = fir_id;
        this.evidance_name = evidance_name;
        this.discription = discription;
        this.evidance_photos_path = evidance_photos_path;
        this.evidance_photos_description = evidance_photos_description;
        this.evidance_photos_id = evidance_photos_id;

    }
}
