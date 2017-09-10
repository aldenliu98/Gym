package com.example.aldenliu.gym.Objects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by AldenLiu on 9/6/2017.
 */

public class Workout {
    private ArrayList<Exercise> exerciseArrayList;
    private Date date;

    public Workout() {
        this.date = Calendar.getInstance().getTime();
        exerciseArrayList = new ArrayList<>();
    }

    public void addExercise(Exercise e) {
        exerciseArrayList.add(e);
    }
}
