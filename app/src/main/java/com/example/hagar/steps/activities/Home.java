package com.example.hagar.steps.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hagar.steps.R;
import com.example.hagar.steps.presenter.PharmacyDetailsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Home extends AppCompatActivity {

    @BindView(R.id.button)
    Button details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);


    }


    @OnClick(R.id.button)
    public void go(View view) {
        Log.i("KEY2", "Home");

        Intent intent = new Intent(getBaseContext(), test.class);
        Bundle extras = new Bundle();
        extras.putString("tid", 2 + "");
        extras.putString("sid", 1 + "");
        intent.putExtras(extras);
        startActivity(intent);

    }

}
