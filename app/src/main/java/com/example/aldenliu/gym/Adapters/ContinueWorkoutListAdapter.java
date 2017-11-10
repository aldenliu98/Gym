package com.example.aldenliu.gym.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aldenliu.gym.R;

import java.util.ArrayList;

/**
 * Created by AldenLiu on 10/25/2017.
 */

public class ContinueWorkoutListAdapter extends ArrayAdapter<String> {
    private ArrayList<String> values;
    private LayoutInflater inflater;

    public ContinueWorkoutListAdapter(@NonNull Context context, ArrayList<String> values) {
        super(context, R.layout.layout_continueworkout_listviewelement, values);
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.layout_continueworkout_listviewelement, parent, false);
        }
        String[] temp = values.get(position).split("\n");
        ((TextView) convertView.findViewById(R.id.workoutName)).setText(temp[0]);
        ((TextView) convertView.findViewById(R.id.workoutDate)).setText(temp[1]);

        return convertView;
    }
}
