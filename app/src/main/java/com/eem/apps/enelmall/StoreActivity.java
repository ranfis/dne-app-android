package com.eem.apps.enelmall;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.eem.apps.enelmall.model.Store;
import com.eem.apps.enelmall.model.api.OffersApi;

import java.util.ArrayList;


public class StoreActivity extends ActionBarActivity {

    private ArrayList<Store> stores;
    private ListView mStoreList;
    private StoreAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        stores = new ArrayList<>();
        stores.add(new Store(1, "O6 Store","Lunes a Viernes\nSabado y Domingo\nDías feriados","8:00 AM - 5:00 PM\n9:00 AM - 1:00 PM\n9:00 AM - 3:00 PM"));
        stores.add(new Store(2, "Electro Lama","Lunes a Viernes\nSabado y Domingo\nDías feriados","8:00 AM - 5:00 PM\n9:00 AM - 1:00 PM\n9:00 AM - 3:00 PM"));

        sAdapter = new StoreAdapter(StoreActivity.this, stores);
        mStoreList = (ListView) findViewById(R.id.mListStores);
        mStoreList.setAdapter(sAdapter);
        mStoreList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(OffersActivity.this, "Posicion: " + position, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(StoreActivity.this, StoreDetailsActivity.class);
                OffersApi.setStore(stores.get(position));
                startActivity(i);
            }
        });
    }


}
