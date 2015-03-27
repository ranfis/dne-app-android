package com.eem.apps.enelmall.model;

import android.util.Log;
import com.eem.apps.enelmall.StartActivity;
import com.eem.apps.enelmall.model.api.DataApiCall;

public class OffersBatch extends DataApiCall {
    protected static final String TAG = "[OffersBatch]";

    protected void onPostExecute(String result) {
        Log.d(TAG,"onPostExecute()");
        StartActivity.goToOffers(result);
    }
}
