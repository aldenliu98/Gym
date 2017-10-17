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
    private int amountDone;

    public Exercise(String name, int weight, int sets, int reps) {
        this.name = name;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
    }

    public Exercise() {}

    public int getSets() {return sets;}

    public String getName() {return name;}

    public int getWeight() {return weight;}

    public int getReps() {return reps;}

    public int getAmountDone() {return amountDone;}

    public void setAmountDone(int a) {
        amountDone = a;
    }

    public String toString() {
        String output = new String();
        output += "Exercise name: " + name + "\n" +
                "Exercise weight: " + weight + "\n" +
                "Exercise sets: " + sets + " sets" + "\n" +
                "Exercise reps: " + reps + " reps";
        return output;
    }
}
