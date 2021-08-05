package com.example.bluetoothlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.cardview.widget.CardView;
public class trail extends AppCompatActivity {

    CardView heartCard = findViewById(R.id.heartCard);
    CardView tempCard = findViewById(R.id.tempCard);
    CardView phcard = findViewById(R.id.phcard);
    CardView myelocard =findViewById(R.id.myelocard);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail);


    }
}