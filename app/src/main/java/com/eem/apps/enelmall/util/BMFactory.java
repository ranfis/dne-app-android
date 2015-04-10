package com.eem.apps.enelmall.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import com.eem.apps.enelmall.OffersActivity;
import com.eem.apps.enelmall.model.Offer;
import com.eem.apps.enelmall.model.api.OffersApi;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BMFactory extends AsyncTask<Offer, Integer, String> {

    protected static final String TAG = "[JsonParser]";

    @Override
    protected String doInBackground(Offer... offers) {
        Log.d(TAG, "doInBackground()");
        try{
            for (int i = 0; i <  offers.length; i++) {
                String u = (String) offers[i].getImage();
                System.out.println(u);
                URL url = new URL( u );
                Bitmap bitmap = getImageBitmapFromUrl( url );
                OffersApi.getAll().get(i).setImage(bitmap);
                System.out.println(bitmap);
            }
        }
        catch (MalformedURLException ex){
            Log.e(TAG,"doInBackground()/Bad URL");
        }
        return "o";
    }

    protected void onPostExecute(String result) {
        Log.d(TAG, "onPostExecute()");
        OffersActivity.updateImages();
    }


    private Bitmap getImageBitmapFromUrl(URL url){
        Log.d(TAG, "getImageBitmapFromUrl()");
        Bitmap bm = null;
        try {
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            if(conn.getResponseCode() != 200)
            {
                Log.v(TAG, "getImageBitmapFromUrl()/Bad response");
                return bm;
            }
            conn.connect();
            InputStream is = conn.getInputStream();

            BufferedInputStream bis = new BufferedInputStream(is);
            try
            {
                bm = BitmapFactory.decodeStream(bis);
            }
            catch(OutOfMemoryError ex)
            {
                Log.v(TAG, "getImageBitmapFromUrl()/OutOfMemoryError");
                bm = null;
            }
            bis.close();
            is.close();
        } catch (Exception e) {
            Log.v(TAG, "getImageBitmapFromUrl()/Exception:"+e);
        }

        return bm;
    }

}
