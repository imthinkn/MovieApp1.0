package com.example.rishabh.movieapp10.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList();

    private final List<String> mFragmentTitleNames = new ArrayList();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

   public void addFragment (Fragment fm, String string){
       mFragmentList.add(fm);
       mFragmentTitleNames.add(string);
   }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleNames.get(position);
    }
}
