package com.example.rishabh.movieapp10.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.rishabh.movieapp10.POJO.POJO_Tv.TvDiscover;
import com.example.rishabh.movieapp10.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Rishabh on 23-02-2016.
 */
public class CustomAdapterTvHome  extends RecyclerView.Adapter<CustomAdapterTvHome.ViewHolder> {

    private LayoutInflater inflater;
    TvDiscover tvModel;
    Context context;

    public CustomAdapterTvHome(Context context, TvDiscover data) {

        inflater = LayoutInflater.from(context);
        tvModel = data;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        //private static TextView tvID;
        //private final TextView tvTitle;
        // private final TextView tvOverview;
        //private final TextView tvReleaseDate;
        //private final TextView tvPopularity;
        // private final TextView tvVoteCount;
        // private final TextView tvVoteAverage;

        public ViewHolder(View v) {
            super(v);


            imageView = (ImageView) v.findViewById(R.id.iv);
            //tvID = (TextView) v.findViewById(R.id.tv2);
            //tvTitle = (TextView) v.findViewById(R.id.tv1);
            //tvOverview = (TextView) v.findViewById(R.id.tvOverview);
            //tvReleaseDate = (TextView) v.findViewById(R.id.tv3);
            //tvPopularity = (TextView) v.findViewById(R.id.tvPopularity);
            //tvVoteCount = (TextView) v.findViewById(R.id.tvVoteCount);
            //tvVoteAverage = (TextView) v.findViewById(R.id.tvVoteAverage); */
        }
    }

    @Override
    public CustomAdapterTvHome.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;
        view = inflater.inflate(R.layout.row_home_mtv, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(context).load("http://image.tmdb.org/t/p/w500" + tvModel.getResults().get(position).getPosterPath()).fit().into(holder.imageView);
        //holder.tvReleaseDate.setText("Release Date: " + movieModel.getResults().get(position).getReleaseDate());
        //holder.tvID.setText("ID: " + movieModel.getResults().get(position).getId().toString());


    }

    @Override
    public int getItemCount() {

        return tvModel.getResults().size();
        //return 9;
    }


}

