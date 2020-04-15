package com.example.fitraho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    int attempts=5;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText Username = (EditText) findViewById(R.id.username);
        final EditText Password = (EditText) findViewById(R.id.password);
        final Button btn = (Button) findViewById(R.id.button);
        final TextView Register = (TextView) findViewById(R.id.registerlink);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null){
            finish();
            startActivity(new Intent(login.this, MainActivity.class));
        }

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, register.class));
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Username.getText().toString().isEmpty() || Password.getText().toString().isEmpty()){
                    Toast.makeText(login.this, "Enter Attributes", Toast.LENGTH_SHORT).show();
                }
                else{
                firebaseAuth.signInWithEmailAndPassword(Username.getText().toString(), Password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            //Toast.makeText(login.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                            checkEmailVerification();
                        }
                        else{
                            attempts--;
                            Toast.makeText(login.this, "Login Failed\nNo. of attempts remaining " + attempts, Toast.LENGTH_LONG).show();
                            if (attempts==0){
                                btn.setEnabled(false);
                            }

                        }
                    }
                });

                }

            }
        });



    }

    private void checkEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        Boolean emailFlag = firebaseUser.isEmailVerified();

        if (emailFlag){
            finish();
            startActivity(new Intent(login.this, MainActivity.class));
        }
        else{
            Toast.makeText(login.this, "Verify your email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }




}
