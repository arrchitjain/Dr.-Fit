package com.example.fitraho;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_calorieCounter)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        firebaseAuth = FirebaseAuth.getInstance();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuLogout:{
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(MainActivity.this, login.class));
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculate(View view) {

        EditText weight = (EditText) findViewById(R.id.bmiwieght);
        EditText height = (EditText) findViewById(R.id.bmiheight);
        TextView answer = (TextView) findViewById(R.id.bmianswer);

        if (weight.getText().toString().isEmpty() || height.getText().toString().isEmpty()) {
            answer.setText("      Enter Attributes");
        } else {
            double weightd = Double.parseDouble(weight.getText().toString());
            double heightd = Double.parseDouble(height.getText().toString());
            double BMI = (weightd) / (heightd * heightd);
            String BMIs = String.format("%.2f", BMI);
            if (BMI>=1 && BMI<18.5) {
                answer.setText("Your BMI value is " + BMIs + "\nAnd you are 'UNDERWEIGHT'");
            }
            else if (BMI>=18.5 && BMI<25.0){
                answer.setText("Your BMI value is " + BMIs + "\nAnd you are 'HEALTHY'");
            }
            else if (BMI>=25.0 && BMI<30.0){
                answer.setText("Your BMI value is " + BMIs + "\nAnd you are 'OVERWEIGHT'");
            }
            else if (BMI>=30.0){
                answer.setText("Your BMI value is " + BMIs + "\nAnd you are 'OBESE'");
            }
            else {
                answer.setText("Entries are invalid or out of range.");
            }
            }

        }
    public void clearall(View view) {

        EditText weight = (EditText) findViewById(R.id.bmiwieght);
        EditText height = (EditText) findViewById(R.id.bmiheight);
        TextView answer = (TextView) findViewById(R.id.bmianswer);

        weight.setText("");
        height.setText("");
        answer.setText("");
    }

}