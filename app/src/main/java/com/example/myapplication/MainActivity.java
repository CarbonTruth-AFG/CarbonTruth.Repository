package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This class has access to two labels, the two edit text boxes, the four bottons, and the answer text label

    //Step 1: get the values from the two text boxes

    //Step 2: Perform the respective mathematical operation (depending on what the user presses)

    //Step 3: Display the answer to the answer label

    private double getFirstNum(){
        EditText firstNumText = findViewById(R.id.firstNum);
        String firstNumStr = firstNumText.getText().toString();
        if(firstNumStr.isEmpty())
            firstNumStr = "0";
        double fNum = Double.parseDouble(firstNumStr);
        return fNum;
    }

    private double getSecondNum(){
        EditText secondNumText = findViewById(R.id.secondNum);
        String secondNumStr = secondNumText.getText().toString();
        if(secondNumStr.isEmpty())
            secondNumStr = "0";
        double sNum = Double.parseDouble(secondNumStr);
        return sNum;
    }

    private void setAnswer(double ans){
        TextView answerText = findViewById(R.id.answerLabel);
        String ansStr = Double.toString(ans);
        answerText.setText("Answer: " + ansStr);

        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra("answer", "ansStr");
        startActivity(intent);

    }


    public void performAddition(View v){

        //Step 1: get the values from the two text boxes
        double fNum = getFirstNum();
        double sNum = getSecondNum();


        //Step 2: Perform the respective mathematical operation (depending on what the user presses)

        double ans = fNum + sNum;

        //Step 3: Display the answer to the answer label
        setAnswer(ans);

        Toast toast = Toast.makeText(getApplicationContext(), "Adding values " + fNum + " and " + sNum, Toast.LENGTH_LONG );
        toast.show();
    }

    public void performSubtraction(View v){

        //Step 1: get the values from the two text boxes
        double fNum = getFirstNum();
        double sNum = getSecondNum();


        //Step 2: Perform the respective mathematical operation (depending on what the user presses)

        double ans = fNum - sNum;

        //Step 3: Display the answer to the answer label
        setAnswer(ans);

        Toast toast = Toast.makeText(getApplicationContext(), "Subtracting values " + fNum + " and " + sNum, Toast.LENGTH_LONG );
        toast.show();
    }

    public void performMultiplication(View v){

        //Step 1: get the values from the two text boxes
        double fNum = getFirstNum();
        double sNum = getSecondNum();


        //Step 2: Perform the respective mathematical operation (depending on what the user presses)

        double ans = fNum * sNum;

        //Step 3: Display the answer to the answer label
        setAnswer(ans);

        Toast toast = Toast.makeText(getApplicationContext(), "Multiplying values " + fNum + " and " + sNum, Toast.LENGTH_LONG );
        toast.show();
    }

    public void performDivision(View v){

        //Step 1: get the values from the two text boxes
        double fNum = getFirstNum();
        double sNum = getSecondNum();


        //Step 2: Perform the respective mathematical operation (depending on what the user presses)

        double ans = fNum / sNum;

        //Step 3: Display the answer to the answer label
        setAnswer(ans);

        Toast toast = Toast.makeText(getApplicationContext(), "Dividing values " + fNum + " and " + sNum, Toast.LENGTH_LONG );
        toast.show();
    }
}



