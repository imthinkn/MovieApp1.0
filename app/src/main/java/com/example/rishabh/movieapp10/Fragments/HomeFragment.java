package com.example.rishabh.movieapp10.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.rishabh.movieapp10.APICalls.DiscoverRequest;
import com.example.rishabh.movieapp10.Adapters.CustomAdapterHome;
import com.example.rishabh.movieapp10.FragmentCommunicator;
import com.example.rishabh.movieapp10.POJO.POJO_Movies.MoviesDiscover;
import com.example.rishabh.movieapp10.POJO.POJO_People.PeopleDiscover;
import com.example.rishabh.movieapp10.POJO.POJO_Tv.TvDiscover;
import com.example.rishabh.movieapp10.R;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class HomeFragment extends Fragment {

    private CustomAdapterHome adapter = null;
    String BaseUrl = "http://api.themoviedb.org";

    private RecyclerView rv1;
    private RecyclerView rv2;
    private RecyclerView rv3;
    private Button bv1;
    private Button bv2;
    private Button bv3;
    FragmentCommunicator comm;
    //private RecyclerView rV4;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        comm = (FragmentCommunicator) getActivity();
        bv1 = (Button) getActivity().findViewById(R.id.bv1);
        bv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Button", "Button working fine till here.");
                comm.respond(0);
            }
        });

        bv2 = (Button) getActivity().findViewById(R.id.bv1);
        bv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("efgh", "Button working fine till here.");
                comm.respond(1);
            }
        });

        bv3 = (Button) getActivity().findViewById(R.id.bv1);
        bv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("jklm", "Button working fine till here.");
                comm.respond(0);
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home_fragment, container, false);

        rv1 = (RecyclerView) rootView.findViewById(R.id.rv1);
        rv2 = (RecyclerView) rootView.findViewById(R.id.rv2);
        rv3 = (RecyclerView) rootView.findViewById(R.id.rv3);
        //bv1 = (Button)rootView.findViewById(R.id.bv1);

        return rootView;
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
            updateHome();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        updateHome();
    }

    private void updateHome() {
        FetchMoviesTask(0);
        FetchMoviesTask(1);
        FetchMoviesTask(2);

    }

    private void FetchMoviesTask(int a){

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BaseUrl).build();

        switch (a){


            case 0:
                DiscoverRequest request0 = restAdapter.create(DiscoverRequest.class);
            request0.getFeedMovies(new Callback<MoviesDiscover>() {
            @Override
            public void success(MoviesDiscover moviesDiscover, Response response) {

                CustomAdapterHome adapter = new CustomAdapterHome(getContext(), moviesDiscover, 0, 0);
                rv1.setAdapter(adapter);
                rv1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                // tv.setText(movies.getResults().get(0).getTitle());
                // Picasso.with(getApplicationContext()).load("http://image.tmdb.org/t/p/w500" + movies.getResults().get(0).getBackdropPath()).fit().into(iv);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
                break;

            case 1: DiscoverRequest request1 = restAdapter.create(DiscoverRequest.class);
                request1.getFeedTv(new Callback<TvDiscover>() {
                    @Override
                    public void success(TvDiscover tvDiscover, Response response) {

                        CustomAdapterHome adapter = new CustomAdapterHome(getContext(), tvDiscover, 0, 1);
                        rv2.setAdapter(adapter);
                        rv2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                        // tv.setText(movies.getResults().get(0).getTitle());
                        // Picasso.with(getApplicationContext()).load("http://image.tmdb.org/t/p/w500" + movies.getResults().get(0).getBackdropPath()).fit().into(iv);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                break;

            case 2:  DiscoverRequest request2 = restAdapter.create(DiscoverRequest.class);
                request2.getFeedPeople(new Callback<PeopleDiscover>() {
                    @Override
                    public void success(PeopleDiscover peopleDiscover, Response response) {

                        CustomAdapterHome adapter = new CustomAdapterHome(getContext(), peopleDiscover, 0, 2);
                        rv3.setAdapter(adapter);
                        rv3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                        // tv.setText(movies.getResults().get(0).getTitle());
                        // Picasso.with(getApplicationContext()).load("http://image.tmdb.org/t/p/w500" + movies.getResults().get(0).getBackdropPath()).fit().into(iv);
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