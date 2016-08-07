package com.inversiones.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.inversiones.R;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ale on 04/08/2016.
 */
public class InflationRateFragment extends ValidatableFragment {

    @NotEmpty(messageResId = R.string.validation_msg)
    @BindView(R.id.edit_pessimistic)
    EditText editPessimistic;

    @NotEmpty(messageResId = R.string.validation_msg)
    @BindView(R.id.edit_probable)
    EditText editProbable;

    @NotEmpty(messageResId = R.string.validation_msg)
    @BindView(R.id.edit_optimistic)
    EditText editOptimistic;

    @BindView(R.id.btn_accept)
    Button btnAccept;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_triangular, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_accept)
    public void saveData() {
        validator.validate();
    }

    public void onValidationSucceeded() {
        saveInflationData();
    }

    public void saveInflationData() {

    }

}
