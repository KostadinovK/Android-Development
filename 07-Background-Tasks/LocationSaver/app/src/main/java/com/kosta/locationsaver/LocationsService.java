package com.kosta.locationsaver;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;

import android.provider.Settings;
import android.support.annotation.Nullable;

import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.LocationServices;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class LocationsService extends Service {

    private LocationListener listener;
    private LocationManager locationManager;

    private Context context;
    private SharedPreferences preference;

    private TimerTask scanTask;
    private final Handler handler = new Handler();
    private Timer mTimer = new Timer();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        preference = PreferenceManager.getDefaultSharedPreferences(this);
        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onCreate() {

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };


        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        getLocation();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationManager != null) {
            //noinspection MissingPermission
            locationManager.removeUpdates(listener);
        }
        Toast msg = Toast.makeText(this,"Service has stopped...",Toast.LENGTH_SHORT);
        msg.show();
    }


    private void getLocation() {

        scanTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {

                        try {
                            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 20000, 0, listener);
                            Location loc = getLastKnownLocation();
                            double latitude = loc.getLatitude();
                            double longitude = loc.getLongitude();
                            preference.edit().putString(Integer.toString(new Random().nextInt(Integer.MAX_VALUE)), "Latitude: " + latitude +"\n"+ "Longitude: " + longitude).apply();
                        } catch (SecurityException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
        // somehow magically this is 10 seconds
        mTimer.schedule(scanTask, 1000, 20000);
    }


    private Location getLastKnownLocation() {
        locationManager = (LocationManager)getApplicationContext().getSystemService(LOCATION_SERVICE);
        Location l = null;
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            try{
                l = locationManager.getLastKnownLocation(provider);
            }catch (SecurityException e){
                e.printStackTrace();
            }

            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {

                bestLocation = l;
            }
        }
        return bestLocation;
    }

}
