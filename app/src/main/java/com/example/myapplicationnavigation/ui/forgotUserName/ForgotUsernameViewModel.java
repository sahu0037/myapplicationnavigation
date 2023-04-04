package com.example.myapplicationnavigation.ui.forgotUserName;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ForgotUsernameViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ForgotUsernameViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is password change fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}