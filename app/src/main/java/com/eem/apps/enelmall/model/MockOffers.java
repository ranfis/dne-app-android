package com.eem.apps.enelmall.model;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.eem.apps.enelmall.OffersActivity;


public class MockOffers {
    protected static final String TAG = "[MockOffers]";

    static Offer[] offers = {
            new Offer(1,"tile","description",Type.DESCUENTO, Category.BELLEZA,"23/23/12",new Store(1), null, null)
    };



//    this.id = id;
//    this.title = title;
//    this.description = description;
//    this.type = type;
//    this.category = category;
//    this.expirationDate = expirationDate;
//    this.store = store;
//    this.location = location;
//    this.image = image;


    public static String getOffers(int delay){
        Log.d(TAG, "getOffers()");
        try {
            Thread.sleep(delay);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        String jsonOffers = "[";
        for (Offer o : offers) {
            jsonOffers+=o;
        }
        jsonOffers+="]";
        return jsonOffers;
    }


    public static String getOffer(int index){
        Log.d(TAG, "getOffer()");
        return offers[index].toString();
    }
}