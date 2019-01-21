package com.lf.gmovies.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.lf.gmovies.R;
import com.lf.gmovies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> list;
    private Context context;
    private RecyclerItemClickListener listener;

    public MoviesAdapter(List<Movie> list, Context context, RecyclerItemClickListener listner){
        this.list = list;
        this.context = context;
        this.listener = listner;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView programName, favorites, duration;
        public ImageView thumb;

        public MyViewHolder(View view) {
            super(view);
            programName = view.findViewById(R.id.titleTV);
            favorites = view.findViewById(R.id.favoritesTV);
            duration = view.findViewById(R.id.durationTV);
            thumb = view.findViewById(R.id.thumbIMGV);
        }
    }

    public interface RecyclerItemClickListener {
        void clickItemList(View v, int position);
    }

    @NonNull
    @Override
    public MoviesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movies_list_adapter, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MyViewHolder myViewHolder, final int i) {

        Movie movie = list.get(i);
        myViewHolder.programName.setText(movie.programName);
        myViewHolder.favorites.setText(movie.favorites.toString());
        myViewHolder.duration.setText(movie.duration);
        Picasso.get().load(movie.thumb).error(R.drawable.ic_no_image).into(myViewHolder.thumb);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickItemList(v, i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
