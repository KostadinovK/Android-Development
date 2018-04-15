package com.kosta.hotornot;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MyLocationListener implements LocationListener {
    public Context context;
    private String cityName;
    private double longtitude;
    private double latitude;

    public MyLocationListener() {
    }

    public MyLocationListener(Context context) {
        this.context = context;
        this.cityName = "Unknown";
    }

    @Override
    public void onLocationChanged(Location loc) {
        this.longtitude = loc.getLongitude();
        this.latitude = loc.getLatitude();
        Toast.makeText(context, "Location changed : Lat: " +
                        loc.getLatitude() + " Lng: " + loc.getLongitude(),
                Toast.LENGTH_SHORT).show();
        String longitude = "Longitude: " + loc.getLongitude();
        Log.v("TAG", longitude);
        String latitude = "Latitude: " + loc.getLatitude();
        Log.v("TAG", latitude);

        Geocoder gcd = new Geocoder(context,
                Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = gcd.getFromLocation(loc.getLatitude(), loc
                    .getLongitude(), 1);
            if (addresses.size() > 0)
                System.out.println(addresses.get(0).getLocality());
            cityName = addresses.get(0).getLocality();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public String getCityName() {
        return this.cityName;
    }

    public double getLongitude() {
        return this.longtitude;
    }

    public double getLatitude() {
        return this.latitude;
    }
}
