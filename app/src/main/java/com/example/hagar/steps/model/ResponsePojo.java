package com.example.hagar.steps.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Hagar on 09/04/2018.
 */

public class ResponsePojo implements Serializable {


    @SerializedName("status")

    private Boolean status;

    @SerializedName("message")

    private String message;

    @SerializedName("error")
    private String error;

    @SerializedName("id")
    private int id;

    public ResponsePojo(Boolean status, String message, String error, int id) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setError(String error) {
        this.error = error;
    }
}
