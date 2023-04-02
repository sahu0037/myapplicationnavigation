package com.example.myapplicationnavigation.ui.changePassword;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChangePasswordViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ChangePasswordViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is password change fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}