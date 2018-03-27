package com.kosta.simpleweatherapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//########################################################################
//---------------------------------------------------------------------###
//--I have no idea why it isn't displaying the weather on the screen---###
//---------------------------------------------------------------------###
//########################################################################
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txt_weather_data)
    TextView mWeatherData;

    String weather;
    LocationManager locationManager;
    double longtitude = 0;
    double latitude = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (!RuntimePermissions()) {
            getLocation();
        }

    }

    public void getLocation(){
        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        Location lc = getLastKnownLocation();
        longtitude = lc.getLongitude();
        latitude = lc.getLatitude();
    }

    @OnClick(R.id.btn_loc_and_data)
    public void onButtonClicked(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherServiceInterface.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherServiceInterface service = retrofit.create(WeatherServiceInterface.class);
        service.getCurrentWeather(latitude,longtitude).enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if(response.isSuccessful()){
                    WeatherData weatherData = response.body();

                    weather = weatherData.toString();
                    mWeatherData.setText(weather);
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

            }
        });
    }

    private boolean RuntimePermissions() {
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);

            return true;
        }
        return false;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                RuntimePermissions();
            }
        }
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
