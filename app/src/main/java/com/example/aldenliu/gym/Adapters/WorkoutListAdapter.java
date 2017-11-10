package com.example.aldenliu.gym.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.aldenliu.gym.Objects.Exercise;
import com.example.aldenliu.gym.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AldenLiu on 10/8/2017.
 */

public class WorkoutListAdapter extends ArrayAdapter<Exercise> {
    private ArrayList<Exercise> exerciseList;
    private LayoutInflater inflater;

    public WorkoutListAdapter(@NonNull Context context, ArrayList<Exercise> values) {
        super(context, R.layout.layout_workout_listviewelement, values);
        this.exerciseList = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.layout_workout_listviewelement, parent, false);
        }
        Exercise thisOne = exerciseList.get(position);
        ((TextView) convertView.findViewById(R.id.exerciseInfo)).setText(thisOne.toString());

        setSpinner(convertView, thisOne);

        return convertView;
    }

    private void setSpinner(View convertView, Exercise thisOne) {
        final Spinner spinner = convertView.findViewById(R.id.spinner);
        TextView spinnerText = convertView.findViewById(R.id.spinnerText);
        final SeekBar seekBar = convertView.findViewById(R.id.ratingBar);

        seekBar.setMax(thisOne.getSets());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= thisOne.getSets(); i ++) {
            list.add(i);
        }
        ArrayAdapter<Integer> spinnerAdapter = new ArrayAdapter<Integer>(getContext(), android.R.layout.simple_spinner_item, list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int sel = (int) spinner.getSelectedItem();
                seekBar.setProgress(sel);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                spinner.setSelection(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        spinnerText.setText(" / " + thisOne.getSets() + " Sets");
    }
}
