package com.example.myapplicationnavigation.ui.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistoryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HistoryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Okay, might I recommend the following resources: (1) https://www.cdc.gov/stres...");
    }

    public LiveData<String> getText() {
        return mText;
    }
}