package com.zawlynn.dependency.di.module;

import android.content.Context;
import com.zawlynn.dependency.di.qualifier.ApplicationContext;
import com.zawlynn.dependency.di.scope.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;
    public ContextModule(Context context){
        this.context=context;
    }
    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext(){
        return this.context;
    }
}
