package com.example.rishabh.movieapp10.APICalls;


import com.example.rishabh.movieapp10.POJO.POJO_Movies.MoviesDiscover;
import com.example.rishabh.movieapp10.POJO.POJO_People.PeopleDiscover;
import com.example.rishabh.movieapp10.POJO.POJO_Tv.TvDiscover;

import retrofit.Callback;
import retrofit.http.GET;

public interface DiscoverRequest {

    @GET("/3/discover/movie?api_key=d218b1d7aec02d0d2e80e3ffdae46356")
    void getFeedMovies(Callback<MoviesDiscover> response);     //string user is for passing values from edittext for eg: user=basil2style,google
    //response is the response from the server which is now in the MoviesDiscover

    @GET("/3/discover/tv?api_key=d218b1d7aec02d0d2e80e3ffdae46356")
    void getFeedTv(Callback<TvDiscover> response);

    @GET("/3/person/popular?api_key=d218b1d7aec02d0d2e80e3ffdae46356")
    void getFeedPeople(Callback<PeopleDiscover> response);

}
