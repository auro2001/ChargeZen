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

public class tempActivity extends AppCompatActivity {

    public TextView temptxt;
    public ProgressDialog progressDialog;
    public int i=0;
    public int[] status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        status = new int[]{43,44,43,43,42,43,44,43,44};
        progressDialog = new ProgressDialog(this);

        temptxt= findViewById(R.id.tempstat);
        Button but = findViewById(R.id.updatetemp);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(tempActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                Random r = new Random();
                int i = r.nextInt(status.length) ;

                final ProgressDialog dialog = ProgressDialog.show(tempActivity.this, "Update", "Please Wait while your data is updating", true);
                dialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                }, 1000);

                temptxt.setText(status[i]+"");
            }
        });
    }
}