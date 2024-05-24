package com.gaazee.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NearbyDetailsActivity extends AppCompatActivity {
    ImageView my_image, back_btn;
    TextView type, score, address, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nearby_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        Hooks
        my_image = findViewById(R.id.nearby_image);
        type = findViewById(R.id.type);
        back_btn = findViewById(R.id.back_btn);
        score = findViewById(R.id.score);
        price = findViewById(R.id.price);
        address = findViewById(R.id.address);


        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        my_image.setImageResource(intent.getIntExtra("image", 0));
        type.setText(intent.getStringExtra("type"));
        score.setText(""+intent.getIntExtra("score", 0));
        price.setText(""+intent.getIntExtra("price", 0));
        address.setText(intent.getStringExtra("address"));
    }
}