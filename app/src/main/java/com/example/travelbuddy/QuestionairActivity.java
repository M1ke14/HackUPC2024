package com.example.travelbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;


public class QuestionairActivity extends AppCompatActivity {

    private EditText arrivalDate;
    private EditText leavingDate;
    private EditText arrivalTime;
    private EditText leavingTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionair);
        arrivalDate = findViewById(R.id.ArrivingDate);
        arrivalDate.setOnClickListener(v -> showDatePickerDialog(v,1));
        leavingDate = findViewById(R.id.LeavingDate);
        leavingDate.setOnClickListener(view -> showDatePickerDialog(view,2));
        arrivalTime = findViewById(R.id.ArrivingTime);
        arrivalTime.setOnClickListener(v -> showTimePickerDialog(v,1));
        leavingTime = findViewById(R.id.LeavingTime);
        leavingTime.setOnClickListener(view -> showTimePickerDialog(view,2));

    }

    public void showTimePickerDialog(View view, int i) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (TimePicker timePicker, int selectedHour, int selectedMinute) -> {
                    // On time selected, update EditText with selected time
                    String time = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute);
                    if (i == 1)
                        arrivalTime.setText(time);
                    else
                        leavingTime.setText(time);
                }, hour, minute, true);

        timePickerDialog.show();
    }

    public void showDatePickerDialog(View view, int i) {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                        if(i==1)
                            arrivalDate.setText(date);
                        else
                            leavingDate.setText(date);
                    }
                }, year, month, day);



        datePickerDialog.show();
    }
}