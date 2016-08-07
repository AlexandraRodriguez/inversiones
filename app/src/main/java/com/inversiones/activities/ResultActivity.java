package com.inversiones.activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.inversiones.R;

/**
 * Created by Ale on 04/08/2016.
 */
public class ResultActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_result, contentFrameLayout);
    }
}
