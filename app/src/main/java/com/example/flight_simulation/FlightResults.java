package com.example.flight_simulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;



public class FlightResults extends AppCompatActivity {

    private Button recipeSearchButton;
    private EditText searchEditText;
    private TextView recipeTitle;
    private TextView recipeLikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_results);

        recipeSearchButton = findViewById(R.id.recipe_search_button);
        searchEditText = findViewById(R.id.search_edit_text);
        recipeTitle = findViewById(R.id.recipe_title);
        recipeLikes = findViewById(R.id.recipe_likes);

        recipeSearchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SearchAsyncTask task = new SearchAsyncTask();
                //add a recipe listener to the task
                task.setListener(new SearchAsyncTask.searchListener() {
                    @SuppressLint("SetTextI18n")
                   // @Override
                    public void onRecipeSearchCallback(List<Model> models) {
                        //show the first response on the screen

                        //for some reason models is null during runtime.
                        Model first = models.get(0);
                        //TextView variable names below are examples as these variables have not yet been
                        //created when you start the lab. They should correspond to the id attribute
                        //assigned in the activity_main.xml
                        recipeTitle.setText("Flight Number: "+ first.getFlightNum());
                        recipeLikes.setText("From: " + first.getDeparture());
                    }
                });
                String searchTerm = searchEditText.getText().toString();
                task.execute(searchTerm);
            }
        });
    }
}