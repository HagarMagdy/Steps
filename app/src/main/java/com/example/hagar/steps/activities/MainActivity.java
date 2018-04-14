package com.example.hagar.steps.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hagar.steps.R;
import com.example.hagar.steps.model.modelImpl;
import com.example.hagar.steps.presenter.PresenterImpl;
import com.example.hagar.steps.presenter.LoginPresenter;
import com.example.hagar.steps.view.LoginView;

import java.util.regex.Matcher;
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
        loginPres = new PresenterImpl(MainActivity.this, new modelImpl());
    }

    @OnClick(R.id.login_btn)
    public void login(View view) {
        Log.i("key", "first step");
        String userName = uName.getText().toString();
        String password = pass.getText().toString();

        if (checkConnection() == true)
            loginPres.validatation(userName, password);
        else
            Toast.makeText(getApplicationContext(), "Open  MobileWIFI Or Data", Toast.LENGTH_SHORT).show();

    }



    @Override
    public void loginSuccess() {
        Log.i("KEY", "inside main/loginsuccess");

        Toast.makeText(getApplicationContext(), "Success Login", Toast.LENGTH_SHORT).show();
        Log.i("TAG", "Success");
    }

    @Override
    public void loginError() {
        Log.i("KEY", "inside main/loginerr");
        Toast.makeText(getApplicationContext(), "Fail Login", Toast.LENGTH_SHORT).show();
        Log.i("TAG", "Fail");
    }

    @Override
    public  boolean validEmmail(String email) {

        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }

        Log.i("V",""+isValid);
        return isValid;
    }

    @Override
    public boolean checkConnection() {
        Log.i("KEY", "CONNECTION");
        boolean connected = false;
        final ConnectivityManager connectivityManager = ((ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE));
        if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected()) {
            connected = true;
            Log.i("KEY", "internet connected");

        } else {
            Log.i("KEY", "internet not connected");

            connected = false;
        }
        return connected;
    }


}
