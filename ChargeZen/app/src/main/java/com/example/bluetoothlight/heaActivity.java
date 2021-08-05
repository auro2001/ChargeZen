package com.example.bluetoothlight;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class heaActivity extends AppCompatActivity {

    private TextView heatxt;
    public ProgressDialog progressDialog;
    public int i=0;
    private String status[] = {"Good","Good","Good","Bad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hea);


        progressDialog = new ProgressDialog(this);

        heatxt= findViewById(R.id.heastat);
        Button but = findViewById(R.id.updatehea);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(heaActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                Random rndm = new Random();
                int i = rndm.nextInt(status.length);

                final ProgressDialog dialog = ProgressDialog.show(heaActivity.this, "Update", "Please Wait while your data is updating", true);
                dialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                }, 1000);

                heatxt.setText(status[i]+"");
            }
        });
    }
}