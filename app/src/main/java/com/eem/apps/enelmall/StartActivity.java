package com.eem.apps.enelmall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.graphics.Typeface;
import android.widget.TextView;


public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Change Typeface for app name
        String fontPath = "fonts/Kraftstoff_Regular.otf";
        TextView txtAppName = (TextView)findViewById(R.id.txtAppName);
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        txtAppName.setTypeface(tf);
    }

    public void gotoOffers(View view) {
        Intent offers = new Intent(this,OffersActivity.class);
        startActivity(offers);
    }
}
