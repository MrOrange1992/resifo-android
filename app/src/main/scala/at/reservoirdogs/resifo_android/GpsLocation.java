package at.reservoirdogs.resifo_android;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import scala.Console;

/**
 * Created by Elli on 05.02.2017.
 */

public class GpsLocation implements LocationListener {
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    private Location location;
    protected boolean gps_enabled, network_enabled;

    Geocoder geocoder;
    List<Address> addresses;

    public GpsLocation(AppCompatActivity callingActivity) {

        if (ActivityCompat.checkSelfPermission(callingActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(callingActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(callingActivity, new String[] {
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.INTERNET},1);

        }

        locationManager = (LocationManager) callingActivity.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);

        geocoder = new Geocoder(callingActivity, Locale.getDefault());



    }

    public String[] getAddress(){
        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        } catch (IOException e) {
            Console.println(e.toString());
        }
        String[] output = {addresses.get(0).getAddressLine(0),addresses.get(0).getLocality(),addresses.get(0).getPostalCode()};
        return output;
    }

    public String getLocation(){
        return ("Latitude: "+location.getLatitude()+", Longitude: "+location.getLongitude());

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
