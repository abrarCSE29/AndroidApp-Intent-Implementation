package com.example.appwithspinner;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_confirmation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the Intent that started this activity
        String selectedCategory = getIntent().getStringExtra("selectedCategory");
        String selectedProduct = getIntent().getStringExtra("selectedProduct");
        String customerName = getIntent().getStringExtra("customerName");
        String contactNumber = getIntent().getStringExtra("contactNumber");
        String address = getIntent().getStringExtra("address");

        // Display the received data
        TextView confirmationText = findViewById(R.id.confirmationText);
        confirmationText.setText("Category: " + selectedCategory +
                "\n\nProduct: " + selectedProduct +
                "\n\nName: " + customerName +
                "\n\nContact: " + contactNumber +
                "\n\nAddress: " + address);
    }
}