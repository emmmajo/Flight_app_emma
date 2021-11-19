package com.example.flight_simulation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;


public class FlightDataActivity extends AppCompatActivity {

    private DatePickerDialog departureDateDialog;
    private DatePickerDialog returnDateDialog;
    public Button departureButton;
    public Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_data);
        initDatePicker();
        departureButton =findViewById(R.id.departure_date);
        returnButton = findViewById(R.id.return_date);
        departureButton.setText(getTodaysDate());
        returnButton.setText(getTodaysDate());

    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDataString(day, month, year);
    }

    public void initDatePicker(){
        DatePickerDialog.OnDateSetListener departureListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = makeDataString(day, month, year);
                departureButton.setText(date);

            }
        };
        DatePickerDialog.OnDateSetListener returnListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = makeDataString(day, month, year);
                returnButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        departureDateDialog = new DatePickerDialog(this,  style, departureListener, year, month, day);
        departureDateDialog.getDatePicker().setMinDate(cal.getTimeInMillis());
        returnDateDialog = new DatePickerDialog(this, style, returnListener, year, month, day);
        returnDateDialog.getDatePicker().setMinDate(cal.getTimeInMillis());

    }

    private String makeDataString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";
        return "Fault";
    }

    public void openDepartureDate(View view) {
        departureDateDialog.show();

    }
    public void openReturnDate(View view) {
        returnDateDialog.show();

    }

    public void profile (View view){
        Intent i = new Intent(this,Profile.class);
        startActivity(i);
    }

    public void flightResults(View view){
        Intent i = new Intent(this, FlightResults.class);
        startActivity(i);
    }
}