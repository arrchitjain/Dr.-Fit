package com.example.fitraho.ui.caloriecounter;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
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
        final ImageButton Running = (ImageButton) root.findViewById(R.id.calrunning);
        final ImageButton Swimming = (ImageButton) root.findViewById(R.id.calswimming);
        final ImageButton Aerobics = (ImageButton) root.findViewById(R.id.calaerobics);
        final ImageButton Householdactivities = (ImageButton) root.findViewById(R.id.calhouseholdactivities);
        final ImageButton Skipping = (ImageButton) root.findViewById(R.id.calskipping);
        final ImageButton Yoga = (ImageButton) root.findViewById(R.id.calyoga);
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

                    Result.setText(cal + " Calories burnt");
                }

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
                    float met = (float) 2.9;
                    float ans = r1 * r2 / 60 * met;
                    String cal = String.format("%.2f", ans);

                    Result.setText(cal + " Calories burnt");
                }

            }
        });

        Running.setOnClickListener(new View.OnClickListener() {
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
                    float met = (float) 9.8;
                    float ans = r1 * r2 / 60 * met;
                    String cal = String.format("%.2f", ans);

                    Result.setText(cal + " Calories burnt");
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

                    Result.setText(cal + " Calories burnt");
                }

            }
        });

        Aerobics.setOnClickListener(new View.OnClickListener() {
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
                    float met = (float) 7.3;
                    float ans = r1 * r2 / 60 * met;
                    String cal = String.format("%.2f", ans);

                    Result.setText(cal + " Calories burnt");
                }

            }
        });

        Householdactivities.setOnClickListener(new View.OnClickListener() {
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
                    float met = (float) 3.5;
                    float ans = r1 * r2 / 60 * met;
                    String cal = String.format("%.2f", ans);

                    Result.setText(cal + " Calories burnt");
                }

            }
        });

        Skipping.setOnClickListener(new View.OnClickListener() {
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
                    float met = (float) 12.3;
                    float ans = r1 * r2 / 60 * met;
                    String cal = String.format("%.2f", ans);

                    Result.setText(cal + " Calories burnt");
                }

            }
        });

        Yoga.setOnClickListener(new View.OnClickListener() {
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
                    float met = (float) 3.3;
                    float ans = r1 * r2 / 60 * met;
                    String cal = String.format("%.2f", ans);

                    Result.setText(cal + " Calories burnt");
                }

            }
        });




        return root;
    }



}
