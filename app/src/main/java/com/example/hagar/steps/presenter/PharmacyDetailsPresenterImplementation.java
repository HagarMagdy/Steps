package com.example.hagar.steps.presenter;

import android.util.Log;

import com.example.hagar.steps.model.PharmacyDetails;
import com.example.hagar.steps.model.PharmacyDetailsModelInterface;
import com.example.hagar.steps.view.PharmacyDetailsView;

/**
 * Created by Hagar on 29/05/2018.
 */

public class PharmacyDetailsPresenterImplementation implements PharmacyDetailsPresenter {
    PharmacyDetailsView view;
    PharmacyDetailsModelInterface model;

    public PharmacyDetailsPresenterImplementation(PharmacyDetailsView view, PharmacyDetailsModelInterface model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getDetails(int tid, int sid) {
        Log.i("KEY2", "Presenter/getDetails");

        model.retrieveDetails(tid,sid);
    }

    @Override
    public void showDetails(PharmacyDetails details) {
        //view.method
    }
}
