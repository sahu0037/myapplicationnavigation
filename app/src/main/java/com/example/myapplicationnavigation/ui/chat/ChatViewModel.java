package com.example.myapplicationnavigation.ui.chat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ChatViewModel extends ViewModel {

    public static final String[] BOT_GREETINGS = {"Hello! How are you feeling?", "Hi there! How are you doing?"};
    public static final String[] BOT_POSITIVE_RESPONSES = {"That's great to hear!", "Glad to hear that!"};
    public static final String[] BOT_NEGATIVE_RESPONSES = {"Happy to help, here are some recommendations:", "I'm sorry to hear that. Here are some tips to help you feel better."};
    public static final String[] BOT_GOODBYE_RESPONSES = {"Goodbye!", "See you later!", "Take care!"};
    public static final String[] BOT_MENTAL_HEALTH_ADVICE = {"Go for a walk in the park.", "Call a friend or family member.", "Try a relaxation technique, like deep breathing or meditation.", "Take a break from social media.", "Get enough sleep and eat a healthy diet.", "Consider talking to a mental health professional."};

    private MutableLiveData<String> botMessage;
    private boolean waitingForInput;
    private int currentBotResponseIndex;
    private boolean receivedThankYou;

    public ChatViewModel() {
        botMessage = new MutableLiveData<>();
        waitingForInput = false;
        currentBotResponseIndex = 0;
        receivedThankYou = false;
    }

    public LiveData<String> getBotMessageLiveData() {
        return botMessage;
    }

    public void processInput(String input) {
        if (input.toLowerCase().contains("restart")) {
            botMessage.setValue(BOT_GREETINGS[new Random().nextInt(BOT_GREETINGS.length)]);
            waitingForInput = true;
            currentBotResponseIndex = 0;
            receivedThankYou = false;
        } else if (input.toLowerCase().contains("thank you")) {
            botMessage.setValue(BOT_GOODBYE_RESPONSES[new Random().nextInt(BOT_GOODBYE_RESPONSES.length)]);
            receivedThankYou = true;
        } else if (!receivedThankYou && !waitingForInput && input.toLowerCase().contains("hi")) {
            // Bot greeting should not include negative response
            botMessage.setValue(BOT_GREETINGS[new Random().nextInt(BOT_GREETINGS.length)]);
            waitingForInput = true;
        } else if (waitingForInput) {
            if (input.toLowerCase().contains("no")) {
                botMessage.setValue(BOT_GOODBYE_RESPONSES[new Random().nextInt(BOT_GOODBYE_RESPONSES.length)]);
                receivedThankYou = true;
            } else if (input.toLowerCase().contains("good") || input.toLowerCase().contains("great")) {
                botMessage.setValue(BOT_POSITIVE_RESPONSES[new Random().nextInt(BOT_POSITIVE_RESPONSES.length)]);
                botMessage.setValue("Would you like more advice?");
            } else {
                // Bot negative response with mental health advice should only appear when input is negative
                botMessage.setValue(BOT_NEGATIVE_RESPONSES[new Random().nextInt(BOT_NEGATIVE_RESPONSES.length)] + " " + BOT_MENTAL_HEALTH_ADVICE[new Random().nextInt(BOT_MENTAL_HEALTH_ADVICE.length)]);
                botMessage.setValue("Would you like advice?");
            }
            waitingForInput = true;
        } else if (!receivedThankYou && input.toLowerCase().contains("bye")) {
            botMessage.setValue(BOT_GOODBYE_RESPONSES[new Random().nextInt(BOT_GOODBYE_RESPONSES.length)]);
            receivedThankYou = true;
        } else {
            botMessage.setValue("I'm sorry, I didn't understand. Could you please rephrase?");
            waitingForInput = false;
        }
    }


    public boolean isWaitingForInput() {
        return waitingForInput;
    }

    public void setWaitingForInput(boolean waitingForInput) {
        this.waitingForInput = waitingForInput;
    }

    public int getCurrentBotResponseIndex() {
        return currentBotResponseIndex;
    }

    public void setCurrentBotResponseIndex(int currentBotResponseIndex) {
        this.currentBotResponseIndex = currentBotResponseIndex;
    }

}
