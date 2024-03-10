package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.NotificationManager;

public class MainActivity extends AppCompatActivity {
    int notification_ID = 0;
    private static final String CHANNEL_ID = "my_channel_id";
    private static final CharSequence CHANNEL_NAME = "My Channel";
    private static final String CHANNEL_DESCRIPTION = "My Notification Channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        createNotificationChannel();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button Lab3button = findViewById(R.id.Lab3button);
        final Button Web_opener = findViewById(R.id.Web_opener);
        final Button Order_page = findViewById(R.id.Order_page);
        final Button Lab1 = findViewById(R.id.Lab_1button);
        final Button Sci_Calculator_button8 = findViewById(R.id.Sci_Calculator_button8);
        final Button button_notification = findViewById(R.id.button_notification);
        final Button settings = findViewById(R.id.Settings);


        button_notification.setOnClickListener(v -> {
            sendNotification();
        });

        Sci_Calculator_button8.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Scientific_Calculator.class);
            startActivity(i);
        });

        Order_page.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Checkbox.class);
            startActivity(i);
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
        Web_opener.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Web_Broswer_Opener.class);
            startActivity(i);
        });

        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("BUTTONS", "switching to Settings");
                Intent i = new Intent(getApplicationContext(), IP_Address.class);
                startActivity(i);
            }
        });
    }

    private void createNotificationChannel() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            //Request permissions and return
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 123);
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESCRIPTION);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void sendNotification() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            //Request permissions and return
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 123);
            return;
        }
        Intent intent = new Intent(this, Notification.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Lab 4")
                .setContentText("Android Notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)  // Set the pending intent
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
}