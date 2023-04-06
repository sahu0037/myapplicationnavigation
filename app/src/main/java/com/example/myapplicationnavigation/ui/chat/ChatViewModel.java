package com.example.myapplicationnavigation.ui.chat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChatViewModel extends ViewModel {
    private MutableLiveData<String> botResponseLiveData = new MutableLiveData<>();
    private boolean waitingForInput = true;
    private int currentBotResponseIndex = 0;

    public static final String[] BOT_RESPONSES = {
            "Hey there! How are you feeling today?",
            "Oh no! That sounds terrible. Do you want some recommendations to reduce your stress?",
            "That's great to hear!",
            "Goodbye!"
    };

    public void processInput(String input) {
        if (waitingForInput) {
            if (input.contains("good")) {
                botResponseLiveData.setValue("That's great to hear!");
            } else if (input.contains("bad")) {
                botResponseLiveData.setValue("Oh no! That sounds terrible. Do you want some recommendations to reduce your stress?");
                waitingForInput = false;
            } else {
                botResponseLiveData.setValue("Hey there! How are you feeling today?");
            }
        } else {
            // The bot is now waiting for input on the mental health advice screen.
            // You can add code here to navigate to that screen or update the LiveData
            // with the appropriate response.
        }
    }

    public LiveData<String> getBotResponseLiveData() {
        return botResponseLiveData;
    }

    public int getCurrentBotResponseIndex() {
        return currentBotResponseIndex;
    }

    public void setCurrentBotResponseIndex(int index) {
        currentBotResponseIndex = index;
    }
}
