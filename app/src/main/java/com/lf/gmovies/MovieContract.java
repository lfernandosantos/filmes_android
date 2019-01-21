package com.lf.gmovies;

import com.lf.gmovies.model.Movie;

import java.util.List;

public interface MovieContract {

    interface View {
        void loadMovies(List<Movie> movies);
    }

    interface Presenter{
        void moviesRequest();
    }
}
