package com.example.aldenliu.gym.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aldenliu.gym.Adapters.NewWorkoutListAdapter;
import com.example.aldenliu.gym.Objects.Exercise;
import com.example.aldenliu.gym.Objects.Workout;
import com.example.aldenliu.gym.R;
import com.example.aldenliu.gym.WorkoutActivity;

import java.util.ArrayList;

/**
 * Created by AldenLiu on 9/7/2017.
 */

public class NewWorkoutFragment extends Fragment {
    private LayoutInflater mLayoutInflater;
    private ListView mListView;
    private Button addExerciseButton;
    private Button doneButton;
    private ArrayList<Integer> mIntegerArray;
    private NewWorkoutListAdapter adapter;

    private static final int INTEGER_ARRAY_INDEX = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mLayoutInflater = inflater;
        return inflater.inflate(R.layout.fragment_newworkout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mListView = (ListView) getView().findViewById(R.id.newWorkoutListView);
        addExerciseButton = (Button) getView().findViewById(R.id.addExerciseButton);
        doneButton = (Button) getView().findViewById(R.id.doneButton);

        mIntegerArray = new ArrayList<>();
        mIntegerArray.add(INTEGER_ARRAY_INDEX);
        adapter = new NewWorkoutListAdapter(getContext(), mIntegerArray);
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
                Workout thisWorkout = new Workout();

                for (int i = 0; i < mIntegerArray.size(); i ++) {
                    View childView = mListView.getChildAt(i);

                    EditText nameEditText = childView.findViewById(R.id.exerciseName);
                    if (checkEmpty(nameEditText)) {
                        Toast.makeText(getContext(), "Please enter an Exercise Name", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String exerciseName = nameEditText.getText().toString();

                    EditText setsEditText = childView.findViewById(R.id.exerciseSets);
                    if (checkEmpty(setsEditText)) {
                        Toast.makeText(getContext(), "Please enter number of Sets", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String exerciseSets = setsEditText.getText().toString();

                    EditText repsEditText = childView.findViewById(R.id.exerciseReps);
                    if (checkEmpty(repsEditText)) {
                        Toast.makeText(getContext(), "Please enter number of Reps", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String exerciseReps = repsEditText.getText().toString();

                    EditText weightEditText = childView.findViewById(R.id.exerciseWeight);
                    if (checkEmpty(weightEditText)) {
                        Toast.makeText(getContext(), "Please enter a Weight", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String exerciseWeight = weightEditText.getText().toString();

                    Exercise e = new Exercise(exerciseName, Integer.parseInt(exerciseWeight), Integer.parseInt(exerciseSets), Integer.parseInt(exerciseReps));
                    thisWorkout.addExercise(e);
                }

                Intent intent = new Intent(getActivity(), WorkoutActivity.class);
                intent.putExtra("Workout", thisWorkout);
                startActivity(intent);
            }
        });
    }

    private boolean checkEmpty(EditText e) {
        return (e.getText().toString().trim().length() == 0);
    }
}
