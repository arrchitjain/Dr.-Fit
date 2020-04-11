package com.example.fitraho.ui.caloriecounter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CaloriecounterViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CaloriecounterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is calorie fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}