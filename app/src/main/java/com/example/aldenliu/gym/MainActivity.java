package com.example.aldenliu.gym;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aldenliu.gym.Adapters.ContinueWorkoutListAdapter;
import com.example.aldenliu.gym.Objects.Workout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<Workout> workoutArrayList;

    private FloatingActionButton plusButton;
    private boolean expanded = false;

    private LinearLayout fabContinueWorkout;
    private LinearLayout fabNewWorkout;
    private TextView mainTitle;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutArrayList = new ArrayList<>();

        fabContinueWorkout = (LinearLayout) findViewById(R.id.layoutFabEdit);
        fabNewWorkout = (LinearLayout) findViewById(R.id.layoutFabNewWorkout);
        mainTitle = (TextView) findViewById(R.id.mainTitle);

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

    //TODO: Populate ListView with latest workouts, add some style and a custom adapter, add behavior when user clicks
    public void ContinueOldWorkout(View view) {
        mainTitle.setText(R.string.workout_history);
        if (mListView.getAdapter() == null) {
            db.collection("test")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                ArrayList<String> temp = new ArrayList<>();
                                for (DocumentSnapshot document : task.getResult()) {
                                    Log.d("Hello", document.getId() + " => " + document.getData());
                                        temp.add(document.getData().get("name").toString() + "\n" + document.getData().get("date").toString());
                                }
                                ContinueWorkoutListAdapter cwa = new ContinueWorkoutListAdapter(MainActivity.this, temp);
                                mListView.setAdapter(cwa);
                            } else {
                                Log.d("Hello", "Error getting documents: " + task.getException());
                            }
                        }
                    });
        }
    }

    public void StartNewWorkout(View view) {
        // Start a new Activity for a new workout
        Intent i = new Intent(MainActivity.this, NewWorkout.class);
        startActivity(i);
    }

    private void closeSubMenu() {
        if (mainTitle.getText() == getString(R.string.workout_history)) {
            mainTitle.setText(R.string.main_title);
            mListView.setAdapter(null);
        }
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

    //TODO: Create a method for continuing a workout.
}
