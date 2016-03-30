package com.example.rishabh.movieapp10.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.rishabh.movieapp10.Fragments.MovieDetail;
import com.example.rishabh.movieapp10.POJO.POJO_Movies.MoviesDiscover;
import com.example.rishabh.movieapp10.R;
import com.squareup.picasso.Picasso;

public class CustomAdapterMoviesHome extends RecyclerView.Adapter<CustomAdapterMoviesHome.ViewHolder> {

    private static Fragment fragment;
    private LayoutInflater inflater;
    MoviesDiscover movieModel;
    Context context;

    public CustomAdapterMoviesHome(Context context, MoviesDiscover data, Fragment fragment) {

        this.fragment = fragment;
        inflater = LayoutInflater.from(context);
        movieModel = data;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.iv);
        }

        @Override
        public void onClick(View v) {
           fragment.getChildFragmentManager().beginTransaction().replace(R.id.container_1,new MovieDetail()).commit();
        }
    }

    @Override
    public CustomAdapterMoviesHome.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;
        view = inflater.inflate(R.layout.row_home_mtv, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(context).load("http://image.tmdb.org/t/p/w500" + movieModel.getResults().get(position).getPosterPath()).fit().into(holder.imageView);
        //holder.tvReleaseDate.setText("Release Date: " + movieModel.getResults().get(position).getReleaseDate());
        //holder.tvID.setText("ID: " + movieModel.getResults().get(position).getId().toString());
    }

    @Override
    public int getItemCount() {
        return movieModel.getResults().size();
        //return 9;
    }
}
