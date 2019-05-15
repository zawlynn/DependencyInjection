package com.zawlynn.dependency.di.component;

import android.content.Context;
import com.zawlynn.dependency.di.module.MainActivityContextModule;
import com.zawlynn.dependency.di.qualifier.ActivityContext;
import com.zawlynn.dependency.di.scope.ActivityScope;
import com.zawlynn.dependency.ui.main.MainActivity;
import dagger.Component;

@ActivityScope
@Component(modules = MainActivityContextModule.class,dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();

    void injectMainActivity(MainActivity mainActivity);
}
