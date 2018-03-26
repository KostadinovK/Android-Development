package com.kosta.locationsaver;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_locations)
    TextView mLocationsTextView;
    @BindView(R.id.btn_get_current_loc)
    Button mGetCurrentLocBtn;
    @BindView(R.id.btn_clear_data)
    Button mClearDataBtn;
    @BindView(R.id.txt_current_loc)
    TextView mCurrentLoc;

    Intent intent;
    SharedPreferences preference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preference = PreferenceManager.getDefaultSharedPreferences(this);
        ButterKnife.bind(this);
        if (!RuntimePermissions()) {
            intent = new Intent(this, LocationsService.class);
            startService(intent);
        }

        if (preference != null)
            mLocationsTextView.setText(preference.getAll().toString());

    }


    @OnClick(R.id.btn_clear_data)
    public void onClearDataClicked() {
        preference.edit().clear().commit();
        mLocationsTextView.setText(preference.getAll().toString());

    }

    @OnClick(R.id.btn_get_current_loc)
    public void stopService() {
        stopService(intent);
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
                startService(intent);
            } else {
                RuntimePermissions();
            }
        }
    }

}
