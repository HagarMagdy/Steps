package com.example.hagar.steps.presenter;

import com.example.hagar.steps.model.PharmacyDetails;

/**
 * Created by Hagar on 29/05/2018.
 */

public interface PharmacyDetailsPresenter {
    void getDetails(int tid, int sid);
    void showDetails(PharmacyDetails details);

}
