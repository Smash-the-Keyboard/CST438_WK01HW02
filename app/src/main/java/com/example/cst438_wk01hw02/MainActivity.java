package com.example.cst438_wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_ACTIVITY = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextUsername = findViewById(R.id.username);
        EditText editTextPassword = findViewById(R.id.password);

        Log.d(MAIN_ACTIVITY, "Started MainActivity");

        // Reset incorrect username message
        editTextUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    Log.d(MAIN_ACTIVITY, "Clicked on username field!");
                    editTextUsername.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    ((TextView)findViewById(R.id.incorrect_username_message)).setText("");
                }
            }
        });

        // Reset incorrect password message
        editTextPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    Log.d(MAIN_ACTIVITY, "Clicked on password field!");
                    editTextPassword.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    ((TextView)findViewById(R.id.incorrect_password_message)).setText("");
                }
            }
        });

        // Button to Log In
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get credentials
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                // Validate credentials
                if (username.equals("din_djarin") && password.equals("baby_yoda_ftw")) {
                    // Login successful
                    Intent intent = ListPostsActivity.getIntent(getApplicationContext());
                    intent.putExtra("user_id", 1);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
                if (!username.equals("din_djarin")) {
                    // Login failed - incorrect username
                    editTextUsername.setBackgroundColor(Color.parseColor("#FCD1D1"));
                    ((TextView)findViewById(R.id.incorrect_username_message)).setText("Incorrect Username");
                }
                if (!password.equals("baby_yoda_ftw")) {
                    // Login failed - incorrect password
                    editTextPassword.setBackgroundColor(Color.parseColor("#FCD1D1"));
                    ((TextView)findViewById(R.id.incorrect_password_message)).setText("Incorrect Password");
                }
            }
        });
    }
}