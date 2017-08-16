package com.example.bifam.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MarketPlace extends AppCompatActivity {
Button btn;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);

        btn = (Button) findViewById(R.id.placeorder);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MarketPlace.this, PlaceOrder.class);
                startActivity(i);
            }
        });

        btn2 = (Button) findViewById(R.id.search);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketPlace.this, Search.class);
                startActivity(intent);
            }
        });

        btn3 = (Button) findViewById(R.id.avmarkets);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MarketPlace.this, AvMarkets.class);
                startActivity(intent1);
            }
        });

        btn4 = (Button) findViewById(R.id.farmerstrading);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MarketPlace.this, FarmersTrading.class);
                startActivity(i);
            }
        });

        btn5 = (Button) findViewById(R.id.comments);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MarketPlace.this, GetInTouch.class);
                startActivity(i);
            }
        });
    }
}
