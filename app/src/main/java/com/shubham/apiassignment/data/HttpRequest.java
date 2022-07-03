package com.shubham.apiassignment.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.shubham.apiassignment.model.Item;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ContentHandler;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpRequest extends AsyncTask<Void, Void, String> {


    private static final String TAG = "httpReq";
    private final Context context;

    public HttpRequest(Context mainActivity) {
        this.context = mainActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: Async task started" );
        Toast.makeText(context, "Async task started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        StringBuffer buffer = new StringBuffer();

        try {
            URL url = new URL("http://crm.technopinch.in/api/app/GetOrderDetailsForSaral?authkey=VNTdzp8a8PHvNQwyqYA3&userlogin_keySaralweb=18210");
            Log.d(TAG, "onCreate: started for request." );

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            InputStream stream = urlConnection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
                Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

            }
        } catch (IOException e) {
            e.printStackTrace();

            Log.d(TAG, "onCreate:  error " + e.getMessage());
        }
            return buffer.toString();

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: Aync Task Completed");
        Toast.makeText(context, " Aync Task Completed", Toast.LENGTH_SHORT).show();
    }
}
