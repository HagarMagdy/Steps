package com.example.hagar.steps.view;

/**
 * Created by Hagar on 08/04/2018.
 */

public interface LoginView {
    void loginValidations();

    void loginSuccess();

    void loginError();

    boolean validEmail(String email);
}
