package com.example.bluetoothlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class register extends AppCompatActivity {
    EditText registerFullName, registerEmail, registerPassword ,registerConfirmPassword;
    Button registerBtn,gotoLogin;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerFullName = findViewById(R.id.registerFullName);
        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        registerConfirmPassword = findViewById(R.id.registerConfirmPassword);
        registerBtn = findViewById(R.id.registerBtn);
        gotoLogin = findViewById(R.id.gotoLogin);

        fAuth= FirebaseAuth.getInstance();

        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
                finish();
            }
        });


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //extract the data from the form

                String fullName = registerFullName.getText().toString();
                String emailAddress =registerEmail.getText().toString();
                String password = registerPassword.getText().toString();
                String ConfirmPassword = registerConfirmPassword.getText().toString();

                if(fullName.isEmpty()){
                    registerFullName.setError("Full Name is required");
                    return;
                }

                if(emailAddress.isEmpty()){
                    registerEmail.setError("Email Address is required");
                    return;
                }

                if(password.isEmpty()){
                    registerPassword.setError("Password is required");
                    return;
                }

                if(ConfirmPassword.isEmpty()){
                    registerConfirmPassword.setError("Confirm Password is required");
                    return;
                }

                if(!password.equals(ConfirmPassword)){
                    registerConfirmPassword.setError("Password Do not match");
                    return;
                }
                //data is validated
                //register the user through firebase

                Toast.makeText(register.this, "Data Validated", Toast.LENGTH_SHORT).show();

                fAuth.createUserWithEmailAndPassword(emailAddress,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //send user to next page
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}