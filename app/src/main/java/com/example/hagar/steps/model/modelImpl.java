package com.example.hagar.steps.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import com.example.hagar.steps.services.Api;

import java.sql.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by Hagar on 13/04/2018.
 */

public class modelImpl implements modelInterface {


    private static final String SERVER_URL = "http://192.168.137.23:8585/MedicalInsuranceSystem/api/version1/user/";

    @Override
    public void ProsessLogin(final String email, final String password, final OnLoginFinishedListener listener,final Context context) {

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Log.i("KEY", "model/impl empty field");

            listener.showLoginErr();
        } else {
            if (listener.validEmmailInsidePres(email) == false) {
                listener.errValidateEmail();
                Log.i("KEY", "model/impl validation");
            } else {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(SERVER_URL)
                        .client(client)
                        .build();
                Api service = retrofit.create(Api.class);

                RequestPojo r = new RequestPojo(email, password);
                Call<ResponsePojo> call = service.getUser(r);
                call.enqueue(new Callback<ResponsePojo>() {
                    @Override
                    public void onResponse(Call<ResponsePojo> call, Response<ResponsePojo> response) {
                   //     listener.onSuccess();
                        String userNameData = email;
                        String passwordData = password;
                        SharedPreferences sharedPreferences = context.getSharedPreferences("myPref",MODE_PRIVATE);
                       SharedPreferences.Editor edit = sharedPreferences.edit();
                       edit.putString("username",userNameData);
                        edit.putString("password",passwordData);
                        edit.commit();
                        listener.sendIdToMain(response.body().getId());
                        Log.i("KEYSH", "" + response.body().getId());
                    }

                    @Override
                    public void onFailure(Call<ResponsePojo> call, Throwable t) {
                         listener.showLoginErr();

                        Log.i("KEY", t.getMessage());

                    }
                });

            }
        }
    }
}




