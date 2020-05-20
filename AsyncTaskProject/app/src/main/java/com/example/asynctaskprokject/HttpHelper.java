package com.example.asynctaskprokject;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper extends AsyncTask<String, String, String> {

    public HttpHelperResponseHandler delegate = null;

    @Override
    protected String doInBackground(String... urls) {
        String result = "";
        for (String currentUrl : urls) {
            try{
                URL url = new URL(currentUrl);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                int responseCode = urlConnection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    try{
                        InputStream is = urlConnection.getInputStream();
                        result = readBody(is);

                    } finally {
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e){
                Log.d("SwA", "Error --> Load content from" + currentUrl + "=" + e.getMessage());
            }
        }
        return result;
    }

    private String readBody(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder str = new StringBuilder();

        String line = null;
        while ((line = reader.readLine()) != null) {
            str.append(line);
        }
        is.close();
        return str.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        if (delegate != null) {
            delegate.setHttpHelperResponse(result);
        }
    }

    public interface HttpHelperResponseHandler {
        void setHttpHelperResponse(String result);
    }
}
