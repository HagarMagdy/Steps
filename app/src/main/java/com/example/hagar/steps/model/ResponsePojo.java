package com.example.hagar.steps.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Hagar on 09/04/2018.
 */

public class ResponsePojo implements Serializable {


    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("error")
    private int error;


    public ResponsePojo(String status, String message, int error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getError() {
        return error;
    }
}
