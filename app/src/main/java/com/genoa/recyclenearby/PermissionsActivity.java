package com.genoa.recyclenearby;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/*
need to put the permission setting under the 'grant button' option instead of just popping it up
 */
public class PermissionsActivity extends AppCompatActivity
{

    private Button grantButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        //If permissions already granted
        if(ContextCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED)
        {
            startActivity(new Intent(PermissionsActivity.this, MainActivity.class));
            finish();
            return;
        }
        else {
            String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET, Manifest.permission.SEND_SMS};
            ActivityCompat.requestPermissions(PermissionsActivity.this, permissions, 1);
        }

        //Get Button
        grantButton = findViewById(R.id.grantButton);
        grantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(PermissionsActivity.this, "Permission Granted.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(PermissionsActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}