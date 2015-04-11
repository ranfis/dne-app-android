package com.eem.apps.enelmall;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.eem.apps.enelmall.model.Offer;
import com.eem.apps.enelmall.model.Store;
import com.eem.apps.enelmall.model.api.OffersApi;


public class DetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Getting Offer from static method to avoid using Parcelable objects
        Offer offer = OffersApi.getOffer();

        // Setting title in the actionbar from the offer
        setTitle(offer.getTitle());



        settingDetailsOffer(offer);
        settingDetailsStore(offer.getStore());
    }

    private void settingDetailsOffer(Offer offer) {
        ImageView offerPhoto = (ImageView) findViewById(R.id.photoOffer);
        TextView titleOffer = (TextView) findViewById(R.id.titleOffer);
        TextView categoryOffer = (TextView) findViewById(R.id.categoryOffer);
        TextView detailsOffer = (TextView) findViewById(R.id.detailsOffer);
        //ImageView typeOffer = (ImageView) findViewById(R.id.typeOffer); //TODO
        TextView expirationDateOffer = (TextView) findViewById(R.id.expTime);


        offerPhoto.setImageDrawable( (Drawable) offer.getfImageDetails());

        titleOffer.setText(offer.getTitle());
        categoryOffer.setText(offer.getCategory().getNameFromID(offer.getCategory().getId()).toUpperCase());
        detailsOffer.setText(offer.getDescription());
        expirationDateOffer.setText(offer.getExpirationDate());

    }

    private void settingDetailsStore(Store store) {
        ImageView storePhoto = (ImageView) findViewById(R.id.storePhoto);
        TextView titleStore = (TextView) findViewById(R.id.titleStore);

        titleStore.setText(store.getName());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
