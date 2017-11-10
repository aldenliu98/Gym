package com.example.aldenliu.gym.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.aldenliu.gym.R;

import java.util.ArrayList;

/**
 * Created by AldenLiu on 9/6/2017.
 */

public class NewWorkoutListAdapter extends ArrayAdapter<Integer> {
    private final Context context;
    private final ArrayList<Integer> values;

    public NewWorkoutListAdapter(Context context, ArrayList<Integer> values) {
        super(context, R.layout.layout_newworkout_scrollviewelement, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.layout_newworkout_scrollviewelement, parent, false);
        }
        return convertView;
    }
}
