package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMS_and_phone extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_and_phone);

        final Button Send_SMS = findViewById(R.id.Send_SMS_button);
        final Button Make_Call_Button = findViewById(R.id.Make_Call_Button);
        EditText Phone_number_input = (EditText) findViewById(R.id.Recipient_Phone_Number);
        EditText message_box = (EditText) findViewById(R.id.Recipient_Message_Box);

        Send_SMS.setOnClickListener(v -> {
            String phoneNumber = Phone_number_input.getText().toString();
            String message = message_box.getText().toString();

            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Toast.makeText(getApplicationContext(), "Message Sent successfully!", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Failed to send message", Toast.LENGTH_LONG).show();
                e.printStackTrace();

            }
        });

        Make_Call_Button.setOnClickListener(v -> {
            String phoneNumber = Phone_number_input.getText().toString();

            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            try {
                this.startActivity(callIntent);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Failed to make Call", Toast.LENGTH_LONG).show();
                e.printStackTrace();

            }
        });
    }
}