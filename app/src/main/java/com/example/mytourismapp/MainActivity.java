package com.example.mytourismapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;

    // Constants for SharedPreferences
    public static final String PREFS_NAME = "UserPrefs";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Your login layout

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        // Check if user is already logged in
        checkLoginStatus();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString(); // Assuming you want to validate the password too

                // Validate username and password (add your validation logic)
                if (!username.isEmpty() && !password.isEmpty()) {
                    // Save login status in SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(KEY_IS_LOGGED_IN, true);
                    editor.putString(KEY_USERNAME, username);
                    editor.apply(); // Save changes

                    // Start DashboardActivity and pass the username
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    intent.putExtra("USERNAME", username);
                    startActivity(intent);
                    finish(); // Optional: finish the login activity
                } else {
                    // Handle empty username/password input (optional)
                    if (username.isEmpty()) {
                        usernameEditText.setError("Please enter a username");
                    }
                    if (password.isEmpty()) {
                        passwordEditText.setError("Please enter a password");
                    }
                }
            }
        });

        // Register button click logic (optional)
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open registration activity
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkLoginStatus() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);

        if (isLoggedIn) {
            // User is already logged in, redirect to DashboardActivity
            String username = sharedPreferences.getString(KEY_USERNAME, "");
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            intent.putExtra("USERNAME", username);
            startActivity(intent);
            finish(); // Close the MainActivity
        }
    }
}
