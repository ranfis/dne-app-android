package com.eem.apps.enelmall.api.model;

import android.util.Log;

import com.eem.apps.enelmall.StartActivity;
import com.eem.apps.enelmall.api.DataApiCall;

public class OffersBatch extends DataApiCall {

    protected void onPostExecute(String result) {
        Log.d("OffersBatch","onPostExecute()");
        StartActivity.goToOffers(result);
    }
}
