package com.example.travelbuddy;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

    }

    public void openLink(View view) {
        // Define the URL you want to open
        String url = "https://www.16personalities.com/free-personality-test";

        // Create an intent with ACTION_VIEW
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));

        // Verify that there's an activity to handle the intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Start the activity (open the link)
            startActivity(intent);
        } else {
            // If no activity can handle the intent, show an error message
            Toast.makeText(this, "No application found to open the link", Toast.LENGTH_SHORT).show();
        }
    }
}
