package com.example.aldenliu.gym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.aldenliu.gym.Fragments.NewWorkoutFragment;
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

        Intent intent = getIntent();
        Bundle extras  = intent.getExtras();
        if (extras != null) {
            Log.d("Hello", "Got the extra!");
        }

        workoutArrayList = new ArrayList<>();

        mListView = (ListView) findViewById(R.id.listView);
        plusButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        if (!plusButton.isEnabled()) {
            plusButton.setEnabled(true);
        }
    }

    public void StartNewWorkout(View view) {
        // Use a fragment to prompt user to enter a new Workout, which will be updated on the ListView
        plusButton.setEnabled(false);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, new NewWorkoutFragment());
        ft.commit();
    }
}
