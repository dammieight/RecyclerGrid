package com.example.recyclergrid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {
    TextView title;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        title = findViewById(R.id.textView2);
        image = findViewById(R.id.imageView2);
        setTitle(getIntent().getStringExtra("title") + " Activity");

        //getIntent putExtra from onClick method in the RViewAdapter class
        title.setText(getIntent().getStringExtra("title"));

        //The defaultValue is return if the name is empty or null.. it stands just as a placeholder.
        image.setImageResource(getIntent().getIntExtra("image", 101));
    }
}
