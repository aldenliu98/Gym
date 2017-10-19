package com.example.aldenliu.gym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.aldenliu.gym.Objects.Workout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<Workout> workoutArrayList;

    private FloatingActionButton plusButton;
    private boolean expanded = false;

    private LinearLayout fabContinueWorkout;
    private LinearLayout fabNewWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutArrayList = new ArrayList<>();

        fabContinueWorkout = (LinearLayout) findViewById(R.id.layoutFabEdit);
        fabNewWorkout = (LinearLayout) findViewById(R.id.layoutFabNewWorkout);

        mListView = (ListView) findViewById(R.id.listView);
        plusButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(expanded) {
                    closeSubMenu();
                } else {
                    openSubMenu();
                }
            }
        });

        closeSubMenu();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (expanded) {
            closeSubMenu();
        }
    }

    public void StartNewWorkout(View view) {
        // Start a new Activity for a new workout
        Intent i = new Intent(MainActivity.this, NewWorkout.class);
        startActivity(i);
    }

    private void closeSubMenu() {
        fabNewWorkout.setVisibility(View.INVISIBLE);
        fabContinueWorkout.setVisibility(View.INVISIBLE);
        plusButton.setImageResource(R.drawable.ic_add_black_24dp);
        expanded = false;
    }

    private void openSubMenu() {
        fabNewWorkout.setVisibility(View.VISIBLE);
        fabContinueWorkout.setVisibility(View.VISIBLE);
        plusButton.setImageResource(R.drawable.ic_close_black_24dp);
        expanded = true;
    }

    //TODO: Create a list of past workouts?
}
