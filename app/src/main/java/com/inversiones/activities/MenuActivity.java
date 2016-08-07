package com.inversiones.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.inversiones.R;
import com.inversiones.fragments.CashFlowFragment;
import com.inversiones.fragments.InflationRateFragment;
import com.inversiones.fragments.InvestmentFragment;
import com.inversiones.fragments.MenuFragment;
import com.inversiones.fragments.RescueValueFragment;


/**
 * Created by Ale on 04/08/2016.
 */
public class MenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_menu, contentFrameLayout);

        loadHome();
    }

    public void loadHome() {
        MenuFragment fragment = new MenuFragment();
        loadFragment(fragment);
    }

    public void loadInvestment() {
        InvestmentFragment fragment = new InvestmentFragment();
        loadFragment(fragment);
    }

    public void loadInflationRate() {
        InflationRateFragment fragment = new InflationRateFragment();
        loadFragment(fragment);
    }

    public void loadRescueValue() {
        RescueValueFragment fragment = new RescueValueFragment();
        loadFragment(fragment);
    }

    public void loadCashFlow() {
        CashFlowFragment fragment = new CashFlowFragment();
        loadFragment(fragment);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.menu_frame, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void startSimulation() {
        startActivity(new Intent(this, ResultActivity.class));
    }

}
