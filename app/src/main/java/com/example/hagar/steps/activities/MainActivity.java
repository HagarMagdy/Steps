package com.example.hagar.steps.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hagar.steps.R;
import com.example.hagar.steps.model.PresenterImpl;
import com.example.hagar.steps.presenter.LoginPresenter;
import com.example.hagar.steps.view.LoginView;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginView {
    @BindView(R.id.edit_password)
    EditText pass;
    @BindView(R.id.edit_user_name)
    EditText uName;
    @BindView(R.id.login_btn)
    Button login;

    LoginPresenter loginPres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPres = new PresenterImpl(MainActivity.this);
    }

    @OnClick(R.id.login_btn)
    public void login(View view) {
        String userName = uName.getText().toString();
        String password = pass.getText().toString();
        loginPres.ProsessLogin(userName, password);
    }

    @Override
    public void loginValidations() {
        Toast.makeText(getApplicationContext(), "invalid email or password", Toast.LENGTH_SHORT).show();
        Log.i("TAG", "Enter Data !");
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(), "Success Login", Toast.LENGTH_SHORT).show();
        Log.i("TAG", "Success");
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(), "Fail Login , Check your Network", Toast.LENGTH_SHORT).show();
        Log.i("TAG", "Fail");
    }

    @Override
    public boolean validEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }


}
