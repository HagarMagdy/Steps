package com.example.hagar.steps.model;

/**
 * Created by Hagar on 13/04/2018.
 */

public interface modelInterface {

    void ProsessLogin(String userName, String password, OnLoginFinishedListener listener);

    interface OnLoginFinishedListener {

        void showLoginErr();

        void errValidateEmail();

        boolean validEmmailInsidePres(String email);

        void onSuccess();
    }


}
