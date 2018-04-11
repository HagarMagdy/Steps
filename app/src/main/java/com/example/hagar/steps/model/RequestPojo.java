package com.example.hagar.steps.model;

/**
 * Created by Hagar on 09/04/2018.
 */

public class RequestPojo {
    private String email;
    private String password;

    public RequestPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
