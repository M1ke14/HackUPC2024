package com.example.travelbuddy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<UserInListActivity> {

    public ListAdapter(Context context, ArrayList<UserInListActivity> userInListActivityArrayList){

        super(context, R.layout.list_item, userInListActivityArrayList);

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

          UserInListActivity user = getItem(position);

          if (convertView == null){

              convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

          }

        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView userName = convertView.findViewById(R.id.userName);
        TextView origin = convertView.findViewById(R.id.origin);
        TextView personality = convertView.findViewById(R.id.personality);

        imageView.setImageResource(user.imageId);
        userName.setText(user.name);
        origin.setText(user.country);
        personality.setText(user.personality);


        return super.getView(position, convertView, parent);

    }

}
