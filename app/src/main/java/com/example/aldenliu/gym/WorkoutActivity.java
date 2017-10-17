package com.example.aldenliu.gym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.aldenliu.gym.Adapters.WorkoutListAdapter;
import com.example.aldenliu.gym.Objects.Exercise;
import com.example.aldenliu.gym.Objects.Workout;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class WorkoutActivity extends AppCompatActivity {
    private ListView listView;
    private WorkoutListAdapter workoutListAdapter;
    private Button finishWorkoutButton;
    private ArrayList<Exercise> listOfExercises;
    private Workout currentWorkout;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Intent intent = getIntent();
        Bundle extras  = intent.getExtras();
        currentWorkout = (Workout) extras.get("Workout");
        listOfExercises = currentWorkout.getExerciseArrayList();

        listView = (ListView) findViewById(R.id.workoutListView);
        workoutListAdapter = new WorkoutListAdapter(this, listOfExercises);
        listView.setAdapter(workoutListAdapter);

        finishWorkoutButton = (Button) findViewById(R.id.finishWorkoutButton);
    }

    // For each Exercise in the Workout, we want to save the progress they made
    public void FinishWorkout(View view) {
        // TODO: Create a dialog asking user if they are sure they are donezo.
        for (int i = 0; i < listView.getCount(); i ++) {
            View v = listView.getChildAt(i);
            Spinner s = (Spinner) v.findViewById(R.id.spinner);
            listOfExercises.get(i).setAmountDone((int) s.getSelectedItem());
        }

        storeData();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void storeData() {
        db.collection("test").document(currentWorkout.getDate().toString())
                .set(currentWorkout)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("Testing123", "Got it Boppers");
                    }
                });
    }
}
