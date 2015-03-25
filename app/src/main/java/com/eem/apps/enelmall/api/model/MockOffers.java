package com.eem.apps.enelmall.api.model;


import android.util.Log;

import com.eem.apps.enelmall.model.Category;
import com.eem.apps.enelmall.model.Offer;
import com.eem.apps.enelmall.model.Store;
import com.eem.apps.enelmall.model.Type;


public class MockOffers {
    static Offer[] offers = {
            new Offer("tile","description",Type.DESCUENTO, Category.BELLEZA,"//",new Store(1),null)
    };


    public static String getOffers(int delay){
        Log.d("MockOffers","getOffers()");
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
        Log.d("MockOffers","getOffer()");
        return offers[index].toString();
    }
}