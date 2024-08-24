package com.example.appwithspinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Spinner categorySpinner = findViewById(R.id.categorySpinner);
        Spinner productSpinner = findViewById(R.id.productSpinner);

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String[] products = productFactory.getProduct(position);
                ArrayAdapter<String> productAdapter = new ArrayAdapter<>(
                        MainActivity.this, // Use MainActivity as the context
                        android.R.layout.simple_spinner_item, // Default spinner layout
                        products // The array of products
                );
                productAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Set the adapter on the product spinner
                productSpinner.setAdapter(productAdapter);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




    }

    public void orderConfirm(View view) {
        TextView orderConfirmText = findViewById(R.id.orderConfirmationText);
        orderConfirmText.setText(R.string.order_confirmed);
    }
}