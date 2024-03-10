package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import android.content.Intent;

public class Lab3_sendBundledata extends AppCompatActivity {
    String[] Depts = {"CS", "IT", "AI", "SE", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_send_bundledata);

        final Button button = findViewById(R.id.Bundle_Send_button);

        final TextView name = (TextView) findViewById(R.id.Name);
        final TextView enrollment = (TextView) findViewById(R.id.Enrollment);

        Spinner spin = (Spinner) findViewById(R.id.Depts_spinner);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Depts);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Intent For Navigating to Second Activity
                Intent i = new Intent(Lab3_sendBundledata.this, BundleData_Receiver.class);
                //For Passing the Values to Second Activity
                i.putExtra("name", name.getText().toString());
                i.putExtra("enrollment", enrollment.getText().toString());
                i.putExtra("Dept", spin.getSelectedItem().toString());


                startActivity(i);
            }
        });
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
    }


}