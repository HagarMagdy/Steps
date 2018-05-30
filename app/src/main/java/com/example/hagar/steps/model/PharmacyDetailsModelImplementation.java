package com.example.hagar.steps.model;

import android.util.Log;

import com.example.hagar.steps.presenter.PharmacyDetailsPresenter;
import com.example.hagar.steps.services.Api;

import java.sql.Blob;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hagar on 29/05/2018.
 */

public class PharmacyDetailsModelImplementation implements PharmacyDetailsModelInterface {
    PharmacyDetailsPresenter presenter;

    private static final String SERVER_URL = "http://192.168.137.23:8585/MedicalInsuranceSystem/api/version1/details/";


    @Override
    public void retrieveDetails(int tid, int sid) {
        Log.i("KEY2", "Model/retrieveDetails");

        HttpLoggingInterceptor interceptor2 = new HttpLoggingInterceptor();
        interceptor2.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client2 = new OkHttpClient.Builder().addInterceptor(interceptor2).build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .client(client2)
                .build();

        Api service = retrofit.create(Api.class);
        Call<PharmacyDetails> call = service.getPharmacyDetails(tid, sid);
        System.out.println("tid ="+tid +"&& sid = "+sid);
        call.enqueue(new Callback<PharmacyDetails>() {
            @Override
            public void onResponse(Call<PharmacyDetails> call, Response<PharmacyDetails> response) {
                System.out.println("ay 7aga"+response.body().getNameEn());

                presenter.showDetails(response.body());

            }

            @Override
            public void onFailure(Call<PharmacyDetails> call, Throwable t) {
                System.out.println("onFailure");

            }
        });
    }
}
