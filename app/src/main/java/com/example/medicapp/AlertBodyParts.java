package com.example.medicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class AlertBodyParts extends AppCompatActivity {

    TextView textView1,textView2,textView3,textView4,textView5;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_body_parts);

        // Assign variable
        textView1 = findViewById(R.id.text_view1);
        textView1 = findViewById(R.id.text_view2);
        textView1 = findViewById(R.id.text_view3);
        textView1 = findViewById(R.id.text_view4);
        textView1 = findViewById(R.id.text_view5);

        //initialize fusedLocationProviderClient
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void showHearthMessage(View view) {
        displayToast(getString(R.string.coeur));
    }

    public void showLungsMessage(View view) {
        displayToast(getString(R.string.poumons));
    }

    public void showEyesMessage(View view) {
        displayToast(getString(R.string.yeux));
    }

    public void showBrainMessage(View view) {
        displayToast(getString(R.string.brain));
    }
}