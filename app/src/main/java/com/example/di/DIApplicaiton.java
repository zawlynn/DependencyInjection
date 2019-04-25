package com.example.di;

import android.app.Application;

public class DIApplicaiton extends Application {
    private SmartPhoneComponent component;
    private static DIApplicaiton applicaiton;
    @Override
    public void onCreate() {
        super.onCreate();
        applicaiton = this;

        component = DaggerSmartPhoneComponent.builder()
                .memoryModule(new MemoryModule(128))
                .build();
    }

    public static DIApplicaiton getApplicaiton() {
        return applicaiton;
    }

    public SmartPhoneComponent getComponent() {
        return component;
    }
}
