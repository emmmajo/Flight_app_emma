package com.example.flight_simulation;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import com.example.flight_simulation.Model;
import com.example.flight_simulation.Parser;

import Networks.FlightSearchApi;


public class SearchAsyncTask extends AsyncTask<String, Void, List<Model>> {

    private searchListener listener;
    public void setListener(searchListener listener) {
        this.listener = listener;
    }


    @Override
    protected List<Model> doInBackground(String... params) {

        String searchTerm = params[0];
        Log.d("SearchAsyncTask", "doInBackground: " + searchTerm);

        //String depLocation = "SMF", depDate = "2021-12-27", destination = "NYC", tripType = "ROUND_TRIP";
        //int passengers = 1;
        String depLocation = params[0], depDate = "2021-12-27", destination = "NYC", tripType = "ROUND_TRIP";
        int passengers = 1;

        String responseJson = FlightSearchApi.searchFlights(depLocation,depDate,destination,tripType,passengers);


        // success? :)
        if (responseJson != null) {
            return Parser.getResults(responseJson);

        }
        // no success :(
        return null;
    }

    @Override
    protected void onPostExecute(List<Model> flightModels) {
        // happens after doInBackground, and runs on main thread
        super.onPostExecute(flightModels);
        Log.d("SearchAsyncTask", "onPostExecute: " + flightModels);

    }


    public interface searchListener {

    }


}


