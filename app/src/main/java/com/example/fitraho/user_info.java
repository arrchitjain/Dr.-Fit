package com.example.fitraho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class user_info extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TextView name = (TextView) findViewById(R.id.txname);
        TextView email = (TextView) findViewById(R.id.txemail);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();


        String useremail = firebaseUser.getEmail();
        String username = firebaseUser.getUid();

        email.setText("E-mail id : " + useremail);
        name.setText("User  U-id :\n" + username);



    }
}
