package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button Lab3button = findViewById(R.id.button5);
        final Button Webopener = findViewById(R.id.button6);
        final Button Orderpage = findViewById(R.id.button7);
        final Button Lab1 = findViewById(R.id.Lab_1button);

        Orderpage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Checkbox.class);
                startActivity(i);
            }
        });
        Lab1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Lab_1.class);
                startActivity(i);
            }
        });

        Lab3button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Lab3_sendBundledata.class);
                startActivity(i);
            }
        });
        Webopener.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Web_Broswer_Opener.class);
                startActivity(i);
            }
        });


        final Button settings = findViewById(R.id.button3);

        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "switching to Settings");
                Intent i = new Intent(getApplicationContext(), IP_Address.class);
                startActivity(i);
            }
        });
    }
}