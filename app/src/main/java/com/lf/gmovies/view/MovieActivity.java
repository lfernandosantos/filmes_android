package com.lf.gmovies.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.lf.gmovies.R;
import com.lf.gmovies.model.Movie;
import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {

    private ImageView movieImage;
    private TextView movieName, duration, description, favorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Movies");

        Movie movie = (Movie) getIntent().getSerializableExtra("selectedMovie");

        movieImage = findViewById(R.id.movieDetailsIV);
        movieName = findViewById(R.id.movieNameTV);
        duration = findViewById(R.id.movieDurationTV);
        description = findViewById(R.id.movieDescTV);
        favorites = findViewById(R.id.movieFavoritesTV);

        Picasso.get().load(movie.thumb).error(R.drawable.ic_no_image).into(movieImage);
        movieName.setText(movie.programName);
        duration.setText(movie.duration);
        description.setText(movie.description);
        favorites.setText(movie.favorites.toString());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
