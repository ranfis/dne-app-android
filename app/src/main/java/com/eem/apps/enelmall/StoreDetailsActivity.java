package com.eem.apps.enelmall;

import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.eem.apps.enelmall.model.Store;
import com.eem.apps.enelmall.model.api.OffersApi;


public class StoreDetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);

        Store store = OffersApi.getStore();
        setTitle(store.getName());

        settingCardsStore(store);

    }

    private void settingCardsStore(Store store) {
        ImageView photoStoreDetails = (ImageView) findViewById(R.id.photoStoreDetails);
        TextView titleStore = (TextView) findViewById(R.id.titleStoreDetails);

        titleStore.setText(store.getName());
        photoStoreDetails.setImageResource(R.drawable.store_example);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_store_details, menu);
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
