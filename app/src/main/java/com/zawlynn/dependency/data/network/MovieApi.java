package com.zawlynn.dependency.data.network;

import com.zawlynn.dependency.data.network.response.PopularResponse;
import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("movie/popular")
    Call<PopularResponse> getPopularMovies(@Query("api_key") String api_key);
}
