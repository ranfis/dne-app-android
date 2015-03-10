package com.eem.apps.enelmall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.graphics.Typeface;
import android.widget.TextView;

import com.eem.apps.enelmall.model.api.DataApiCall;


public class StartActivity extends Activity {

    static StartActivity self;
    public final static String OFFERS = "com.example.webapitutorial.OFFERS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("StartActivity","onCreate()");
        super.onCreate(savedInstanceState);
        self = this;
        setContentView(R.layout.activity_start);

        // Change Typeface for app name
        String fontPath = "fonts/Kraftstoff_Regular.otf";
        TextView txtAppName = (TextView)findViewById(R.id.txtAppName);
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        txtAppName.setTypeface(tf);

        // Get offers
        String urlString = "http://104.236.25.160:9000/api/ofertas";
        new DataApiCall().execute(urlString,"gotoOffers");
    }

    public void gotoOffers(View view) {
        Log.d("StartActivity","gotoOffers()");
        Intent offers = new Intent(this,OffersActivity.class);
        startActivity(offers);
    }

    public static void toOffers(String offersJson){
        Intent offers = new Intent(self,OffersActivity.class);
        offers.putExtra(OFFERS, offersJson);
        self.startActivity(offers);
    }
}
