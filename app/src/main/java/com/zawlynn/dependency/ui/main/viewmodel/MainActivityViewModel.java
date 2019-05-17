package com.zawlynn.dependency.ui.main.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.annotation.NonNull;
import com.zawlynn.dependency.constant.Constants;
import com.zawlynn.dependency.data.network.MovieApi;
import com.zawlynn.dependency.data.network.response.PopularResponse;
import com.zawlynn.dependency.pojo.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<List<Movie>> movies=new MutableLiveData<>();
    private static final String TAG = "MainActivityViewModel";
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void requestData(MovieApi movieApi) {
        movieApi.getPopularMovies(Constants.API_KEY).enqueue(new Callback<PopularResponse>() {
            @Override
            public void onResponse(@NonNull Call<PopularResponse> call,@NonNull Response<PopularResponse> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    try{
                        movies.postValue(response.body().getResults());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<PopularResponse> call,@NonNull Throwable t) {

            }
        });
    }

    public MutableLiveData<List<Movie>> getMovies() {
        return movies;
    }
}
