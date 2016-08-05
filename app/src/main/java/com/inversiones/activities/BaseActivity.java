package com.inversiones.activities;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by PC_ on 04/08/2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected void loadNavBar(String title) {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}