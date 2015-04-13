package com.eem.apps.enelmall;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
        //offerPhoto.setImageBitmap((Bitmap)offer.getfImageDetails());

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

    public void storeButton(View view) {
        OffersApi.setStore(OffersApi.getOffer().getStore());
        startActivity(new Intent(getApplicationContext(), StoreDetailsActivity.class));
    }


}
