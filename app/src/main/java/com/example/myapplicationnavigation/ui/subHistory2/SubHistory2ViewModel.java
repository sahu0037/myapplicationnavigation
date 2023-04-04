package com.example.myapplicationnavigation.ui.subHistory2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
 public class SubHistory2ViewModel extends ViewModel {
        private MutableLiveData<String> botResponseLiveData = new MutableLiveData<>();

        private String[] botResponses = {
                "Botty: Hey there! How are you feeling today?",
                "Botty: Oh no! That sounds terrible. Do you want some recommendations to reduce your stress?",
                "Nice to meet you!",
                "Goodbye!"
        };

        public void processInput(String input) {
            switch (input) {
                case "hi":
                case "hello":
                    botResponseLiveData.setValue(botResponses[0]);
                    break;
                case "hey, i'm feeling like i'm dying here in the pile of homework":
                    botResponseLiveData.setValue(botResponses[1]);
                    break;
                case "nice to meet you":
                    botResponseLiveData.setValue(botResponses[2]);
                    break;
                case "goodbye":
                    botResponseLiveData.setValue(botResponses[3]);
                    break;
                default:
                    botResponseLiveData.setValue("Sorry, I didn't understand.");
                    break;
            }
        }

        public LiveData<String> getBotResponseLiveData() {
            return botResponseLiveData;
        }
    }
