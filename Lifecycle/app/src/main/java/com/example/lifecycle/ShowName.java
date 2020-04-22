package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShowName extends AppCompatActivity {

    private TextView showName;
    private EditText resultText;
    private Button okButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_name);

        showName = findViewById(R.id.show_name);
        resultText = findViewById(R.id.result_text);
        okButton = findViewById(R.id.button_ok);
        cancelButton = findViewById(R.id.button_cancel);

        Intent intent = getIntent();
        String name = intent.getStringExtra("personNameId");
        showName.setText(name);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentResult(RESULT_OK);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentResult(RESULT_CANCELED);
            }
        });
    }

    private void setContentResult(int result){
        Intent resultIntent = new Intent();
        String text = resultText.getText().toString();
        resultIntent.putExtra("result", text);

        setResult(result, resultIntent);
        finish();
    }
}
