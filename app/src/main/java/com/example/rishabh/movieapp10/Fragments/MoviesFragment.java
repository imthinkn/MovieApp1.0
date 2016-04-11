package com.example.rishabh.movieapp10.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rishabh.movieapp10.APICalls.MoviesRequest;
import com.example.rishabh.movieapp10.Adapters.CustomAdapterHome;
import com.example.rishabh.movieapp10.Adapters.CustomAdapterMoviesHome;
import com.example.rishabh.movieapp10.POJO.POJO_Movies.MoviesDiscover;
import com.example.rishabh.movieapp10.R;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MoviesFragment extends Fragment {

    static int counter;
    private CustomAdapterHome adapter = null;
    TextView tv;
    String BaseUrl = "http://api.themoviedb.org";
    private RecyclerView rv1;

    public static MoviesFragment newInstance(int a) {
        MoviesFragment fragment = new MoviesFragment();
        counter = a;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.movies_fragment, container, false);
        rv1 = (RecyclerView) rootView.findViewById(R.id.rv1);
        Button btn1 = (Button) rootView.findViewById(R.id.popular_movies);
        Button btn2 = (Button) rootView.findViewById(R.id.top_rated);
        Button btn3 = (Button) rootView.findViewById(R.id.upcoming);
        tv = (TextView) rootView.findViewById(R.id.recycler_header);

        updateHome(1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("POPULAR MOVIES");
                transferData(0);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("TOP RATED");
                transferData(1);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("UPCOMING MOVIES");
                transferData(2);
            }
        });


        return rootView;
    }

    public void transferData(int a){

        switch(a) {
            case 0:
                updateHome(0);
                break;
            case 1: updateHome(1);
                Log.v("switch", "Data coming to switch");
                break;
            case 2:updateHome(2);

        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.movie_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*@Override
    public void onStart() {
        super.onStart();
        switch(counter) {
            case 0:
                updateHome(0);
                break;
            case 1:Log.v("ONSTAT","ONSTAT working case 1");
                updateHome(1);
                break;
            case 2: updateHome(2);
                break;
                default: updateHome(0);
        }
    }*/

    private void updateHome(int a) {

        switch(a)
        {
            case 0: FetchMoviesTask(0);
                break;
            case 1: FetchMoviesTask(1);
                break;
            case 2: FetchMoviesTask(2);
                break;
            default:FetchMoviesTask(0);
        }

    }

    private void FetchMoviesTask(int a) {

        switch (a){
            case 0:  RestAdapter restAdapter0 = new RestAdapter.Builder().setEndpoint(BaseUrl).build();
                MoviesRequest request0 = restAdapter0.create(MoviesRequest.class);
                request0.getPopularMovies(new Callback<MoviesDiscover>() {
                    @Override
                    public void success(MoviesDiscover moviesDiscover, Response response) {
                        CustomAdapterMoviesHome adapter = new CustomAdapterMoviesHome(getContext(), moviesDiscover, getParentFragment());
                        rv1.setAdapter(adapter);
                        rv1.setLayoutManager(new StaggeredGridLayoutManager(2,1));
                        //rv1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

                break;

            case 1:  RestAdapter restAdapter1 = new RestAdapter.Builder().setEndpoint(BaseUrl).build();
                MoviesRequest request1 = restAdapter1.create(MoviesRequest.class);
                request1.getTopMovies(new Callback<MoviesDiscover>() {
                    @Override
                    public void success(MoviesDiscover moviesDiscover, Response response) {
                        CustomAdapterMoviesHome adapter = new CustomAdapterMoviesHome(getContext(), moviesDiscover, getParentFragment());
                        rv1.setAdapter(adapter);
                        rv1.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
                        //rv1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

                break;

            case 2:  RestAdapter restAdapter2 = new RestAdapter.Builder().setEndpoint(BaseUrl).build();
                MoviesRequest request2 = restAdapter2.create(MoviesRequest.class);
                request2.getUpcomingMovies(new Callback<MoviesDiscover>() {
                    @Override
                    public void success(MoviesDiscover moviesDiscover, Response response) {
                        CustomAdapterMoviesHome adapter = new CustomAdapterMoviesHome(getContext(), moviesDiscover, getParentFragment());
                        rv1.setAdapter(adapter);
                        rv1.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
                        //rv1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

                break;
        }

    }


}