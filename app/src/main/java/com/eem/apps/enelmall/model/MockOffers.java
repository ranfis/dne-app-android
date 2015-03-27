package com.eem.apps.enelmall.model;


import android.util.Log;


public class MockOffers {
    protected static final String TAG = "[MockOffers]";

    static Offer[] offers = {
            new Offer("tile","description",Type.DESCUENTO, Category.BELLEZA,"//",new Store(1),null)
    };


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