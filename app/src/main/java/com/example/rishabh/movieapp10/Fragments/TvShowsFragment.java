package com.example.rishabh.movieapp10.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rishabh.movieapp10.APICalls.TvRequest;
import com.example.rishabh.movieapp10.Adapters.CustomAdapterTvHome;
import com.example.rishabh.movieapp10.POJO.POJO_Tv.TvDiscover;
import com.example.rishabh.movieapp10.R;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TvShowsFragment extends Fragment {

    String BaseUrl = "http://api.themoviedb.org";

    private RecyclerView rv;
    /*private RecyclerView rV2;
    private RecyclerView rV3;
    private RecyclerView rV4;*/


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tv_fragment, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.rv1);
        //rV2 = (RecyclerView) rootView.findViewById(R.id.rv2);

        FetchTvTask();

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
        FetchTvTask();

    }

    private void FetchTvTask(){

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BaseUrl).build();
        TvRequest request =  restAdapter.create(TvRequest.class);
        request.getPopularTv(new Callback<TvDiscover>() {
            @Override
            public void success(TvDiscover tvDiscover, Response response) {

                CustomAdapterTvHome adapterTv = new CustomAdapterTvHome(getContext(), tvDiscover);
                rv.setAdapter(adapterTv);
                rv.setLayoutManager(new StaggeredGridLayoutManager(2,1));

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
