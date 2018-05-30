package com.example.hagar.steps.view;

/**
 * Created by Hagar on 08/04/2018.
 */

public interface LoginView {


    void loginSuccess();

    void loginError();

    boolean validEmmail(String email);

    boolean checkConnection();

    void navigateToHomeScreen(int id);
}
