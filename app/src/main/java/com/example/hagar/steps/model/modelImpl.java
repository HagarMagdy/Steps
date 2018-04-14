package com.example.hagar.steps.model;

import android.text.TextUtils;
import android.util.Log;

import com.example.hagar.steps.services.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by Hagar on 13/04/2018.
 */

public class modelImpl implements modelInterface {


    private static final String TAG = "PresenterImpl";
    private static final String SERVER_URL = "https://private-d3105-tamini.apiary-mock.com/Tamini/";

    @Override
    public void ProsessLogin(String email, String password, final OnLoginFinishedListener listener) {

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Log.i("KEY","model/impl empty field");

            listener.showLoginErr();
        } else {
            if (listener.validEmmailInsidePres(email) == false) {
                listener.errValidateEmail();
                Log.i("KEY","model/impl validation");
            }

            else {
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(SERVER_URL)
                        .build();
                Api service = retrofit.create(Api.class);
                RequestPojo r = new RequestPojo(email, password);
                Call<ResponsePojo> call = service.getUser(r);
                call.enqueue(new Callback<ResponsePojo>() {
                    @Override
                    public void onResponse(Call<ResponsePojo> call, Response<ResponsePojo> response) {
                        listener.onSuccess();
                        Log.i("KEY","inside onResponse");
                    }
                    @Override
                    public void onFailure(Call<ResponsePojo> call, Throwable t) {
                        listener.showLoginErr();

                        Log.i("KEY","inside onFailure");

                    }
                });

            }


        }

    }
}

