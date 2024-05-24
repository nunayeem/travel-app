package com.gaazee.travelapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainDashboardActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    LinearLayout house, profile, apartment, villa, iceland, banglore;
    String[] location = {"Bangladesh", "USA", "India"};
    ImageView noti;
    RecyclerView recyclerView, nearby_section;
    int[] pic = {R.drawable.house_1, R.drawable.house_2, R.drawable.house_3};

    String[] nearby_city = {"Dhaka", "London", "Dubai"};
    int[] nearby_pic = {R.drawable.house_1, R.drawable.house_2, R.drawable.house_3};
    String[] appartment_text = {"House", "Apartment", "Villa"};
    int[] rating_score = {4,5,3};
    int[] price_text = {500, 400, 350};
    int[] bed_text = {2,3,1};
    int[] bath_text = {1,2,3};
    String[] address_text = {"Mirpur-1", "Dhanmondi", "Sylhet"};
    RecommendAdapter recommendAdapter;
    NearbyAdapter nearbyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.location);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainDashboardActivity.this, android.R.layout.simple_spinner_item, location);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(MainDashboardActivity.this);

        house = findViewById(R.id.house_btn);
        apartment = findViewById(R.id.apartment_btn);
        villa = findViewById(R.id.villa_btn);
        banglore = findViewById(R.id.banglore_btn);
        iceland = findViewById(R.id.iceland_btn);

        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDashboardActivity.this, HouseActivity.class);
                startActivity(intent);
            }
        });

        apartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDashboardActivity.this, ApartmentActivity.class);
                startActivity(intent);
            }
        });

        villa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDashboardActivity.this, VillaActivity.class);
                startActivity(intent);
            }
        });

        iceland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDashboardActivity.this, IcelandActivity.class);
                startActivity(intent);
            }
        });

        banglore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDashboardActivity.this, BangloreActivity.class);
                startActivity(intent);
            }
        });

        noti = findViewById(R.id.notification_btn);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainDashboardActivity.this, NotificationActivity.class);
                startActivity(i);
            }
        });

        profile = findViewById(R.id.profile_btn);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDashboardActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recomanded_section);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
       LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
       recyclerView.setLayoutManager(linearLayoutManager1);


        recommendAdapter = new RecommendAdapter(this,location, pic);
        recyclerView.setAdapter(recommendAdapter);


//        Near By Section
        nearby_section = findViewById(R.id.nearby_section);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        nearby_section.setLayoutManager(linearLayoutManager2);
        nearbyAdapter = new NearbyAdapter(this, nearby_city, nearby_pic, appartment_text, rating_score, price_text, bed_text, bath_text, address_text);
        nearby_section.setAdapter(nearbyAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "You have clicked: "+location[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setMessage("Do you want quit?")
                .setCancelable(false)
                .setTitle("Quit App")
                .show();
    }
}