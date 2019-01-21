package com.lf.gmovies.presenter;


import android.util.Log;

import com.lf.gmovies.MovieContract;
import com.lf.gmovies.model.Movie;
import com.lf.gmovies.service.MoviesService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesPresenter implements Callback<List<Movie>>, MovieContract.Presenter {

    private MovieContract.View view;

    public MoviesPresenter(MovieContract.View view) {
        this.view = view;
    }


    public void moviesRequest() {
        MoviesService moviesAPI = new MoviesService();

        moviesAPI.requestMovies(this);
    }
    @Override
    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
        Log.d("[API] : ", response.body().toString());

        view.loadMovies(response.body());
    }

    @Override
    public void onFailure(Call<List<Movie>> call, Throwable t) {
        Log.d("[API] : ", "Error : " + t.getMessage());
    }

}
