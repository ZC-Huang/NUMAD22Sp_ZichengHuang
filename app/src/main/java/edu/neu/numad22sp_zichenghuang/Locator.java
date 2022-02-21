package edu.neu.numad22sp_zichenghuang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Locator extends AppCompatActivity {

    TextView textView_lat, textView_long;
    Button location_button;
    FusedLocationProviderClient fusedLocationProviderClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);


        textView_lat = findViewById(R.id.textView_lat);
        textView_long = findViewById(R.id.textView_long);
        location_button = findViewById(R.id.location_button);

        //initialize fused
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        location_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(Locator.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    getLocation();
                }else{
                    ActivityCompat.requestPermissions(Locator.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null){
                    try {
                        Geocoder geocoder = new Geocoder(Locator.this,
                                Locale.getDefault());
                        List<Address> address = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1);
                        textView_lat.setText((Html.fromHtml(
                                "<font color ='#6200EE'><b>Latitude :</b><br></font>"
                                + address.get(0).getLatitude()
                        )));
                        textView_long.setText((Html.fromHtml(
                                "<font color ='#6200EE'><b>Latitude :</b><br></font>"
                                        + address.get(0).getLongitude()
                        )));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}