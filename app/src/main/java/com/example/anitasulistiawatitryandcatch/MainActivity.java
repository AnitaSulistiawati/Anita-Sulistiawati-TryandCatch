package com.example.anitasulistiawatitryandcatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    public void randomNumberGenerator()  //for repeating the game
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    public void OnGuess(View view) {
        String massage="";
        try {
            EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());
            if (guessedNumber < randomNumber)
                massage = "Higher !!";
            else if (guessedNumber > randomNumber)
                massage = "Lower !!";
            else {
                massage = "You got me !!";
                randomNumberGenerator();   //kinda recurtion !
            }

        } catch (Exception e) {
            massage = "You can't input be null.";
        } finally {
            Toast.makeText(this, massage, Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;  //limit upto 20 from 1

    }
}