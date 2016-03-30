package com.example.rishabh.movieapp10;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.rishabh.movieapp10.Fragments.FragmentOne;
import com.example.rishabh.movieapp10.Fragments.MoviesFragment;
import com.example.rishabh.movieapp10.Fragments.TvShowsFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navView);

        getSupportFragmentManager().beginTransaction().replace(R.id.container_1, new FragmentOne()).commit();

        setUpNavDrawer();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                item.setChecked(true);

                switch (item.getItemId()) {

                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_1, new FragmentOne()).commit();
                        break;
                    case R.id.movies:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_1, new MoviesFragment()).commit();
                        break;

                    case R.id.tvShows:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_1, new TvShowsFragment()).commit();
                        break;


                    default:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_1, new FragmentOne()).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeFragment/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpNavDrawer() {
        if (toolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }
    }

}