package com.example.travelbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.travelbuddy.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MatchingListActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.matchinglist);


        AppCompatButton map = findViewById(R.id.map);
        map.setOnClickListener(v -> {


            Intent intent = new Intent(MatchingListActivity.this, MapActivity.class);
            startActivity(intent);
            finish();
        });
        int[] imageId = {R.drawable.img};

        String[] name = {"testUser"};

        String[] origin = {"Barcelona"};

        String[] personality = {"introvert"};

        String[] contact = {"4076238986"};

        ArrayList<UserInListActivity> userInListActivityArrayList = new ArrayList<>();

        for(int i = 0; i < 6;i++){

            UserInListActivity user = new UserInListActivity(name[0], origin[0], personality[0], contact[0], imageId[0]);
            userInListActivityArrayList.add(user);

        }


    }

}
