package com.example.medicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class AlertBodyParts extends AppCompatActivity {
    ImageView img,img2,img3,img4;
    TextView textView1, textView2, textView3, textView4, textView5, t;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_body_parts);

        // Assign variable$
        t = findViewById(R.id.textView);
        textView1 = findViewById(R.id.text_view1);
        textView2 = findViewById(R.id.text_view2);
        textView3 = findViewById(R.id.text_view3);
        textView4 = findViewById(R.id.text_view4);
        textView5 = findViewById(R.id.text_view5);
        img=findViewById(R.id.coeur);
        img2=findViewById(R.id.poumons);
        img3=findViewById(R.id.cerveau);
        img4=findViewById(R.id.yeux);





        ActivityCompat.requestPermissions(AlertBodyParts.this, new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);

        //initialize fusedLocationProviderClient
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(AlertBodyParts.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                    quand la permission est donnée
//                    String phoneNumber = "0798590172";
//                     message = getLocation();
//                     mess1 = displayToast(getString(R.string.coeur));
////
////                    SmsManager smsManager = SmsManager.getDefault();
////                    SmsManager.sendText(phoneNumber,null,message,null,null);
//
//                    try {
//                        SmsManager smsManager = SmsManager.getDefault();
//                        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
//                        Toast.makeText(getApplicationContext(), "SMS Sent!",
//                                Toast.LENGTH_SHORT).show();
//                    } catch (Exception e) {
//                        Toast.makeText(getApplicationContext(),
//                                "SMS faild, please try again later!",
//                                Toast.LENGTH_SHORT).show();
//                        e.printStackTrace();
//
//                    }

                    getLocation();
                    displayToast(getString(R.string.coeur));

                } else {
                    //quand la permission est refusée
                    ActivityCompat.requestPermissions(AlertBodyParts.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

                }

            }
        });

        //initialize fusedLocationProviderClient
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(AlertBodyParts.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    //quand la permission est donnée
                    getLocation();
                    displayToast(getString(R.string.poumons));
                } else {
                    //quand la permission est refusée
                    ActivityCompat.requestPermissions(AlertBodyParts.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

                }

            }
        });

        //initialize fusedLocationProviderClient
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(AlertBodyParts.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    //quand la permission est donnée
                    getLocation();
                    displayToast(getString(R.string.brain));
                } else {
                    //quand la permission est refusée
                    ActivityCompat.requestPermissions(AlertBodyParts.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

                }

            }
        });

        //initialize fusedLocationProviderClient
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(AlertBodyParts.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    //quand la permission est donnée
                    getLocation();
                    displayToast(getString(R.string.yeux));
                } else {
                    //quand la permission est refusée
                    ActivityCompat.requestPermissions(AlertBodyParts.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

                }

            }
        });


    }




    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        //initialiser geocoder
                        Geocoder geocoder = new Geocoder(AlertBodyParts.this, Locale.getDefault());
                        //initialiser address list
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                        //set latitude sur la textView
                        textView1.setText(Html.fromHtml(
                                "<font color='#FFFFFF'><b>Latitude :</b><br></font>"
                                + addresses.get(0).getLatitude()
                        ));
                        //set longitude sur la text view
                        textView2.setText(Html.fromHtml(
                                "<font color='#FFFFFF'><b>Longitude :</b><br></font>"
                                        + addresses.get(0).getLongitude()
                        ));
                        //set nom du pays sur la text view
                        textView3.setText(Html.fromHtml(
                                "<font color='#FFFFFF'><b>Country Name :</b><br></font>"
                                        + addresses.get(0).getCountryName()
                        ));
                        //set localité
                        textView4.setText(Html.fromHtml(
                                "<font color='#FFFFFF'><b>Locality :</b><br></font>"
                                        + addresses.get(0).getLocality()
                        ));
                        //set address
                        textView5.setText(Html.fromHtml(
                                "<font color='#FFFFFF'><b>Address :</b><br></font>"
                                        + addresses.get(0).getAddressLine(0)
                        )

                        );


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();

    }

}