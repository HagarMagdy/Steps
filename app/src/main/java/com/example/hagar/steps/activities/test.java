package com.example.hagar.steps.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.hagar.steps.R;
import com.example.hagar.steps.model.PharmacyDetails;
import com.example.hagar.steps.model.PharmacyDetailsModelImplementation;
import com.example.hagar.steps.presenter.PharmacyDetailsPresenter;
import com.example.hagar.steps.presenter.PharmacyDetailsPresenterImplementation;
import com.example.hagar.steps.view.PharmacyDetailsView;

import butterknife.BindView;

public class test extends AppCompatActivity implements PharmacyDetailsView{

    @BindView(R.id.serviceName)
    TextView serviceName;
    @BindView(R.id.startDate)
    TextView startDate;
    @BindView(R.id.endDate)
    TextView endDate;
    @BindView(R.id.open_hour)
    TextView openHour;
    @BindView(R.id.closeHour)
    TextView closeHour;
    @BindView(R.id.rate)
    TextView rate;

    PharmacyDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        presenter = new PharmacyDetailsPresenterImplementation(test.this, new PharmacyDetailsModelImplementation());

        Log.i("KEY2", "test/onCreate");


        Bundle extras = getIntent().getExtras();
        String stringTid = extras.getString("tid");
        String stringSid = extras.getString("sid");

        int tid = Integer.parseInt(stringTid);
        int sid = Integer.parseInt(stringSid);
       presenter.getDetails(tid,sid);

    }

    @Override
    public void setPharmacyDetails(PharmacyDetails details) {

        serviceName.setText(details.getNameEn());
        startDate.setText(details.getStartDate());
        endDate.setText(details.getEndDate());
        openHour.setText(details.getOpenHour());
        closeHour.setText(details.getCloseHour());
   //     rate.setText((String)(details.getRate()));
    }
}
