package com.example.hagar.steps.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.example.hagar.steps.model.RequestPojo;
import com.example.hagar.steps.model.ResponsePojo;
import com.example.hagar.steps.model.modelInterface;
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

public class PresenterImpl implements LoginPresenter, modelInterface.OnLoginFinishedListener {


    LoginView view;
    modelInterface model;

    public PresenterImpl(LoginView view, modelInterface model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void validatation(String userName, String password) {

        Log.i("KEY","PRES/validatation");
        model.ProsessLogin(userName, password, this);

    }


    @Override
    public void showLoginErr() {

        view.loginError();
        Log.i("KEY","inside pres/showLoginErr");

    }

    @Override
    public void errValidateEmail() {
        Log.i("KEY","inside pres/errValidateEmail");

        view.loginError();
    }

    @Override
    public boolean validEmmailInsidePres(String email)
    {
        Log.i("KEY","PRES / validEmmailInsidePres");
        view.validEmmail(email);
        return false;
    }


    @Override
    public void onSuccess() {
        view.loginSuccess();
    }
}
