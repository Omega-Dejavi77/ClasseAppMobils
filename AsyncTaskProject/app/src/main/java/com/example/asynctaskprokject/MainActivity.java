package com.example.asynctaskprokject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements HttpHelper.HttpHelperResponseHandler {

    private TextView jsonContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonContent = findViewById(R.id.json_content);

        HttpHelper task = new HttpHelper();
        task.delegate = this;
        String url = "https://jsonplaceholder.typicode.com/users/";
        task.execute(url);
    }

    @Override
    public void setHttpHelperResponse(String result) {
        //jsonContent.setText(result);
        jsonContent.setText(getAllNames(result));
        jsonContent.setText(getFirstUser(result));
    }

    private String getAllNames(String rawJson) {
        try {
            String result = "";
            JSONArray users = new JSONArray(rawJson);
            for (int i = 0; i < users.length(); i++) {
                JSONObject currentUser = users.getJSONObject(i);
                if (currentUser.has("name"))
                    result += currentUser.getString("name") + "\n";
            }
            return result;
        } catch (Exception e) {
            Log.d("SwA", "Error parsing names" + e.getMessage());
        }

        return "";
    }

    private String getFirstUser(String rawJson) {
        try {
            String result = "";
            JSONArray users = new JSONArray(rawJson);
            return users.getJSONObject(0).toString();

        } catch (Exception e) {
            Log.d("SwA", "Error parsing names" + e.getMessage());
        }

        return "";
    }
}
