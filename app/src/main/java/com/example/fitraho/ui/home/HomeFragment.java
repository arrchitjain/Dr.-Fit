package com.example.fitraho.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.fitraho.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    EditText weight;
    EditText height;
    double weightd;
    double heightd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //View view =  inflater.inflate(R.layout.nav_host_fragment, container, false);
        EditText weight = (EditText) root.findViewById(R.id.bmiwieght);
        EditText height = (EditText) root.findViewById(R.id.bmiheight);

        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;

    }

    /*
    public void calculate(View view) {
        //EditText weight = (EditText) findViewById(R.id.weight);
        //EditText height = (EditText) findViewById(R.id.height);


        if (weight.getText().toString().isEmpty() || height.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Enter Attributes!", Toast.LENGTH_SHORT).show();
        } else {
            double weightd = Double.parseDouble(weight.getText().toString());
            double heightd = Double.parseDouble(height.getText().toString());


            double BMI = (weightd) / (heightd * heightd);

            @SuppressLint("DefaultLocale") String BMIs = String.format("%.2f", BMI);

            Toast.makeText(getActivity(), "Your BMI is " + BMIs, Toast.LENGTH_SHORT).show();
        }

    }
    */

}
