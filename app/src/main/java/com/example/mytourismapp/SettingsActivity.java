package com.example.mytourismapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ImageButton backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void onEditProfileClick(View view) {
        Toast.makeText(this, "Change Profile Picture clicked", Toast.LENGTH_SHORT).show();
    }

    // Method for Change Email click
    public void onChangeEmailClick(View view) {
        Toast.makeText(this, "Change Email clicked", Toast.LENGTH_SHORT).show();
    }

    // Method for Change Phone Number click
    public void onChangePhoneNumberClick(View view) {
        Toast.makeText(this, "Change Phone Number clicked", Toast.LENGTH_SHORT).show();
    }

    // Method for Notification Settings click
    public void onNotificationSettingsClick(View view) {
        Toast.makeText(this, "Notification Settings clicked", Toast.LENGTH_SHORT).show();
    }

    // Method for Change Password click
    public void onChangePasswordClick(View view) {
        Toast.makeText(this, "Change Password clicked", Toast.LENGTH_SHORT).show();
    }

    // Method for Help & Support click
    public void onHelpSupportClick(View view) {
        Toast.makeText(this, "Help & Support clicked", Toast.LENGTH_SHORT).show();
    }
}
