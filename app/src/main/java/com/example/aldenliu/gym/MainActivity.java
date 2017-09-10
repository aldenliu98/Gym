package com.example.aldenliu.gym;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.aldenliu.gym.Fragments.NewWorkoutFragment;
import com.example.aldenliu.gym.Objects.Workout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<Workout> workoutArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutArrayList = new ArrayList<>();

        mListView = (ListView) findViewById(R.id.listView);
    }

    public void StartNewWorkout(View view) {
        // Use a fragment to prompt user to enter a new Workout, which will be updated on the ListView
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, new NewWorkoutFragment());
        ft.commit();
    }
}
