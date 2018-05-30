package com.example.hagar.steps.model;

import android.content.Context;

/**
 * Created by Hagar on 13/04/2018.
 */

public interface modelInterface {

    void ProsessLogin(String userName, String password, OnLoginFinishedListener listener,Context context);

    interface OnLoginFinishedListener {

        void showLoginErr();

        void errValidateEmail();

        boolean validEmmailInsidePres(String email);

        void onSuccess();

        void sendIdToMain(int id);
    }


}
