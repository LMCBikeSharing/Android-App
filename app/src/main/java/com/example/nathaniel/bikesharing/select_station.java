package com.example.nathaniel.bikesharing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;

public class select_station extends FragmentActivity implements OnMapReadyCallback {
    //current map variable declaration
    private GoogleMap mMap;
    //slide out hamburger menu variable declaration
    private DrawerLayout mDrawerLayout;

    @Override//Basically the constructor
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_station);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //define the hamburger menu as the drawer in the XML
        mDrawerLayout = findViewById(R.id.drawer_layout);
        //define the ham_menu button object as the XML object
        final Button ham_menu = findViewById(R.id.ham_menu);
        //construct a click listener to execute code when the defined button is clicked
        ham_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        //allows execution of certain code based on the state of the hamburger menu
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
        //create a view for the hamburger menu
        NavigationView navigationView = findViewById(R.id.nav_view);
        //create a listener for the objects in the hamburger menu
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
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

        // Add a marker in Sydney and move the camera
        LatLng lemoyne = new LatLng(43.0497, -76.0855);
        LatLng station_1 = new LatLng(43.0487734, -76.0875042);
        LatLng station_2 = new LatLng(43.0467958, -76.0910839);
        LatLng station_3 = new LatLng(43.0468909, -76.0858275);
        LatLng station_4 = new LatLng(43.0498038, -76.0902384);
        LatLng station_5 = new LatLng(43.0495897, -76.0853903);
        //add marker in lemoyne and then move to it and set camera zoom
        mMap.addMarker(new MarkerOptions().position(lemoyne).title("Marker in lemoyne"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lemoyne));
        mMap.setBuildingsEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lemoyne, 15));
        //add all the stations one by one, can be more compact if you add them into an array and loop
        mMap.addMarker(new MarkerOptions().position(station_1).title("Station 1")
                .icon(BitmapDescriptorFactory.fromBitmap(iconchooser())));
        mMap.addMarker(new MarkerOptions().position(station_2).title("Station 2")
                .icon(BitmapDescriptorFactory.fromBitmap(iconchooser())));
        mMap.addMarker(new MarkerOptions().position(station_3).title("Station 3")
                .icon(BitmapDescriptorFactory.fromBitmap(iconchooser())));
        mMap.addMarker(new MarkerOptions().position(station_4).title("Station 4")
                .icon(BitmapDescriptorFactory.fromBitmap(iconchooser())));
        mMap.addMarker(new MarkerOptions().position(station_5).title("Station 5")
                .icon(BitmapDescriptorFactory.fromBitmap(iconchooser())));
    }
    //class for returning a Bitmap of a chosen drawable object, in this case the bike station
    private Bitmap iconchooser(){
        Bitmap choice;
        choice = getBitmap(this,R.drawable.bikestation);
        return choice;
    }
    //converts a drawable into a bitmap object and then returns it or an error
    public Bitmap getBitmap(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (drawable instanceof BitmapDrawable) {
            return BitmapFactory.decodeResource(context.getResources(), drawableId);
        }  else {
            throw new IllegalArgumentException("unsupported drawable type");
        }
    }
}
