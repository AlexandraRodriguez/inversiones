package com.inversiones.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.inversiones.Constants;
import com.inversiones.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ale on 04/08/2016.
 */
public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, Constants {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.content_frame)
    FrameLayout contentFrame;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent anIntent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(anIntent);
                        break;
                    case R.id.nav_recent:
                        Toast.makeText(BaseActivity.this, "Recent", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_help:
                        Toast.makeText(BaseActivity.this, "Help", Toast.LENGTH_SHORT).show();
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent anIntent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(anIntent);
                break;
            case R.id.nav_recent:
                Toast.makeText(this, "Recent", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_help:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}