package com.example.rishabh.movieapp10.APICalls;


import com.example.rishabh.movieapp10.POJO.POJO_Tv.TvDiscover;

import retrofit.Callback;
import retrofit.http.GET;

public interface TvRequest {

    @GET("/3/tv/popular?api_key=d218b1d7aec02d0d2e80e3ffdae46356")
    void getPopularTv(Callback<TvDiscover> response);

    @GET("/3/tv/latest?api_key=d218b1d7aec02d0d2e80e3ffdae46356")
    void getLatestTv(Callback<TvDiscover> response);

}
