package com.example.appwithspinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
    }

    public void submitDetails(View view) {
        // Retrieve input from EditText fields
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText contactNumberEditText = findViewById(R.id.contactNumberEditText);
        EditText addressEditText = findViewById(R.id.addressEditText);

        String name = nameEditText.getText().toString();
        String contactNumber = contactNumberEditText.getText().toString();
        String address = addressEditText.getText().toString();

        // Create an Intent to send data to the next activity (OrderConfirmationActivity)
        Intent intent = new Intent(CustomerDetailsActivity.this, OrderConfirmationActivity.class);
        intent.putExtra("customerName", name);
        intent.putExtra("contactNumber", contactNumber);
        intent.putExtra("address", address);

        // Pass the selected category and product from MainActivity if needed
        String selectedCategory = getIntent().getStringExtra("selectedCategory");
        String selectedProduct = getIntent().getStringExtra("selectedProduct");
        intent.putExtra("selectedCategory", selectedCategory);
        intent.putExtra("selectedProduct", selectedProduct);

        // Start OrderConfirmationActivity
        startActivity(intent);
    }
}
