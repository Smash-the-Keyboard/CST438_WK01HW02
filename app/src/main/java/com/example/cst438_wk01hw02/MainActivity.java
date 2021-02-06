package com.example.cst438_wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button to Log In
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get credentials
                String username = ((EditText)findViewById(R.id.username)).getText().toString();
                String password = ((EditText)findViewById(R.id.password)).getText().toString();
                // Validate credentials
                if (username.equals("din_djarin") && password.equals("baby_yoda_ftw")) {
                    // Login successful
                    Intent intent = ListPostsActivity.getIntent(getApplicationContext());
                    startActivity(intent);
                }
                else {
                    // Login failed
                    ((TextView)findViewById(R.id.incorrect_password_message)).setText("Incorrect Password");
                }
            }
        });
    }
}