package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BundleData_Receiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_data_receiver);

        TextView t1 = (TextView) findViewById(R.id.textView2);
        TextView t2 = (TextView) findViewById(R.id.textView3);
        TextView t3 = (TextView) findViewById(R.id.textView4);

        Intent i = getIntent();

        //Setting the Values to Intent
        t1.setText(i.getStringExtra("name"));
        t2.setText(i.getStringExtra("enrollment"));
        t3.setText(i.getStringExtra("Dept"));
    }

}