package com.example.hagar.steps.services;

import com.example.hagar.steps.model.PharmacyDetails;
import com.example.hagar.steps.model.RequestPojo;
import com.example.hagar.steps.model.ResponsePojo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Hagar on 09/04/2018.
 */

public interface Api {



    @POST("login")
    Call<ResponsePojo> getUser(@Body RequestPojo pojo);

    @GET("get")
    Call<PharmacyDetails> getPharmacyDetails (@Query("tid")int tid , @Query("sid")int sid);

}
