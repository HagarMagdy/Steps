package com.example.hagar.steps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Hagar on 09/04/2018.
 */

public class RequestPojo implements Serializable{

    @SerializedName("mail")
    private String mail;

    @SerializedName("password")
    private String password;

    public RequestPojo(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    //    @SerializedName("locationAddress")
//    private String locationAddress;
//
//    @SerializedName("suggestLocationLongitude")
//    private double suggestLocationLongitude;
//
//    @SerializedName("suggestLocationLatitude")
//    private double suggestLocationLatitude;
//
//    @SerializedName("suggestDate")
//    private String suggestDate;
//
//
//    @SerializedName("medicalServiceNameAr")
//    @Expose
//    private String medicalServiceNameAr;
//
//    @SerializedName("medicalServiceNameEn")
//    @Expose
//    private String medicalServiceNameEn;
//
//    @SerializedName("suggestSupervisor")
//    @Expose
//    private String suggestSupervisor;
//
//    @SerializedName("employeeEmployeeId")
//    @Expose
//    private int employeeEmployeeId;
//
//
//    @SerializedName("suggestMedicalType")
//    @Expose
//    private int suggestMedicalType;
//
//    @SerializedName("suggestContactPhone")
//    @Expose
//    private String suggestContactPhone;

}
