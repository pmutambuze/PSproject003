package com.example.bifam.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Market extends AppCompatActivity {
Button btn21;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        btn21 = (Button) findViewById(R.id.market);

        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Market.this, MarketPlace.class);
                startActivity(i);
            }
        });
    }
}
