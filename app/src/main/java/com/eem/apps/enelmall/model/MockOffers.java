package com.eem.apps.enelmall.model;

import android.util.Log;

import com.eem.apps.enelmall.OffersActivity;
import com.eem.apps.enelmall.R;

import java.util.HashMap;
import java.util.Map;


public class MockOffers {
    protected static final String TAG = "[MockOffers]";

    public static Map<String, Integer> location = new HashMap<>();


    static Offer[] offers = {
            new Offer(1,"Oferta 1","Detalles 1", Type.DESCUENTO, Category.BELLEZA,"23/23/12",new Store(1,"Agora Mall"), location , R.drawable.pizza_example),
            new Offer(1,"Oferta 2","Detalles 2", Type.TIEMPO_LIMITADO, Category.BELLEZA,"23/23/12",new Store(1,"Agora Mall"), location, R.drawable.pizza_example),
            new Offer(1,"Oferta 3","Detalles 3", Type.TIEMPO_LIMITADO, Category.COMIDA,"23/23/12",new Store(2,"Sambil"), location, R.drawable.pizza_example),
            new Offer(1,"Oferta 3","Detalles 3", Type.TIEMPO_LIMITADO, Category.COMIDA,"23/23/12",new Store(2,"Sambil"),location,R.drawable.pizza_example)
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
            o.getLocation().put("longitude",1);
            o.getLocation().put("latitude",2);
            jsonOffers+=o+",";
        }
        jsonOffers = jsonOffers.substring(0,jsonOffers.length()-1);
        jsonOffers+="]";
        return jsonOffers;
    }


    public static String getOffer(int index){
        Log.d(TAG, "getOffer()");
        return offers[index].toString();
    }
}