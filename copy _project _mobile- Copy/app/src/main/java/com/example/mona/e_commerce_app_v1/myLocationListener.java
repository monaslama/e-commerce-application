package com.example.mona.e_commerce_app_v1;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class myLocationListener implements LocationListener {

    private Context activityContext;
    public myLocationListener(Context cont) {
        activityContext=cont;
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(activityContext,location.getLatitude()+", "+location.getLongitude(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(activityContext,"GPS Enabled",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(activityContext,"GPS Disabled",Toast.LENGTH_LONG).show();
    }
}

