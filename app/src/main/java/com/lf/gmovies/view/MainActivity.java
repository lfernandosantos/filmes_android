package com.lf.gmovies.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.lf.gmovies.MovieContract;
import com.lf.gmovies.R;
import com.lf.gmovies.model.Movie;
import com.lf.gmovies.presenter.MoviesPresenter;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MovieContract.View, MoviesAdapter.RecyclerItemClickListener {


    private MoviesPresenter presenter;
    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    private List<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MoviesPresenter(this);
        presenter.moviesRequest();

        recyclerView = findViewById(R.id.moviesRV);

    }


    @Override
    public void loadMovies(List<Movie> movies) {
        this.movies = movies;
        moviesAdapter = new MoviesAdapter(movies, this, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(moviesAdapter);

    }


    @Override
    public void clickItemList(View v, int position) {
        Intent goMovieDetail = new Intent(this, MovieActivity.class);
        goMovieDetail.putExtra("selectedMovie", movies.get(position));
        startActivity(goMovieDetail);
    }
}
