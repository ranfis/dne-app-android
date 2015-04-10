package com.eem.apps.enelmall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.location.Location;
import android.view.Window;
import android.widget.Toast;
import com.eem.apps.enelmall.model.MockOffers;
import com.eem.apps.enelmall.model.api.OffersApi;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;


public class StartActivity extends Activity implements ConnectionCallbacks, OnConnectionFailedListener {
    protected static final String TAG = "[StartActivity]";
    protected GoogleApiClient googleApiClient;
    static StartActivity self;
    public final static String OFFERS = "com.eem.apps.enelmall.OFFERS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate()");
        super.onCreate(savedInstanceState);
        self = this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);
j+
        // Connect to play services for location
        buildGoogleApiClient();
        googleApiClient.connect();
//        OffersBatch.getMockOffers();
    }


    // Builds a GoogleApiClient. Uses the addApi() method to request the LocationServices API.
    protected synchronized void buildGoogleApiClient() {
        Log.d(TAG,"buildGoogleApiClient()");
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (googleApiClient.isConnected()) {
            googleApiClient.disconnect();
        }
    }


    // Runs when a GoogleApiClient object successfully connects.
    @Override
    public void onConnected(Bundle connectionHint) {
        getNearOffers();
    }


    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.d(TAG,"onConnectionFailed()");
        Log.e(TAG, "onConnectionFailed(): ConnectionResult.getErrorCode() = " + result.getErrorCode());
        new OffersApi().execute("mock", MockOffers.getOffers(0)); //TODO: Show error to the user
    }


    @Override
    public void onConnectionSuspended(int cause) {
        Log.d(TAG,"onConnectionSuspended()");
        // The connection to Google Play services was lost for some reason. We call connect() to
        // attempt to re-establish the connection.
        Log.i(TAG, "Connection suspended");
        googleApiClient.connect();
    }


    public static void goToOffers(){
        Log.d(TAG,"goToOffers()");
        Intent offersActivity = new Intent(self,OffersActivity.class);
        self.startActivity(offersActivity);
        self.finish();
    }

    public Location getUserLocation(){
        Log.d(TAG,"getUserLocation()");
        Location userLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (userLocation == null) {
            Log.i(TAG,"userLocation: null");
            Toast.makeText(this, "No Location, Sorry :(", Toast.LENGTH_LONG).show(); // TODO: Prompt user to enable location
        }
        return userLocation;
    }

    public void getNearOffers(){
        Log.d(TAG,"getNearOffers()");
        Location userLocation = getUserLocation();
        String lat = String.valueOf(userLocation.getLatitude());
        String lon = String.valueOf(userLocation.getLongitude());

        Log.i(TAG,"getNearOffers()/lat:"+lat);
        Log.i(TAG,"getNearOffers()/lon:"+lon);
        new OffersApi().execute("mock", MockOffers.getOffers(0)); //TODO: Get offers from api
    }
}
