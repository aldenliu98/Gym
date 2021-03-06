package com.example.aldenliu.gym.Objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by AldenLiu on 9/6/2017.
 */

public class Workout implements Serializable {
    private String name;
    private ArrayList<Exercise> exerciseArrayList;
    private Date date;
    private static int defaultNumber = 1;

    public Workout(String name) {
        this.date = Calendar.getInstance().getTime();
        exerciseArrayList = new ArrayList<>();
        if (name == null) {
            name = "Workout " + defaultNumber;
            defaultNumber += 1;
        }
        this.name = name;
    }

    public Workout(Date date, String name, ArrayList<Exercise> exerciseArrayList) {
        this.date = date;
        this.name = name;
        this.exerciseArrayList = exerciseArrayList;
    }

    public Workout() {}

    public void addExercise(Exercise e) {
        exerciseArrayList.add(e);
    }

    public ArrayList<Exercise> getExerciseArrayList() {
        return exerciseArrayList;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public void updateExercises() {
        for (Exercise e : exerciseArrayList) {
            e.update();
        }
    }
}
