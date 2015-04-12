package com.eem.apps.enelmall.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class Helpers {
    protected static final String TAG = "[Helpers]";

    public static String convertInputStreamToString(InputStream inputStream) throws IOException {
        Log.d(TAG, "convertInputStreamToString()");
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null) {
            result += line;
        }
        inputStream.close();
        return result;
    }

    public static Boolean createDialogError(Context context, String title, String msg, String okButton) {
        final Boolean[] result = {false};
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(msg);
        alertDialog.setButton(okButton, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                result[0] = true;
            }
        });

        alertDialog.show();

        return result[0];
    }
}
