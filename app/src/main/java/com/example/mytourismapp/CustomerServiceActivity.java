package com.example.mytourismapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerServiceActivity extends AppCompatActivity {

    private TextView chatSupportTextView;
    private Button feedbackButton;
    private ImageButton backButton;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerservice);

        chatSupportTextView = findViewById(R.id.chatSupport);
        feedbackButton = findViewById(R.id.feedbackButton);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        chatSupportTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomerServiceActivity.this, "Opening chat support...", Toast.LENGTH_SHORT).show();
            }
        });

        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomerServiceActivity.this, "Navigating to feedback form...", Toast.LENGTH_SHORT).show();
            }
        });
        setupContactOptions();
    }

    private void setupContactOptions() {
        LinearLayout phoneSupportTextView = findViewById(R.id.phoneSupport);
        phoneSupportTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:18001234567"));
                startActivity(dialIntent);
            }
        });

        LinearLayout emailSupportTextView = findViewById(R.id.emailSupport);
        emailSupportTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:support@example.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Customer Support Inquiry");
                startActivity(Intent.createChooser(emailIntent, "Send Email"));
            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
