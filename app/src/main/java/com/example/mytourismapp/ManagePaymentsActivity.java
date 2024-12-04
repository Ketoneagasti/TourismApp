package com.example.mytourismapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ManagePaymentsActivity extends AppCompatActivity {

    private LinearLayout creditCardContent, debitCardContent, netBankingContent, upiContent;
    private ImageView creditCardToggleIcon, debitCardToggleIcon, netBankingToggleIcon, upiToggleIcon;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managepayments);

        creditCardContent = findViewById(R.id.creditCardContent);
        debitCardContent = findViewById(R.id.debitCardContent);
        netBankingContent = findViewById(R.id.netBankingContent);
        upiContent = findViewById(R.id.upiContent);

        // Initialize the toggle icons
        creditCardToggleIcon = findViewById(R.id.creditCardToggleIcon);
        debitCardToggleIcon = findViewById(R.id.debitCardToggleIcon);
        netBankingToggleIcon = findViewById(R.id.netBankingToggleIcon);
        upiToggleIcon = findViewById(R.id.upiToggleIcon);

        // Set onClickListeners for each toggle icon
        creditCardToggleIcon.setOnClickListener(view -> toggleSection(creditCardContent, creditCardToggleIcon));
        debitCardToggleIcon.setOnClickListener(view -> toggleSection(debitCardContent, debitCardToggleIcon));
        netBankingToggleIcon.setOnClickListener(view -> toggleSection(netBankingContent, netBankingToggleIcon));
        upiToggleIcon.setOnClickListener(view -> toggleSection(upiContent, upiToggleIcon));

        ImageButton backButton = findViewById(R.id.backButton);

        Button verifyUpiButton = findViewById(R.id.verifyUpiButton);
        Button addUpiButton = findViewById(R.id.addUpiButton);
        EditText upiInputField = findViewById(R.id.upiInputField);
        TextView verificationStatus = findViewById(R.id.verificationStatus);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        verifyUpiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upiInput = upiInputField.getText().toString();
                // Implement your verification logic here
                if (verifyUpi(upiInput)) { // Placeholder for actual verification logic
                    verificationStatus.setText("Verification Successful!");
                    verificationStatus.setVisibility(View.VISIBLE);
                    addUpiButton.setVisibility(View.VISIBLE);
                } else {
                    verificationStatus.setText("Verification Failed! Please try again.");
                    verificationStatus.setVisibility(View.VISIBLE);
                    addUpiButton.setVisibility(View.GONE);
                }
            }
        });

        addUpiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic to add UPI ID to your data store
                String upiId = upiInputField.getText().toString();
                addUpiId(upiId); // Placeholder for adding the UPI ID
            }
        });
    }

    private void toggleSection(LinearLayout contentLayout, ImageView toggleIcon) {
        // Hide all sections first to make only one section visible at a time
        hideAllSections();

        // If the selected section is currently hidden, show it and change the icon
        if (contentLayout.getVisibility() == View.GONE) {
            contentLayout.setVisibility(View.VISIBLE);
            toggleIcon.setImageResource(R.drawable.arrow_down);
        } else {
            // Otherwise, hide it and reset the icon to the original state
            contentLayout.setVisibility(View.GONE);
            toggleIcon.setImageResource(R.drawable.arrow_up);
        }
    }

    private void hideAllSections() {
        // Hide all sections and reset toggle icons
        creditCardContent.setVisibility(View.GONE);
        creditCardToggleIcon.setImageResource(R.drawable.arrow_up);

        debitCardContent.setVisibility(View.GONE);
        debitCardToggleIcon.setImageResource(R.drawable.arrow_up);

        netBankingContent.setVisibility(View.GONE);
        netBankingToggleIcon.setImageResource(R.drawable.arrow_up);

        upiContent.setVisibility(View.GONE);
        upiToggleIcon.setImageResource(R.drawable.arrow_up);
    }

    private boolean verifyUpi(String upiId) {
        return !upiId.isEmpty();
    }

    private void addUpiId(String upiId) {
        finish();
    }

}
