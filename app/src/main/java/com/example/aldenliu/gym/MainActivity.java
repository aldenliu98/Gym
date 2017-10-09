package com.example.aldenliu.gym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.aldenliu.gym.Objects.Workout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<Workout> workoutArrayList;

    private FloatingActionButton plusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutArrayList = new ArrayList<>();

        mListView = (ListView) findViewById(R.id.listView);
        plusButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        if (!plusButton.isEnabled()) {
            plusButton.setEnabled(true);
        }
    }

    public void StartNewWorkout(View view) {
        // Start a new Activity for a new workout
        Intent i = new Intent(MainActivity.this, NewWorkout.class);
        startActivity(i);
    }
}
