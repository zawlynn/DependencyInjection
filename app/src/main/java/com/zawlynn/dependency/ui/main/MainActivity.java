package com.zawlynn.dependency.ui.main;

import androidx.lifecycle.ViewModelProviders;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

import butterknife.ButterKnife;
import com.zawlynn.dependency.DIApplication;
import com.zawlynn.dependency.R;
import com.zawlynn.dependency.data.network.MovieApi;
import com.zawlynn.dependency.di.component.ApplicationComponent;
import com.zawlynn.dependency.di.component.DaggerMainActivityComponent;
import com.zawlynn.dependency.di.component.MainActivityComponent;
import com.zawlynn.dependency.di.module.MainActivityContextModule;
import com.zawlynn.dependency.pojo.Movie;
import com.zawlynn.dependency.ui.main.adapter.PopularMovieAdapter;
import com.zawlynn.dependency.ui.main.viewmodel.MainActivityViewModel;
import com.zawlynn.dependency.utils.OnItemClick;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements OnItemClick {
    MainActivityViewModel viewModel;
    MainActivityComponent mainActivityComponent;
    PopularMovieAdapter adapter;
    @BindView(R.id.recMovie)
    RecyclerView recMovie;
    @Inject
    public MovieApi movieApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ApplicationComponent applicationComponent = DIApplication.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent)
                .build();
        mainActivityComponent.injectMainActivity(this);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.requestData(movieApi);
        viewModel.getMovies().observe(this, movies -> {
            if (movies != null) {
                adapter.submitList(movies);
            }
        });
        initUI();
    }
    private void initUI(){
        adapter=new PopularMovieAdapter(this);
        GridLayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),2);
        recMovie.setLayoutManager(layoutManager);
        recMovie.setAdapter(adapter);
    }
    @Override
    public void onClick(Movie movie) {

    }
}
