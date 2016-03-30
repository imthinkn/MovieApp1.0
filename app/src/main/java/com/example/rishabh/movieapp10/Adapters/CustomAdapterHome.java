package com.example.rishabh.movieapp10.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rishabh.movieapp10.POJO.POJO_Movies.MoviesDiscover;
import com.example.rishabh.movieapp10.POJO.POJO_People.PeopleDiscover;
import com.example.rishabh.movieapp10.POJO.POJO_Tv.TvDiscover;
import com.example.rishabh.movieapp10.R;
import com.squareup.picasso.Picasso;


public class CustomAdapterHome extends RecyclerView.Adapter<CustomAdapterHome.ViewHolder>{

    private int layoutData;                             //'0' for home fragment layout and '1' for movie/tv fragment layout
    private int typeData;                               //'0' for movie and '1' for tv shows
    private LayoutInflater inflater;
    MoviesDiscover movieModel;
    TvDiscover tvModel;
    PeopleDiscover peopleModel;
    Context context;

    public CustomAdapterHome(Context context, MoviesDiscover data, int lData, int tData) {

        inflater=LayoutInflater.from(context);
        movieModel = data;
        layoutData = lData;
        typeData = tData;
        this.context = context;
    }


    public CustomAdapterHome(Context context, TvDiscover data, int lData, int tData) {

        inflater=LayoutInflater.from(context);
        tvModel = data;
        layoutData = lData;
        typeData = tData;
        this.context = context;
    }

    public CustomAdapterHome(Context context, PeopleDiscover data, int lData, int tData) {

        inflater=LayoutInflater.from(context);
        peopleModel = data;
        layoutData = lData;
        typeData = tData;
        this.context = context;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private static TextView tvID;
        //private final TextView tvTitle;
        // private final TextView tvOverview;
        private final TextView tvReleaseDate;
         //private final TextView tvPopularity;
        // private final TextView tvVoteCount;
        // private final TextView tvVoteAverage;
        // each data item is just a string in this case

        public ViewHolder(View v) {
            super(v);


            imageView = (ImageView) v.findViewById(R.id.iv);
            tvID = (TextView) v.findViewById(R.id.tv3);
            //tvTitle = (TextView) v.findViewById(R.id.tv1);
            //tvOverview = (TextView) v.findViewById(R.id.tvOverview);
            tvReleaseDate = (TextView) v.findViewById(R.id.tv2);
            //tvPopularity = (TextView) v.findViewById(R.id.tvPopularity);
            //tvVoteCount = (TextView) v.findViewById(R.id.tvVoteCount);
            //tvVoteAverage = (TextView) v.findViewById(R.id.tvVoteAverage); */
        }
    }

    @Override
    public CustomAdapterHome.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        if (layoutData == 0){

            view = inflater.inflate(R.layout.row_home, parent,false);
        }else if (layoutData==1)
        {
            view = inflater.inflate(R.layout.row_home_mtv, parent,false);
        }
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        switch (typeData){
            case 0:

                Picasso.with(context).load("http://image.tmdb.org/t/p/w500" + movieModel.getResults().get(position).getPosterPath()).fit().into(holder.imageView);
                holder.tvReleaseDate.setText("Release Date: " + movieModel.getResults().get(position).getReleaseDate());
                holder.tvID.setText("ID: " + movieModel.getResults().get(position).getId().toString());
                break;

            case 1:

                Picasso.with(context).load("http://image.tmdb.org/t/p/w500" + tvModel.getResults().get(position).getPosterPath()).fit().into(holder.imageView);
                holder.tvReleaseDate.setText("First Air Date: " + tvModel.getResults().get(position).getFirstAirDate());
                holder.tvID.setText("ID: " + tvModel.getResults().get(position).getId().toString());
                break;

            case 2:

                Picasso.with(context).load("http://image.tmdb.org/t/p/w500" + peopleModel.getResults().get(position).getProfilePath()).fit().into(holder.imageView);
                holder.tvReleaseDate.setText("Name: " + peopleModel.getResults().get(position).getName());
                holder.tvID.setText("Popularity: " + peopleModel.getResults().get(position).getPopularity().toString());
                break;
        }
    }

    @Override
    public int getItemCount() {

        int itemCount = 0;

        switch (typeData) {
            case 0: itemCount = movieModel.getResults().size();
            //return 9;
            break;

            case 1:
                itemCount = tvModel.getResults().size();
            break;

            case 2:
                itemCount = peopleModel.getResults().size();
                //itemCount = 9;
                break;
        }
        return itemCount;
    }
}