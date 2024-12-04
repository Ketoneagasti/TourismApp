package com.example.mytourismapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView welcomeText;
    private BottomNavigationView bottomNavigationView;

    // HorizontalScrollView references for city categories
    private HorizontalScrollView allCitiesScroll;
    private HorizontalScrollView recommendedCitiesScroll;
    private HorizontalScrollView popularCitiesScroll;
    private HorizontalScrollView cheapestCitiesScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        profileImage = findViewById(R.id.profileImage);
        welcomeText = findViewById(R.id.welcomeText);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Get the username from the intent
        String username = getIntent().getStringExtra("USERNAME");

        // Load profile image using Glide (ensure you have the correct URL)
        String profileImageUrl = "@drawable/my_pic.png"; // Update with actual URL or resource
        Glide.with(this)
                .load(profileImageUrl)
                .placeholder(R.drawable.profile_icon) // Optional placeholder image
                .into(profileImage);

        // Set the welcome message with the username
        if (username != null) {
            welcomeText.setText("Welcome back, " + username + "!");
        } else {
            welcomeText.setText("Welcome back!");
        }

        // Initialize HorizontalScrollView elements
        allCitiesScroll = findViewById(R.id.allCitiesScroll);
        recommendedCitiesScroll = findViewById(R.id.recommendedCitiesScroll);
        popularCitiesScroll = findViewById(R.id.popularCitiesScroll);
        cheapestCitiesScroll = findViewById(R.id.cheapestCitiesScroll);

        // Initially show all cities
        showAllCities();

        // Set up button click listeners
        Button allButton = findViewById(R.id.all_button);
        Button recommendationsButton = findViewById(R.id.recommendations_button);
        Button popularButton = findViewById(R.id.popular_button);
        Button cheapestButton = findViewById(R.id.cheapest_button);

        allButton.setOnClickListener(v -> showAllCities());
        recommendationsButton.setOnClickListener(v -> showRecommendedCities());
        popularButton.setOnClickListener(v -> showPopularCities());
        cheapestButton.setOnClickListener(v -> showCheapestCities());


        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.history) {
                Intent intent = new Intent(DashboardActivity.this, HistoryActivity.class);
                startActivity(intent);
                return true;
            }
            else if (item.getItemId() == R.id.profile) {
                Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }

    private void showAllCities() {
        allCitiesScroll.setVisibility(View.VISIBLE);
        recommendedCitiesScroll.setVisibility(View.GONE);
        popularCitiesScroll.setVisibility(View.GONE);
        cheapestCitiesScroll.setVisibility(View.GONE);
    }

    private void showRecommendedCities() {
        allCitiesScroll.setVisibility(View.GONE);
        recommendedCitiesScroll.setVisibility(View.VISIBLE);
        popularCitiesScroll.setVisibility(View.GONE);
        cheapestCitiesScroll.setVisibility(View.GONE);
    }

    private void showPopularCities() {
        allCitiesScroll.setVisibility(View.GONE);
        recommendedCitiesScroll.setVisibility(View.GONE);
        popularCitiesScroll.setVisibility(View.VISIBLE);
        cheapestCitiesScroll.setVisibility(View.GONE);
    }

    private void showCheapestCities() {
        allCitiesScroll.setVisibility(View.GONE);
        recommendedCitiesScroll.setVisibility(View.GONE);
        popularCitiesScroll.setVisibility(View.GONE);
        cheapestCitiesScroll.setVisibility(View.VISIBLE);
    }
}
