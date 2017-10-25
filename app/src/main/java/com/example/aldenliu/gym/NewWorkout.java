package com.example.aldenliu.gym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aldenliu.gym.Adapters.NewWorkoutListAdapter;
import com.example.aldenliu.gym.Objects.Exercise;
import com.example.aldenliu.gym.Objects.Workout;

import java.util.ArrayList;

public class NewWorkout extends AppCompatActivity {
    private ListView mListView;
    private Button addExerciseButton;
    private Button doneButton;
    private ArrayList<Integer> mIntegerArray;
    private NewWorkoutListAdapter adapter;
    private EditText workoutName;

    private static final int INTEGER_ARRAY_INDEX = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        mListView = (ListView) findViewById(R.id.newWorkoutListView);
        addExerciseButton = (Button) findViewById(R.id.addExerciseButton);
        doneButton = (Button) findViewById(R.id.doneButton);
        workoutName = (EditText) findViewById(R.id.workoutName);

        mIntegerArray = new ArrayList<>();
        mIntegerArray.add(INTEGER_ARRAY_INDEX);
        adapter = new NewWorkoutListAdapter(this, mIntegerArray);
        mListView.setAdapter(adapter);

        addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIntegerArray.add(INTEGER_ARRAY_INDEX);
                adapter.notifyDataSetChanged();
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gets data from the popup and sends it to the MainActivity in the form of a Workout.
                Workout thisWorkout = new Workout(workoutName.getText().toString());

                for (int i = 0; i < mIntegerArray.size(); i ++) {
                    View childView = mListView.getChildAt(i);

                    EditText nameEditText = childView.findViewById(R.id.exerciseName);
                    if (checkEmpty(nameEditText)) {
                        Toast.makeText(NewWorkout.this, "Please enter an Exercise Name", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String exerciseName = nameEditText.getText().toString();

                    EditText setsEditText = childView.findViewById(R.id.exerciseSets);
                    if (checkEmpty(setsEditText)) {
                        Toast.makeText(NewWorkout.this, "Please enter number of Sets", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String exerciseSets = setsEditText.getText().toString();

                    EditText repsEditText = childView.findViewById(R.id.exerciseReps);
                    if (checkEmpty(repsEditText)) {
                        Toast.makeText(NewWorkout.this, "Please enter number of Reps", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String exerciseReps = repsEditText.getText().toString();

                    EditText weightEditText = childView.findViewById(R.id.exerciseWeight);
                    if (checkEmpty(weightEditText)) {
                        Toast.makeText(NewWorkout.this, "Please enter a Weight", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String exerciseWeight = weightEditText.getText().toString();

                    EditText increment = childView.findViewById(R.id.increment);
                    if (checkEmpty(increment)) {
                        Toast.makeText(NewWorkout.this, "Please enter an increment", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String incrementString = increment.getText().toString();

                    Exercise e = new Exercise(exerciseName, Integer.parseInt(exerciseWeight), Integer.parseInt(exerciseSets), Integer.parseInt(exerciseReps), Integer.parseInt(incrementString));
                    thisWorkout.addExercise(e);
                }

                Intent intent = new Intent(NewWorkout.this, WorkoutActivity.class);
                intent.putExtra("Workout", thisWorkout);
                startActivity(intent);
            }
        });
    }

    private boolean checkEmpty(EditText e) {
        return (e.getText().toString().trim().length() == 0);
    }
}
