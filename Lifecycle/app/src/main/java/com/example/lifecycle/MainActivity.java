package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button testButton=findViewById(R.id.text_button);
        if (testButton != null)
            testButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Click Listener", "Button CLicked");
                }
            });


        Log.d("Lifecycle", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Lifecycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Lifecycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Lifecycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Lifecycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Lifecycle", "onDestroy");
    }
}
