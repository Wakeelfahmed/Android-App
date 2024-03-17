package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Send_Email extends AppCompatActivity {
    EditText recipientEditText, senderEditText, subjectEditText, messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        recipientEditText = findViewById(R.id.recipientEditText);
        senderEditText = findViewById(R.id.senderEditText);
        subjectEditText = findViewById(R.id.subjectEditText);
        messageEditText = findViewById(R.id.messageEditText);

        final Button Email_sendButton = findViewById(R.id.Email_sendButton);
        Email_sendButton.setOnClickListener(v -> {
            String recipientsString = recipientEditText.getText().toString().trim();
            String[] recipients = recipientsString.split(",");
            for (int i = 0; i < recipients.length; i++) {
                recipients[i] = recipients[i].trim();
            }

            String from = senderEditText.getText().toString().trim();
            String subject = subjectEditText.getText().toString().trim();
            String message = messageEditText.getText().toString().trim();

            for (String recipient : recipients) {
                if (!Patterns.EMAIL_ADDRESS.matcher(recipient).matches()) {
                    recipientEditText.setError("Valid Recipient(s) required");
                    recipientEditText.requestFocus();
                    return;
                }
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(from).matches()) {
                senderEditText.setError("Valid Sender required");
                senderEditText.requestFocus();
                return;
            }

            if (subject.isEmpty()) {
                subjectEditText.setError("Subject required");
                subjectEditText.requestFocus();
                return;
            }

            if (message.isEmpty()) {
                messageEditText.setError("Message required");
                messageEditText.requestFocus();
                return;
            }

            // Create an Intent to send email
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, recipients);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            emailIntent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
        });
    }
}
