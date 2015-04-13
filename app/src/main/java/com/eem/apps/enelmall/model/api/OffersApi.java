package com.eem.apps.enelmall.model.api;

import android.util.Log;
import com.eem.apps.enelmall.StartActivity;
import com.eem.apps.enelmall.model.Category;
import com.eem.apps.enelmall.model.Offer;
import com.eem.apps.enelmall.model.Store;
import com.eem.apps.enelmall.model.Type;
import com.eem.apps.enelmall.util.JsonParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class OffersApi extends DataApiCall {
    protected static final String TAG = "[OffersApi]";
    public static final String API_URL = "http://104.236.25.160/api/offers";
    public static ArrayList<Offer> offers = new ArrayList<>();
    public static Offer offer;
    public static Store store;

    protected void onPostExecute(String result) {
        Log.d(TAG, "onPostExecute()");
        try {
            JSONArray jsonOffers = ((JSONArray)JsonParser.parse(result));
            for(int i=0;i<=jsonOffers.length()-1;i++){
                Offer offer = new Offer( (JSONObject)jsonOffers.get(i) );
                offers.add(offer);
            }
            StartActivity.goToOffers();
        }
        catch(JSONException err){
            Log.e(TAG, "onPostExecute()/JSONException:Bad JSON");
        }
    }

    public static void filter(String store, String cat1,String cat2,String cat3,String type){
        Log.d(TAG, "filter()");
        ArrayList<Offer> newOffers = new ArrayList<>();
        ArrayList<Offer> offers = OffersApi.getAll();
        System.out.println("new"+newOffers);
        System.out.println("old"+offers);

        for(Offer offer : offers ){
            System.out.println( "Title: "+offer.getTitle() );
            if(offer.getStore().getName() == store){
                if(offer.getCategory().toString() == cat1 ){
                    System.out.println("Yeah1");
                    newOffers.add(offer);
                }
                else if(offer.getCategory().toString() == cat2 ){
                    System.out.println("Yeah2");
                    newOffers.add(offer);
                }
                else if(offer.getCategory().toString() == cat3 ){
                    System.out.println( "Yeah3");
                    newOffers.add(offer);
                }
            }
        }
    }

    public static ArrayList<Offer> getAll(){
        return offers;
    }

    public static void setOffer(Offer offerp) {
        offer = offerp;
    }

    public static Offer getOffer() {
        return offer;
    }

    public static void setStore(Store storee) {
        store = storee;
    }

    public static Store getStore() {
        return store;
    }
}
