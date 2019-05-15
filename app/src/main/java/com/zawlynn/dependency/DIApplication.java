package com.zawlynn.dependency;

import android.app.Activity;
import android.app.Application;
import com.zawlynn.dependency.di.component.ApplicationComponent;
import com.zawlynn.dependency.di.component.DaggerApplicationComponent;
import com.zawlynn.dependency.di.module.ContextModule;

public class DIApplication extends Application {
    ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);
    }


    public static DIApplication get(Activity activity){
        return (DIApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
