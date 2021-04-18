package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void generateRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;
    }
    public void guessNumber(View view) {

        Log.i("Info", "Button pressed!");

        EditText guessNum = (EditText) findViewById(R.id.guessEditText);
        String guessNumString = guessNum.getText().toString();
        int guessNumInt = Integer.parseInt(guessNumString);

        String message;
        if(guessNumInt > randomNumber) {
            message = "Lower!";
        } else if(guessNumInt < randomNumber) {
            message = "Higher!";
        } else {
            message = "You got it! Try again!";
            generateRandomNumber();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }
}