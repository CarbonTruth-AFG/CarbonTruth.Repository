package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the Intent that started this activity and extract the string to display
        Intent intent = getIntent();
        String ansStr = intent.getStringExtra("answer");

        TextView answerText = findViewById(R.id.answerText);
        answerText.setText(ansStr);
    }
}
