package com.example.aldenliu.gym.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aldenliu.gym.R;

/**
 * Created by AldenLiu on 9/7/2017.
 */

public class NewWorkoutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_newworkout, container, false);
    }
    
}
