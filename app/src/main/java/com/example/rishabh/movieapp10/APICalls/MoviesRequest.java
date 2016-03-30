package com.example.rishabh.movieapp10.APICalls;


import com.example.rishabh.movieapp10.POJO.POJO_Movies.MoviesDiscover;

import retrofit.Callback;
import retrofit.http.GET;

public interface MoviesRequest {

    @GET("/3/movie/popular?api_key=d218b1d7aec02d0d2e80e3ffdae46356")
    void getPopularMovies(Callback<MoviesDiscover> response);


    @GET("/3/movie/latest?api_key=d218b1d7aec02d0d2e80e3ffdae46356")
    void getLatestMovies(Callback<MoviesDiscover> response);

    @GET("/3/movie/top_rated?api_key=d218b1d7aec02d0d2e80e3ffdae46356")
    void getTopMovies(Callback<MoviesDiscover> response);

    @GET("/3/movie/upcoming?api_key=d218b1d7aec02d0d2e80e3ffdae46356")
    void getUpcomingMovies(Callback<MoviesDiscover> response);

}
