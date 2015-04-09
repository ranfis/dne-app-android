package com.eem.apps.enelmall.model.api;

import android.os.AsyncTask;
import android.util.Log;
import com.eem.apps.enelmall.util.Helpers;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;
import java.io.InputStream;

public class DataApiCall extends AsyncTask<String, String, String> {

    protected static final String TAG = "[DataApiCall]";

    @Override
    protected String doInBackground(String... params) {
        Log.d(TAG, "doInBackground()");
        if(params[0] == "mock"){
            return params[1];
        }
        return getFromApi(params);
    }

    protected String getFromApi(String... params) {
        Log.d(TAG, "getFromApi()");
        String urlString=params[0];
        InputStream inputStream = null;
        String result = "";
        try {
            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(urlString));
            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null) {
                result = Helpers.convertInputStreamToString(inputStream);
            }
            else {
                Log.w(TAG, "getFromApi()/httpResponse:Empty result.");
                result = "{}";
            }

        } catch (IOException e) {
            Log.e(TAG, "getFromApi()/IOException:e.getLocalizedMessage() = "+e.getLocalizedMessage());
        }

        return result;
    }
}