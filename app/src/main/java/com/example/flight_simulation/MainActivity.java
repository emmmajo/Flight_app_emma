/*
    November 3rd, 2021 version 1.0
    Title: Flight Simulation App
    Description: This app is designed to take date departure and return inputs as well as
    location inputs and scrape flight travel sights to make it easier to pick a flight that best
    accommodates the user. then the user can book the pick the suitable flight an be dropped on
    that website to book their flight.
    Design + Blueprint:
    1.0 MainActivity(inputs: outputs:)
        Welcome button, onclick initiate input flight data activity
    1.1 Flight_Data_Activity(Inputs:Departure_date, Return_date, Departure Location, Destination Location,
        Passengers, Outputs:)
    1.1.1 Profile (inputs: Name, picture outputs:)
    1.1.2 Flight_Results(Inputs: Departure, Return, Departure Location, Destination Location,
        Passengers, Output: Matches)
    1.1.2.1 Flight_Staging(Inputs: Outputs:) display more info for flights
    *** Corey 1.2 Settings (Drawer bar with profile pic) (input: Picture Output:)
        IPO:
        Inputs:                   Process:           Outputs:
        Departure Date                                Matches
        Departure Location
        Return Date
        Arrival Location
        Passengers
        Name
        Picture(image)
                    Change Log:
    Date:           Author:              Description:
    Nov 3 2021      Kallista             Created begging stages of app. MainActivity 1.0
                                         Created instance 1.1 Flight_Data_Activity, for beginning stages of user input
                                         Created instance 1.1.1 Profile for future profile page
                                         Created instance 1.1.2 Flight_Results for future display of flight results
    Nov 4 2021      Kallista             Created initial date time buttons for 1.1 departure and return
                                         Need to add input validation so return date isn't in the past of the departure
 */



package com.example.flight_simulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //on Welcome Button click start instance of 1.1 Flight_Data_Activity
    public void FlightDataActivity(View view) {
        Intent i = new Intent(this, FlightDataActivity.class);
        startActivity(i);
    }
}