package com.example.aldenliu.gym.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aldenliu.gym.Objects.Exercise;
import com.example.aldenliu.gym.R;

import java.util.ArrayList;

/**
 * Created by AldenLiu on 10/8/2017.
 */

public class WorkoutListAdapter extends ArrayAdapter<Exercise> {
    private ArrayList<Exercise> exerciseList;
    private LayoutInflater inflater;

    public WorkoutListAdapter(@NonNull Context context, ArrayList<Exercise> values) {
        super(context, R.layout.activity_workout_listviewelement, values);
        this.exerciseList = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_workout_listviewelement, parent, false);
        }
        Exercise thisOne = exerciseList.get(position);
        ((TextView) convertView.findViewById(R.id.exerciseInfo)).setText(thisOne.toString());
        return convertView;
    }
}
