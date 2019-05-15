package com.zawlynn.dependency.di.module;

import android.content.Context;
import com.zawlynn.dependency.di.qualifier.ActivityContext;
import com.zawlynn.dependency.di.scope.ActivityScope;
import com.zawlynn.dependency.ui.main.MainActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;
    private Context context;
    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
        this.context=mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity provideMainAcitivity(){
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext(){
        return context;
    }
}
