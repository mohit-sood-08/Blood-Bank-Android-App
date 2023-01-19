package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class RegisterationSuccess extends AppCompatActivity {
 TextView heading,tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_success);
        Intent i = getIntent();
        this.setTitle("Registeration Successfull");
        String name = i.getStringExtra("name");
        String contact = i.getStringExtra("contact");
        String addr = i.getStringExtra("address");
        String gender = i.getStringExtra("gender");
        String blood = i.getStringExtra("blood");

        initializeField();

        heading.setText("THANKS "+name.toUpperCase());
        tv.setText("Name: "+name+"\nGender: "+gender+"\nBlood Group: "+blood+"\nContact No.: "+contact+"\nAddress: "+addr);
    }

    void initializeField(){
        heading = (TextView) findViewById(R.id.textView8);
        tv = (TextView) findViewById(R.id.textView7);
    }
}