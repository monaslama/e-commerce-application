package com.example.mona.e_commerce_app_v1;

import android.content.Context;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    EditText text;
    Button btn;
    Button order;
    LocationManager locationManager;
    myLocationListener locationListener;
    dp_helper_1 myclass=new dp_helper_1(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        order=(Button)findViewById(R.id.order);
        final String cust_id=(getIntent().getExtras().getString("cust_id"));
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c);
               // String date="145";
                int cus_id=Integer.parseInt(cust_id);
                String address="alex";
                //myclass.insert_order( formattedDate,cus_id ,address );
              /*  int or=myclass.get_id_order(cus_id);
                myclass.insert_order_details(or,cus_id);*/
               // myclass.on_delete_shopping();
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        text=(EditText)findViewById(R.id.gps_txt);
        btn=(Button)findViewById(R.id.button_gps);
        locationListener=new myLocationListener(getApplicationContext());
        locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    8000,0,locationListener);
        }catch (SecurityException ex){
            Toast.makeText(getApplicationContext(),"You are not allowed to access current location"
                    ,Toast.LENGTH_LONG).show();
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(new LatLng(30.04441960,31.235711600)).title("Marker in Sydney"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom
                (new LatLng(30.04441960,31.235711600),8));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.clear();
                Geocoder coder= new Geocoder(getApplicationContext());
                List<Address> addressList;
                Location loc = null;
                try {
                    loc=locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
                }catch (SecurityException ex){
                    Toast.makeText(getApplicationContext(),"You are not allowed to access current location"
                            ,Toast.LENGTH_LONG).show();
                }
                if(loc==null)
                    Toast.makeText(getApplicationContext(),"null location",Toast.LENGTH_LONG).show();
                if(loc!=null){
                    Toast.makeText(getApplicationContext(),"jjjjnnn",Toast.LENGTH_LONG).show();
                    LatLng myPosition = new LatLng(loc.getLatitude(),loc.getLongitude());
                    try {
                        addressList=coder.getFromLocation(myPosition.latitude,myPosition.longitude,1);
                        if(!addressList.isEmpty()){
                            String address="";
                            for(int i=0; i<=addressList.get(0).getMaxAddressLineIndex(); i++)
                                address+=addressList.get(0).getAddressLine(i)+", ";
                            mMap.addMarker(new MarkerOptions().position(myPosition).title("My Location")
                                    .snippet(address).draggable(true));
                            text.setText(address);
                        }
                    }catch (IOException ex){
                        mMap.addMarker(new MarkerOptions().position(myPosition).title("My location"));
                    }
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPosition,15));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please wait until your position is determined",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                Geocoder coder = new Geocoder(getApplicationContext());
                List<Address> addressList;
                try {
                    addressList=coder.getFromLocation(marker.getPosition().latitude,marker.getPosition().longitude,1);
                    if(!addressList.isEmpty()){
                        String address="";
                        for (int i=0; i<=addressList.get(0).getMaxAddressLineIndex(); i++)
                            address+=addressList.get(0).getAddressLine(i)+", ";
                        text.setText(address);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"No address for this location",Toast.LENGTH_LONG).show();
                        text.getText().clear();
                    }
                }catch (IOException ex){
                    Toast.makeText(getApplicationContext(),"Can't get your address check your network",Toast.LENGTH_LONG).show();
                }
            }
        });


        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}

