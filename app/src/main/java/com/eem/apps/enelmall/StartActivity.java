package com.eem.apps.enelmall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.graphics.Typeface;
import android.widget.TextView;
import android.location.Location;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;

public class StartActivity extends Activity implements
        ConnectionCallbacks, OnConnectionFailedListener {

    protected static final String TAG = "basic-location-sample";

    /**
     * Provides the entry point to Google Play services.
     */
    protected GoogleApiClient mGoogleApiClient;

    /**
     * Represents a geographical location.
     */
    protected Location mLastLocation;

    static StartActivity self;
    public final static String OFFERS = "com.eem.apps.enelmall.OFFERS";

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
        //String urlString = "http://104.236.25.160:9000/api/ofertas";
        //new OffersBatch().execute(urlString);

        buildGoogleApiClient();
    }

    /**
     * Builds a GoogleApiClient. Uses the addApi() method to request the LocationServices API.
     */
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    /**
     * Runs when a GoogleApiClient object successfully connects.
     */
    @Override
    public void onConnected(Bundle connectionHint) {
        // Provides a simple way of getting a device's location and is well suited for
        // applications that do not require a fine-grained location and that do not need location
        // updates. Gets the best and most recent location currently available, which may be null
        // in rare cases when a location is not available.
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
           String lat = String.valueOf(mLastLocation.getLatitude());
            String lon = String.valueOf(mLastLocation.getLatitude());
            Toast.makeText(this, "lat: "+lat, Toast.LENGTH_LONG).show();
            Toast.makeText(this, "lon: "+lon, Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "No Location, Sorry :(", Toast.LENGTH_LONG).show(); // TODO: Prompt user to enable location
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // Refer to the javadoc for ConnectionResult to see what error codes might be returned in
        // onConnectionFailed.
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }


    @Override
    public void onConnectionSuspended(int cause) {
        // The connection to Google Play services was lost for some reason. We call connect() to
        // attempt to re-establish the connection.
        Log.i(TAG, "Connection suspended");
        mGoogleApiClient.connect();
    }

    public static void goToOffers(String offersJson){
        Intent offers = new Intent(self,OffersActivity.class);
        offers.putExtra(OFFERS, offersJson);
        self.startActivity(offers);
    }
}
