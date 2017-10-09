package com.example.aldenliu.gym.Objects;

import java.io.Serializable;

/**
 * Created by AldenLiu on 9/6/2017.
 */

public class Exercise implements Serializable {
    private String name;
    private int weight;
    private int sets;
    private int reps;

    public Exercise(String name, int weight, int sets, int reps) {
        this.name = name;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
    }

    public String toString() {
        String output = new String();
        output += "Exercise name: " + name + "\n" +
                "Exercise weight: " + weight + "\n" +
                "Exercise sets and reps: " + sets + " sets and " + reps + " reps";
        return output;
    }
}
