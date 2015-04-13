package com.eem.apps.enelmall;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eem.apps.enelmall.model.Store;
import com.eem.apps.enelmall.model.api.OffersApi;

import org.w3c.dom.Text;


public class StoreDetailsActivity extends ActionBarActivity {

    TextView phoneStore;
    TextView webStore;
    TextView fbStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);

        Store store = OffersApi.getStore();
        setTitle(store.getName());

        settingCardsStore(store);

        settingStoreButtons(store);

    }

    private void settingStoreButtons(Store store) {
        phoneStore = (TextView) findViewById(R.id.buttonPhoneText);
        phoneStore.setText("8095521650"); //TODO get the phone from store
//        phoneStore.setText(store.getPhone());

        webStore = (TextView) findViewById(R.id.buttonWebsiteText);
        webStore.setText("www.losgamers.com");
//        webStore.setText(store.getUrlWebsite());

        fbStore = (TextView) findViewById(R.id.buttonFacebookText);
        fbStore.setText("Losgamerspuntocom");
        fbStore.setText(store.getUrlFacebook());
    }

    private void settingCardsStore(Store store) {
        ImageView photoStoreDetails = (ImageView) findViewById(R.id.photoStoreDetails);
        TextView titleStore = (TextView) findViewById(R.id.titleStoreDetails);
        TextView detailsStore = (TextView) findViewById(R.id.descriptionTextStore);
        TextView textSchedule = (TextView) findViewById(R.id.scheduleStore);
        TextView timeSchedule = (TextView) findViewById(R.id.scheduleStoreTime);

        titleStore.setText(store.getName());
//        detailsStore.setText(store.getDetails());
        photoStoreDetails.setImageResource(R.drawable.store_example);

        textSchedule.setText(store.getHoursOpen());
        timeSchedule.setText(store.getDaysOpen());



    }

    public void buttonCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phoneStore.getText().toString()));
        startActivity(intent);
    }

    public void buttonWebsite(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://"+webStore.getText().toString()));
        startActivity(intent);
    }

    public void buttonFacebook(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(fbStore.getText().toString()));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_store_details, menu);
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
