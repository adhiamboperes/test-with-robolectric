package com.adhiambo.dummybazelapp;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends ViewModel {
    MutableLiveData<CardItem> cardItemMutableLiveData;

    public void getCardItem() {
        CardItem cardItem = new CardItem();
        cardItem.setTitle("This is title text");
        cardItem.setSubTitle("Some supporting text. Much longer than the title.");
        cardItemMutableLiveData = new MutableLiveData<>();
        cardItemMutableLiveData.postValue(cardItem);
    }

}