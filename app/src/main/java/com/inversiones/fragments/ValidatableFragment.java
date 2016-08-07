package com.inversiones.fragments;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.inversiones.Constants;
import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidatableFragment extends Fragment implements Validator.ValidationListener, Constants {

    private Map<Integer, EditText> lastFailingFields;
    protected Validator validator;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        validator = new Validator(this);
        validator.setValidationListener(this);
        validator.setValidationMode(Validator.Mode.BURST);
        lastFailingFields = new HashMap<>();
    }

    @Override
    public void onValidationSucceeded() {
        Log.d(TAG, "onValidationSucceeded");
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        String res = "";
        cleanOldFailingFields(errors);
        for (ValidationError ve : errors) {
            res = "";
            for (Rule rule : ve.getFailedRules())
                res += rule.getMessage(getContext()) + "\n";
            View v = ve.getView();
            if (v instanceof EditText) {
                EditText currentEdit = ((EditText) v);
                showError(currentEdit, res);
            }
        }
        saveLastFailingFields(errors);
    }

    private void cleanOldFailingFields(List<ValidationError> errors) {

        for (EditText editText : lastFailingFields.values()) {

            if (errors != null) {
                if (!hasErrors(editText, errors)) {
                    cleanError(editText);
                }
            } else {
                cleanError(editText);
            }
        }
    }

    private boolean hasErrors(EditText editText, List<ValidationError> errors) {
        for (ValidationError ve : errors) {
            View v = ve.getView();
            if (v.getId() == editText.getId()) {
                return true;
            }
        }
        return false;
    }

    private void cleanError(EditText editText) {
        TextInputLayout currentIL = (TextInputLayout) editText.getParent();
        currentIL.setError(null);
        currentIL.setErrorEnabled(false);
    }

    private void showError(EditText editText, String error) {
        TextInputLayout currentIL = (TextInputLayout) editText.getParent();
        currentIL.setError(error);
        currentIL.setErrorEnabled(true);
        if (editText.isFocusableInTouchMode())
            editText.requestFocus();
    }

    private void saveLastFailingFields(List<ValidationError> errors) {
        for (ValidationError ve : errors) {
            View v = ve.getView();
            if (v instanceof EditText) {
                EditText currentEdit = ((EditText) v);

                lastFailingFields.put(v.getId(), currentEdit);
            }
        }
    }
}
