package com.example.travelbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.travelbuddy.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MatchingListActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.img};

        String[] name = {"testUser"};

        String[] origin = {"Barcelona"};

        String[] personality = {"introvert"};

        String[] contact = {"4076238986"};

        ArrayList<UserInListActivity> userInListActivityArrayList = new ArrayList<>();

        for(int i = 0; i < imageId.length;i++){

            UserInListActivity user = new UserInListActivity(name[i], origin[i], personality[i], contact[i], imageId[1]);
            userInListActivityArrayList.add(user);

        }

        ListAdapter listAdapter = new ListAdapter(MatchingListActivity.this, userInListActivityArrayList);
        binding.list
        RelativeLayout user = findViewById(R.id.user);
        user.setClickable(true);
        user.setOnClickListener(v -> {

            Intent i = new Intent(MatchingListActivity.this, UserInListActivity.class);
            i.putExtra("name", name[position]);

        });

    }

}
