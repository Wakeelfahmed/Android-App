package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.lang.Math;


public class Scientific_Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);

        TextView num1 = findViewById(R.id.editTextText2Num1);
        TextView num2 = findViewById(R.id.editTextText3Num2);
        Button bad = findViewById(R.id.buttonAdd);
        Button bsu = findViewById(R.id.button2Sub);
        Button bmu = findViewById(R.id.button3Mul);
        Button bdi = findViewById(R.id.button4Div);
        Button bln = findViewById(R.id.button6Ln);
        Button blog = findViewById(R.id.button5Log);
        Button bs = findViewById(R.id.button8Sin);
        Button bc = findViewById(R.id.button7Cos);
        Button bt = findViewById(R.id.button9Tan);
        Button bsq = findViewById(R.id.button11Sqrt);
        Button bpo = findViewById(R.id.button10Pow);
        TextView res = findViewById(R.id.textView3Result);

        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a, b, c;
                a = Float.parseFloat(num1.getText().toString());
                b = Float.parseFloat(num2.getText().toString());
                c = a + b;
                res.setText("Addition of numbers :" + c);

            }
        });

        bsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a, b, c;
                a = Float.parseFloat(num1.getText().toString());
                b = Float.parseFloat(num2.getText().toString());
                c = a - b;
                res.setText("Subtraction of numbers :" + c);
            }
        });

        bmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a, b, c;
                a = Float.parseFloat(num1.getText().toString());
                b = Float.parseFloat(num2.getText().toString());
                c = a * b;
                res.setText("Multiplication of numbers :" + c);
            }
        });

        bdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a, b, c;
                a = Float.parseFloat(num1.getText().toString());
                b = Float.parseFloat(num2.getText().toString());
                c = a / b;
                res.setText("Division of numbers :" + c);
            }
        });

        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double sires = Math.sin(Float.parseFloat(num1.getText().toString()));
                res.setText("Result of sin value : " + sires);
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cores = Math.cos(Float.parseFloat(num1.getText().toString()));
                res.setText("Result of cos value : " + cores);
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double tares = Math.tan(Float.parseFloat(num1.getText().toString()));
                res.setText("Result of tan value : " + tares);
            }
        });

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double lval = Math.log10(Float.parseFloat(num1.getText().toString()));
                res.setText("Result of log value : " + lval);
            }
        });

        bln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double resl = Math.log(Float.parseFloat(num1.getText().toString()));
                res.setText("Result of Ln value : " + resl);
            }
        });

        bsq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Sqrt = Math.sqrt(Float.parseFloat(num1.getText().toString()));
                res.setText("The Result of Sqrt :  " + Sqrt);
            }
        });

        bpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double por = Math.pow(Float.parseFloat(num1.getText().toString()), Float.parseFloat(num2.getText().toString()));
                res.setText("The Result of power : " + por);
            }
        });


    }

    ;
}
