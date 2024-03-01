package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lab_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);

        final TextView t = (TextView) findViewById(R.id.textView);

        final Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
           int  num = 1;
            public void onClick(View v) {
                Log.d("BUTTONS", "tapped Changecolor");
                if (num == 1) {
                    t.setTextColor(Color.RED);
                    num++;
                } else if (num == 2) {
                    t.setTextColor(Color.GREEN);
                    num++;
                } else if (num == 3) {
                    t.setTextColor(Color.YELLOW);
                    num++;
                } else if (num == 4) {
                    t.setTextColor(Color.CYAN);
                    num++;
                } else if (num == 5) {
                    t.setTextColor(Color.MAGENTA);
                    num++;
                } else if (num == 6)
                    num = 1;
            }
        });

        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
        int font_changer = 1;
            public void onClick(View v) {
                Log.d("BUTTONS", "tapped Change Font");
                if (font_changer == 1) {
                    t.setTextSize(20);
                    font_changer++;
                } else if (font_changer == 2) {
                    t.setTextSize(30);
                    font_changer++;
                } else if (font_changer == 3) {
                    t.setTextSize(40);
                    font_changer++;
                } else if (font_changer == 4) {
                    t.setTextSize(50);
                    font_changer++;
                } else if (font_changer == 5) {
                    t.setTextSize(60);
                    font_changer++;
                } else if (font_changer == 6)
                    font_changer = 1;
            }
        });
    }
}