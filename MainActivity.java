package com.asp.kevinbell.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void makeToast(String string){
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    // method to take the user's input to determine what kind of number it is
    public void testNumber(View view){

        // gets user's input and checks if it's empty
        EditText userInput = (EditText) findViewById(R.id.userInput);
        if(userInput.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter a value!", Toast.LENGTH_LONG).show();
        }
        else {
            // create a new number
            Number testNum = new Number();
            testNum.number = Integer.parseInt(userInput.getText().toString());
            int num = testNum.number;
            Log.i("Number", userInput.getText().toString());


            // checks for what type of number the user gave
            if (testNum.isSquare() == true && testNum.isTriangular() == true) {
                Toast.makeText(MainActivity.this, num + " is both a square and triangular number!!", Toast.LENGTH_SHORT).show();
            } else if (testNum.isSquare() == true) {
                Toast.makeText(MainActivity.this, num + " is a square number!!", Toast.LENGTH_SHORT).show();
            } else if (testNum.isTriangular() == true) {
                Toast.makeText(MainActivity.this, num + " is a triangular number!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, num + " is neither a square and triangular number!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    // number class to do the work of determining what type of number the user gave
    public class Number {

        public int number;

        // checks if the number is triangular
        public boolean isTriangular(){

            int x = 1;
            int triangularNumber = 1;
            while(triangularNumber <= number){
                if(number == triangularNumber){ return true; }
                x++;
                triangularNumber = triangularNumber + x;
            }
            return false;
        }
        // checks if the number is square
        public boolean isSquare(){

            double squareRootNumber = Math.sqrt(number);
            if(Math.floor(squareRootNumber) == squareRootNumber){return true;}
            else { return false; }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
