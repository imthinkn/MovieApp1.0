package com.example.rishabh.movieapp10.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rishabh.movieapp10.Adapters.PagerAdapter;
import com.example.rishabh.movieapp10.R;

public class FragmentOne extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.first_fragment, container, false);

       /* Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);*/

        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);

        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new MoviesFragment(), "Movies");
        adapter.addFragment(new TvShowsFragment(), "Tv Shows");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.id_tabs);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }
}