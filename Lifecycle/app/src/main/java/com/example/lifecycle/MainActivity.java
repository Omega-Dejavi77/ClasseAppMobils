package com.example.lifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_ID = 1234; //any value

    private EditText nameText;
    private Button sendButton;
    private TextView resultContent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.person_name);
        sendButton = findViewById(R.id.send_button);
        resultContent = findViewById(R.id.result_content);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowName.class);
                String personNameString = nameText.getText().toString();
                intent.putExtra("personNameId", personNameString);
                //startActivity(intent);
                startActivityForResult(intent, REQUEST_ID);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ID){
            if (resultCode == RESULT_OK){
                resultContent.setText("Result OK: " + data.getStringExtra("result"));
            } else {
                resultContent.setText("Result Cancel: " + data.getStringExtra("result"));
            }
        }
    }
}
