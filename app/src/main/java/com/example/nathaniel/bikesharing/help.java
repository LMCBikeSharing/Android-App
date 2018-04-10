package com.example.nathaniel.bikesharing;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class help extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private static final int REQUEST_APP_SETTINGS = 168;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

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
                        switch (menuItem.getItemId()) {
                            case R.id.home:
                                Intent mainIntent = new Intent(help.this, select_station.class);
                                help.this.startActivity(mainIntent);
                                return true;
                            case R.id.settings:
                                goToSettings();
                                return true;
                            case R.id.report_issue:
                                mainIntent = new Intent(help.this, report_issue.class);
                                help.this.startActivity(mainIntent);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }

    //allows the app to go to the apps settings based on its package name on the device
    private void goToSettings() {
        Intent myAppSettings = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
        myAppSettings.addCategory(Intent.CATEGORY_DEFAULT);
        myAppSettings.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityForResult(myAppSettings, REQUEST_APP_SETTINGS);
    }
}
