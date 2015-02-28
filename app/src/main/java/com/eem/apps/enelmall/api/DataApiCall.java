package com.eem.apps.enelmall.api;

import android.os.AsyncTask;
import android.util.Log;

import com.eem.apps.enelmall.StartActivity;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataApiCall extends AsyncTask<String, String, String> {

    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null) {
            result += line;
        }
        inputStream.close();
        return result;
    }

    @Override
    protected String doInBackground(String... params) {
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
                result = convertInputStreamToString(inputStream);
            }
            else {
                Log.w("httpResponse","Empty result.");
                result = "{}";
            }

        } catch (Exception e) {
            Log.e("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    protected void onPostExecute(String result) {
        StartActivity.toOffers(result);
    }

    public static Object parseJson(String json){
        try{
            Object jsonObj = null;
            switch (json.charAt(0)){
                case '[':
                    jsonObj = new JSONArray(json);
                    Log.d("DataApiCall","Received a JSON Array.");
                    break;
                case '{':
                    jsonObj = new JSONObject(json);
                    Log.d("DataApiCall","Received a JSON Object.");
                    break;
            }
            return jsonObj;
        }
        catch(JSONException err){
            Log.e("JSONException", "Bad JSON");
            return null;
        }
    }
}