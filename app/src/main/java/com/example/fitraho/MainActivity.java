package com.example.fitraho;

import android.content.DialogInterface;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;


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
            case R.id.menuDelAccount:{

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Are you sure?");
                dialog.setMessage("Deleting this account will result in completely removing your account from the system and you won't be able " +
                        "to access your account on this app again?");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
                        
                        progressBar.setVisibility(View.VISIBLE);
                        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                        firebaseUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()){
                                    startActivity(new Intent(MainActivity.this, login.class));
                                    Toast.makeText(MainActivity.this,"Account deleted", Toast.LENGTH_SHORT);

                                }
                                else {
                                    Toast.makeText(MainActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT);
                                }
                            }
                        });

                    }
                });

                dialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                });

                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                //case delete account
            }


            case R.id.menuUserinfo:{
                startActivity(new Intent(MainActivity.this, user_info.class));
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