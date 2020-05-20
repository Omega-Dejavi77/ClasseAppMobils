package com.example.glideexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView lion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lion = findViewById(R.id.imageView);
        loadImageViewByGlide();
    }

    private void loadImageView() {
        lion.setImageResource(R.drawable.lion);
    }

    private void loadImageViewByGlide() {
        Glide.with(this)
            .load(R.drawable.lion)
            .into(lion);
    }
}
