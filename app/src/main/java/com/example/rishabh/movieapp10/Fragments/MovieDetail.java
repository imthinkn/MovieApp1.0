package com.example.rishabh.movieapp10.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.movieapp10.R;

public class MovieDetail extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.movie_detail, container, false);
        TextView tv = (TextView)v.findViewById(R.id.tv);
        String s = getArguments().getString("BlueColor");
        tv.setText(s);
        return v;
    }

    public static MovieDetail newInstance(String s){
        MovieDetail fragment = new MovieDetail();
        Bundle bundle = new Bundle();
        bundle.putString("BlueColor", s);
        fragment.setArguments(bundle);
        return fragment;
    }
}
