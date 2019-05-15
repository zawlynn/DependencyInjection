package com.zawlynn.dependency.di.component;

import android.content.Context;
import com.zawlynn.dependency.DIApplication;
import com.zawlynn.dependency.data.network.MovieApi;
import com.zawlynn.dependency.di.module.ContextModule;
import com.zawlynn.dependency.di.module.RetrofitModule;
import com.zawlynn.dependency.di.qualifier.ApplicationContext;
import com.zawlynn.dependency.di.scope.ApplicationScope;
import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class,RetrofitModule.class})
public interface ApplicationComponent {
    public MovieApi getMovieApi();

    @ApplicationContext
    public Context getContext();

    public void injectApplication(DIApplication application);
}
