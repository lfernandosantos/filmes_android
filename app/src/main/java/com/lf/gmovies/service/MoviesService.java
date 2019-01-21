package com.lf.gmovies.service;

import com.lf.gmovies.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public class MoviesService {

    private static String URL_BASE = "https://private-b1df84-movies288.apiary-mock.com/";

    interface IMoviesAPI {
        @GET("movies")
        Call<List<Movie>> getMovies();
    }

    public void requestMovies(Callback<List<Movie>> handler) {

        BaseService<IMoviesAPI> service = new BaseService<>(MoviesService.URL_BASE, IMoviesAPI.class);
        IMoviesAPI api = service.createRetrofit();
        Call<List<Movie>> call = api.getMovies();
        call.enqueue(handler);
    }
}
