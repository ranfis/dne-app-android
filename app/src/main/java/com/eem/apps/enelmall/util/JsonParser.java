package com.eem.apps.enelmall.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonParser {

    protected static final String TAG = "[JsonParser]";

    public static Object parse(String json){
        Log.d(TAG, "parse()");
        try{
            Object jsonObj = null;
            switch (json.charAt(0)){
                case '[':
                    jsonObj = new JSONArray(json);
                    Log.v(TAG, "parse()/Received a JSON Array.");
                    break;
                case '{':
                    jsonObj = new JSONObject(json);
                    Log.v(TAG, "parse()/Received a JSON Object.");
                    break;
            }
            return jsonObj;
        }
        catch(JSONException err){
            Log.e(TAG, "parse()/JSONException:Bad JSON");
            return null;
        }
    }
}
