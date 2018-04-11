package com.example.hagar.steps.services;

import com.example.hagar.steps.model.RequestPojo;
import com.example.hagar.steps.model.ResponsePojo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Hagar on 09/04/2018.
 */

public interface Api {

    String URL = "https://private-d3105-tamini.apiary-mock.com/Tamini/" ;


    @POST("login")
    Call<ResponsePojo> getUser(@Body RequestPojo user);

}
