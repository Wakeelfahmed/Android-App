package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import android.widget.TextView;

public class IP_Address extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_address);

        textView = (TextView) findViewById(R.id.IP_TextView);
        WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        String ipAddress = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
        textView.setText("Your Device IP Address: " + ipAddress);
    }
}

//package com.example.myapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.TextView;
//import java.net.InetAddress;
//import java.net.NetworkInterface;
//import java.util.Enumeration;
//
//import android.text.format.Formatter;
//import android.net.wifi.WifiManager;
//
//public class IP_Address extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ip_address);
//
//        final TextView IP_Text_Box = (TextView) findViewById(R.id.IP_TextView);
//        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
//        String ipAddress = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
//
//        IP_Text_Box.setText(ipAddress);
//    }
//
//
//    private String getDeviceIPAddress() {
//        try {
//            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
//            while (interfaces.hasMoreElements()) {
//                NetworkInterface iface = interfaces.nextElement();
//                Enumeration<InetAddress> addresses = iface.getInetAddresses();
//
//                while (addresses.hasMoreElements()) {
//                    InetAddress addr = addresses.nextElement();
//
//                    // Check for a valid IPv4 address (exclude loopback and link-local addresses)
//                    if (!addr.isLoopbackAddress() && !addr.isLinkLocalAddress() && addr.getAddress().length == 4) {
//                        return addr.getHostAddress();
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "Not available";
//    }
//
//}