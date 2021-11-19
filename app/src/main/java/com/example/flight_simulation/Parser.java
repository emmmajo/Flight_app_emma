package com.example.flight_simulation;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.example.flight_simulation.Model;

public class Parser {

    // TAG is used in logging, to help trace where output comes from
    private static final String TAG = "Parser";

    public static List<Model> getResults(String json) {

        List<Model> modelList = new ArrayList<>();


        try {
            JSONArray response = new JSONArray(json);

            for(int i=0; i < response.length(); i++){
                JSONObject flight = response.getJSONObject(i);
                Model model = new Model();
                model.setFlightNum(flight.getString("flightNumber"));
                model.setDeparture(flight.getString("origAirport"));
                modelList.add(model);
            }



        } catch (JSONException e) {
            Log.e(TAG, "getMatches: error parsing JSON", e);
        }


        return modelList;
    }

}
