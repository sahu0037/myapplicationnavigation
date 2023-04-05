package com.example.myapplicationnavigation.ui.home;

import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplicationnavigation.MainActivity;
import com.example.myapplicationnavigation.R;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        MainActivity mainActivity = MainActivity.getInstance();

        mText = new MutableLiveData<>();
        String username = mainActivity.getUsername();
        mText.setValue("Welcome to Tranquility! "+ username);




    }



    public LiveData<String> getText() {
        return mText;
    }
}