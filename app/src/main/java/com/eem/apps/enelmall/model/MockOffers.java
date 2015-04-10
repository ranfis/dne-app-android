package com.eem.apps.enelmall.model;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;


public class MockOffers {
    protected static final String TAG = "[MockOffers]";

    public static Map<String, Integer> location = new HashMap<>();


    static Offer[] offers = {
            new Offer(1,"Oferta 1","Detalles 1", Type.DESCUENTO, Category.BELLEZA,"23/23/12",new Store(1,"Agora Mall"), location , "http://daxueconsulting.com/wp-content/uploads/2012/07/womens-clothes2.jpg"),
            new Offer(1,"Oferta 2","Detalles 2", Type.TIEMPO_LIMITADO, Category.BELLEZA,"23/23/12",new Store(1,"Agora Mall"), location, "http://www.tenpin.org.au/uploads/RTEmagicC_House_Shoes_01.jpg.jpg"),
            new Offer(1,"Oferta 3","Detalles 3", Type.TIEMPO_LIMITADO, Category.COMIDA,"23/23/12",new Store(2,"Sambil"), location, "http://machopicture.com/images/autumn-dresses/9301-fashion-clothes-for-women.jpg"),
            new Offer(1,"Oferta 4","Detalles 4", Type.TIEMPO_LIMITADO, Category.COMIDA,"23/23/12",new Store(2,"Sambil"),location,"https://s3.amazonaws.com/ODNUploads/5431308c0d073Cheese_Pizza_Pepperoni.jpsg")
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