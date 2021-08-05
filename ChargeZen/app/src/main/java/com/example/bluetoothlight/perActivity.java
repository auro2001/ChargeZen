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

public class perActivity extends AppCompatActivity {

    public TextView perctxt;
    public ProgressDialog progressDialog;
    public int i=0;
    public int[] status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per);

        status = new int[]{93,94, 93, 93, 94 , 93, 94, 95, 92};
        progressDialog = new ProgressDialog(this);

        perctxt= findViewById(R.id.tempstat);
        Button but = findViewById(R.id.updatetemp);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(perActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                Random r = new Random();
                int i = r.nextInt(status.length) ;

                final ProgressDialog dialog = ProgressDialog.show(perActivity.this, "Update", "Please Wait while your data is updating", true);
                dialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                }, 1000);

                perctxt.setText(status[i]+"");
            }
        });
    }
}