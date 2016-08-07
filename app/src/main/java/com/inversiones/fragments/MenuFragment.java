package com.inversiones.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.inversiones.R;
import com.inversiones.activities.MenuActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ale on 04/08/2016.
 */
public class MenuFragment extends Fragment {

    @BindView(R.id.btn_inversion)
    Button btnInversion;
    @BindView(R.id.btn_tasa)
    Button btnTasa;
    @BindView(R.id.btn_rescate)
    Button btnRescate;
    @BindView(R.id.btn_flujos)
    Button btnFlujos;
    @BindView(R.id.btn_fab)
    FloatingActionButton btnFab;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.btn_inversion, R.id.btn_tasa, R.id.btn_rescate, R.id.btn_flujos, R.id.btn_fab})
    public void goTo(View view) {
        switch (view.getId()) {
            case R.id.btn_inversion:
                ((MenuActivity) getActivity()).loadInvestment();
                break;
            case R.id.btn_tasa:
                ((MenuActivity) getActivity()).loadInflationRate();
                break;
            case R.id.btn_rescate:
                ((MenuActivity) getActivity()).loadRescueValue();
                break;
            case R.id.btn_flujos:
                ((MenuActivity) getActivity()).loadCashFlow();
                break;
            case R.id.btn_fab:
                ((MenuActivity) getActivity()).startSimulation();
                break;
        }
    }
}
