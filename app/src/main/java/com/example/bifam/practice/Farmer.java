package com.example.bifam.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Farmer extends AppCompatActivity {
    Button newbtn;
    Button newbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);

        newbtn = (Button) findViewById(R.id.button2);
        newbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Farmer.this,PostPro.class);
                startActivity(myintent);
            }
        });

        newbtn2 = (Button) findViewById(R.id.button);
        newbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Farmer.this,FarmerRegister.class);
                startActivity(myintent);
            }
        });
    }
}
