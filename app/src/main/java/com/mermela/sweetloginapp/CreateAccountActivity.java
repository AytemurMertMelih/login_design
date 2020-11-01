package com.mermela.sweetloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText createUsername,createPassword,createPassword2;
    private Button buttonToMain;
    private TextView haveAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        createUsername = findViewById(R.id.createUsername);
        createPassword = findViewById(R.id.createPassword);
        createPassword2 = findViewById(R.id.createPassword2);
        haveAccount = findViewById(R.id.haveAccount);
        buttonToMain = findViewById(R.id.buttonToMenu);

        buttonToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ps1,ps2;
                ps1 = createPassword.getText().toString();
                ps2 = createPassword2.getText().toString();


                if (createUsername.length() == 0) {
                    createUsername.setError("Enter a username!");
                }
                else if (createPassword.length() == 0 || createPassword2.length() == 0) {
                    createPassword.setError("Enter a password");
                    createPassword2.setError("Enter a password");
                }
                else if (!ps1.equals(ps2)) {
                    Toast.makeText(getApplicationContext(), "Passwords should be same!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(CreateAccountActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });

        haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccountActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



}