package com.example.bifam.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PlaceOrder extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        spinner = (Spinner) findViewById(R.id.spinner2);
        String[] categories = {"Vegetables e.g. Spinach and Greens", "Fruits e.g. Mangoes and Oranges", "Animals/Products e.g. Milk", "Legumes e.g. Cassava and Potatoes", "Cereal e.g. Maize", "Fish", "Others"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories);
        spinner.setAdapter(adapter);
    }
}
