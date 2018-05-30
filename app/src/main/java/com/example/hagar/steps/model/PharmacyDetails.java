package com.example.hagar.steps.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;

/**
 * Created by Hagar on 29/05/2018.
 */

public class PharmacyDetails implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("nameEn")
    private String nameEn;
    @SerializedName("latitude")
    private Double latitude;
    @SerializedName("longitude")
    private Double longitude;
    @SerializedName("startDate")
    private String startDate;
    @SerializedName("endDate")
    private String endDate;
    @SerializedName("rate")
    private float rate;
    @SerializedName("address")
    private String address;
    @SerializedName("openHour")
    private String openHour;
    @SerializedName("closeHour")
    private String closeHour;
    @SerializedName("nameAr")
    private String nameAr;
    @SerializedName("medicalTypeId")
    private int medicalTypeId;
    @SerializedName("pharmacyPhones")
    private ArrayList<String> pharmacyPhones;
    @SerializedName("image")
    private Blob image;

    public int getId() {
        return id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public float getRate() {
        return rate;
    }

    public String getAddress() {
        return address;
    }

    public String getOpenHour() {
        return openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public String getNameAr() {
        return nameAr;
    }

    public int getMedicalTypeId() {
        return medicalTypeId;
    }

    public ArrayList<String> getPharmacyPhones() {
        return pharmacyPhones;
    }

    public Blob getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public void setCloseHour(String closeHour) {
        this.closeHour = closeHour;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public void setMedicalTypeId(int medicalTypeId) {
        this.medicalTypeId = medicalTypeId;
    }

    public void setPharmacyPhones(ArrayList<String> pharmacyPhones) {
        this.pharmacyPhones = pharmacyPhones;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
