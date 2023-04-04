package com.example.myapplicationnavigation.ui.forgotPassword;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ForgotPasswordViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ForgotPasswordViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is password change fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}