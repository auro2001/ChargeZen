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

public class plugActivity extends AppCompatActivity {

    private TextView plugtxt;
    public ProgressDialog progressDialog;
    public int i=0;
    private String status[] = {"Yes","No"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plug);


        progressDialog = new ProgressDialog(this);

        plugtxt= findViewById(R.id.tempstat);
        Button but = findViewById(R.id.updatetemp);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(plugActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                Random rndm = new Random();
                int i = rndm.nextInt(status.length);

                final ProgressDialog dialog = ProgressDialog.show(plugActivity.this, "Update", "Please Wait while your data is updating", true);
                dialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                }, 1000);

                plugtxt.setText(status[i]+"");
            }
        });
    }
}