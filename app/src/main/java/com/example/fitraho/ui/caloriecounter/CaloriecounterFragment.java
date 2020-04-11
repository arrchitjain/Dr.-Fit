package com.example.fitraho.ui.caloriecounter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.fitraho.R;

public class CaloriecounterFragment extends Fragment {

    private CaloriecounterViewModel caloriecounterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        caloriecounterViewModel =
                ViewModelProviders.of(this).get(CaloriecounterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_caloriecounter, container, false);
        /*
        final TextView textView = root.findViewById(R.id.text_caloriecounter);
        caloriecounterViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
       */

        final EditText Weight = (EditText) root.findViewById(R.id.calwt);
        final EditText Time = (EditText) root.findViewById(R.id.caltime);
        final ImageButton Cycling = (ImageButton) root.findViewById(R.id.calcycling);
        final ImageButton Walking = (ImageButton) root.findViewById(R.id.calwalking);
        final ImageButton Jogging = (ImageButton) root.findViewById(R.id.caljogging);
        final ImageButton Swimming = (ImageButton) root.findViewById(R.id.calswimming);
        final Button Reset = (Button) root.findViewById(R.id.calreset);
        final TextView Result = (TextView) root.findViewById(R.id.calresult);



            Reset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Weight.setText("");
            Time.setText("");
            Result.setText("");
        }
    });


        Cycling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
z
            }
        });

        Walking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w = Weight.getText().toString();
                String t = Time.getText().toString();
                if(w.isEmpty() || t.isEmpty()){
                    Result.setText("Please Enter Attributes.");
                }
                else{
                    float r1 = Float.parseFloat(w);
                    float r2 = Float.parseFloat(t);
                    float met = (float) 2.3;
                    float ans = r1 * r2 / 60 * met;
                    String cal = String.format("%.2f", ans);

                    Result.setText("You have burnt " + cal + " Calories");
                }

            }
        });

        Jogging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w = Weight.getText().toString();
                String t = Time.getText().toString();
                if(w.isEmpty() || t.isEmpty()){
                    Result.setText("Please Enter Attributes.");
                }
                else{
                    float r1 = Float.parseFloat(w);
                    float r2 = Float.parseFloat(t);
                    float met = (float) 8.0;
                    float ans = r1 * r2 / 60 * met;
                    String cal = String.format("%.2f", ans);

                    Result.setText("You have burnt " + cal + " Calories");
                }
            }
        });

        Swimming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w = Weight.getText().toString();
                String t = Time.getText().toString();
                if(w.isEmpty() || t.isEmpty()){
                    Result.setText("Please Enter Attributes.");
                }
                else{
                    float r1 = Float.parseFloat(w);
                    float r2 = Float.parseFloat(t);
                    float met = (float) 5.8;
                    float ans = r1 * r2 / 60 * met;
                    String cal = String.format("%.2f", ans);

                    Result.setText("You have burnt " + cal + " Calories");
                }

            }
        });







        return root;
    }



}
