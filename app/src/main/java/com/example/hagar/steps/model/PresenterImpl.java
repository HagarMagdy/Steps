package com.example.hagar.steps.model;

import android.text.TextUtils;
import android.util.Log;

import com.example.hagar.steps.presenter.LoginPresenter;
import com.example.hagar.steps.services.Api;
import com.example.hagar.steps.view.LoginView;
import com.squareup.otto.Produce;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hagar on 08/04/2018.
 */

public class PresenterImpl implements LoginPresenter {
    private static final String TAG = "PresenterImpl" ;
    private static final String SERVER_URL = "https://private-d3105-tamini.apiary-mock.com/Tamini/" ;
    LoginView loginView;

    public PresenterImpl(LoginView mLoginView) {
        this.loginView = mLoginView;
    }

    @Override
    public void ProsessLogin(String email, String password) {

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            loginView.loginValidations();
        } else {
            if (loginView.validEmail(email) == false) {
                loginView.loginValidations();
            } else {
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
                        loginView.loginSuccess();
                        Log.e(TAG, "Success ");
                    }

                    @Override
                    public void onFailure(Call<ResponsePojo> call, Throwable t) {
                        Log.e(TAG, "Failed");
                        loginView.loginError();
                    }
                });

            }

        }


    }


}
