package com.example.travelbuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView register = findViewById(R.id.register);

        AppCompatButton login = findViewById(R.id.button);


        register.setOnClickListener(v -> {

            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
            finish();

        });

        login.setOnClickListener(v -> {

            Intent intent = new Intent(LoginActivity.this,QuestionairActivity.class);
            startActivity(intent);
            finish();

        });
    }
}