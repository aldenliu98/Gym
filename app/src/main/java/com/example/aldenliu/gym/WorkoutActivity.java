package com.example.aldenliu.gym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.aldenliu.gym.Adapters.WorkoutListAdapter;
import com.example.aldenliu.gym.Objects.Exercise;
import com.example.aldenliu.gym.Objects.Workout;

import java.util.ArrayList;

public class WorkoutActivity extends AppCompatActivity {
    private ListView listView;
    private WorkoutListAdapter workoutListAdapter;
    private Button finishWorkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Intent intent = getIntent();
        Bundle extras  = intent.getExtras();
        Workout currentWorkout = (Workout) extras.get("Workout");
        ArrayList<Exercise> listOfExercises = currentWorkout.getExerciseArrayList();

        listView = (ListView) findViewById(R.id.workoutListView);
        workoutListAdapter = new WorkoutListAdapter(this, listOfExercises);
        listView.setAdapter(workoutListAdapter);

        finishWorkoutButton = (Button) findViewById(R.id.finishWorkoutButton);
    }

    public void FinishWorkout(View view) {
        // For each Exercise in the Workout, we want to save the progress they made
    }
}
