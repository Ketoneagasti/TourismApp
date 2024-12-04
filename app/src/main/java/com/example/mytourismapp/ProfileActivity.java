package com.example.mytourismapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView displayName;
    private ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        displayName = findViewById(R.id.displayName);
        profileImage = findViewById(R.id.profileImage);

        // Load user data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.PREFS_NAME, MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "User");
        String profilePicPath = sharedPreferences.getString("profile_picture", "@drawable/profile_icon"); // Default image

        // Set user data to views
        displayName.setText(username);
        int imageResource = getResources().getIdentifier(profilePicPath, "drawable", getPackageName());
        profileImage.setImageResource(imageResource);
    }

    public void goToHistoryActivity(View view) {
        Intent intent = new Intent(ProfileActivity.this, HistoryActivity.class);
        startActivity(intent);
    }

    public void goToCustomerServiceActivity(View view) {
        Intent intent = new Intent(ProfileActivity.this, CustomerServiceActivity.class);
        startActivity(intent);
    }

    public void goToSettingsActivity(View view) {
        Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void goToManagePaymentsActivity(View view) {
        Intent intent = new Intent(ProfileActivity.this, ManagePaymentsActivity.class);
        startActivity(intent);
    }

    public void goToIrctcAccountActivity(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.irctc.co.in/"));
        startActivity(browserIntent);
    }

    public void goToEditProfileActivity(View view) {
        Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
        startActivity(intent);
    }



    // This method will be triggered when the CardView is clicked
    public void onLogoutClick(View view) {
        // Clear user session
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear(); // Clear all saved data
        editor.apply();

        // Navigate back to MainActivity
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
