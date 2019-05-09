package com.example.bmicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateBmi(View v){
        EditText userWeight = (EditText) findViewById(R.id.weightBox);
        EditText userFeet = (EditText) findViewById(R.id.feetBox);
        EditText userInch = (EditText) findViewById(R.id.inchBox);
        TextView totalBMI = (TextView) findViewById(R.id.totalBMI);

        double heightFeet = Double.parseDouble(userFeet.getText().toString());
        double heightInch = Double.parseDouble(userInch.getText().toString());
        double weight = Double.parseDouble(userWeight.getText().toString());
        double height = (heightFeet * 12) + heightInch;

        String result = "";

        double BMI = 703* weight / (height*height);

        BigDecimal bd = new BigDecimal(BMI).setScale(2, RoundingMode.HALF_UP);
        BMI = bd.doubleValue();

        if(BMI< 18.5){
            result = "Underweight";
        }else if(BMI > 18.5 && BMI <24.9){
            result = "Normal Weight";
        }else if(BMI > 24.9 && BMI <29.9){
            result = "Overweight";
        }else{
            result = "Obesity";
        }

        result = BMI + " " + result;
        totalBMI.setText(result);
        //totalBMI.setText(Double.toString(BMI) + "    " + result);
    }
}

