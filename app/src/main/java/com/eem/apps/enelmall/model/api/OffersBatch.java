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

public class OffersBatch extends DataApiCall {
    protected static final String TAG = "[OffersBatch]";
    public static ArrayList<Offer> offers = new ArrayList<>();

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

    public static void getMockOffers(){
        offers.add(new Offer(1, "Oferta 1", "Detalles 1", Type.DESCUENTO, Category.BELLEZA, "23/23/12", new Store(1, "Agora Mall"), null, null));
        offers.add(new Offer(1,"Oferta 2","Detalles 2", Type.TIEMPO_LIMITADO, Category.BELLEZA,"23/23/12",new Store(1,"Agora Mall"), null, null));
        offers.add(new Offer(1,"Oferta 3","Detalles 3", Type.TIEMPO_LIMITADO, Category.COMIDA,"23/23/12",new Store(2,"Sambil"), null, null));
        offers.add(new Offer(1,"Oferta 3","Detalles 3", Type.TIEMPO_LIMITADO, Category.COMIDA,"23/23/12",new Store(2,"Sambil"), null, null));
    }

    public static ArrayList<Offer> getAll(){
        return offers;
    }
}
