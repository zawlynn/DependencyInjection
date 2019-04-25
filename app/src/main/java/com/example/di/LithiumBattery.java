package com.example.di;

import android.util.Log;
import javax.inject.Inject;


public class LithiumBattery implements Battery {
    private static final String TAG = "SmartPhone";
    @Inject
    public LithiumBattery() {
    }

    @Override
    public void showType() {
        Log.d(TAG, "showType: Lithium");
    }
}
