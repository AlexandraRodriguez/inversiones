package com.inversiones.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inversiones.R;

import butterknife.ButterKnife;

/**
 * Created by Ale on 04/08/2016.
 */
public class InvestmentFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_triangular, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
