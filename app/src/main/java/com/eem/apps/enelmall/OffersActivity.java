package com.eem.apps.enelmall;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.eem.apps.enelmall.api.DataApiCall;

import org.json.JSONArray;
import org.json.JSONException;


public class OffersActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("OffersActivity", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        Intent intent = getIntent();
        String offersString = intent.getStringExtra(StartActivity.OFFERS);
        JSONArray offers = (JSONArray)DataApiCall.parseJson(offersString);
        try{
            String desc = offers.getJSONObject(0).getString("desc");
            Toast.makeText(this,desc,Toast.LENGTH_LONG).show();
        }
        catch (JSONException er){
            Log.e("OffersActivity","Bad JSON");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_offers, menu);
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
