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

public class register extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText Rename = (EditText) findViewById(R.id.rename);
        final EditText Reemail = (EditText) findViewById(R.id.reemail);
        final EditText Repassword = (EditText) findViewById(R.id.repassword);
        Button Refinish = (Button) findViewById(R.id.refinish);
        TextView Reback = (TextView) findViewById(R.id.rebacklogin);

        firebaseAuth = FirebaseAuth.getInstance();

        Refinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( Rename.getText().toString().isEmpty() || Reemail.getText().toString().isEmpty() || Repassword.getText().toString().isEmpty() ){
                    Toast.makeText(register.this, "Enter Attributes", Toast.LENGTH_SHORT).show();
                }
                else{
                    //upload database

                    firebaseAuth.createUserWithEmailAndPassword(Reemail.getText().toString().trim(), Repassword.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
//                                Toast.makeText(register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(register.this, login.class));
                                sendEmailVerification();
                            }
                            else{
                                Toast.makeText(register.this, "Registered Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                }
            }
        });

        Reback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this, login.class));
            }
        });


    }


    private void sendEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(register.this, "Successfully registered\nVerification mail sent!", Toast.LENGTH_LONG).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(register.this, login.class));
                    }
                    else{
                        Toast.makeText(register.this, "Verification mail hasn't been sent!", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

    }




}
