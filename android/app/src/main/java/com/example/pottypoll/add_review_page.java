package com.example.pottypoll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

public class add_review_page extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText gender;
    EditText location;
    EditText building;
    EditText hours;
    EditText floor;
    CheckBox shower;
    CheckBox sink;
    CheckBox papertowel;
    LatLng  coordinates;
    int sh=0, s=0, pt=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review_page);
    }

    public void createBathroom(View view)
    {
        gender = (EditText)findViewById(R.id.gender);
        location = (EditText)findViewById(R.id.location);
        building = (EditText)findViewById(R.id.building);
        hours = (EditText)findViewById(R.id.hours);
        floor = (EditText)findViewById(R.id.floor);
        shower = (CheckBox)findViewById(R.id.shower);
        sink = (CheckBox)findViewById(R.id.sink);
        papertowel = (CheckBox)findViewById(R.id.papertowel);
        if(shower.isChecked())
            sh=1;
        if(sink.isChecked())
            s=1;
        if(papertowel.isChecked())
            pt=1;
        coordinates = (LatLng) getIntent().getParcelableExtra("LOCATION");

        restroom bathroom = new restroom(getApplicationContext());
        sharedPreferences = getApplicationContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("BATHROOMID",bathroom.getID()).apply();
        //BathroomAdaptor brDB = new BathroomAdaptor(this);
        if(bathroom.addRestroom(0, gender.getText().toString(), location.getText().toString(), coordinates.longitude, coordinates.latitude, building.getText().toString(), Integer.parseInt(floor.getText().toString()), hours.getText().toString(), sh, s, pt)) {
            Toast message;
            message = Toast.makeText(getApplicationContext(), "YAY", Toast.LENGTH_LONG);
            message.show();
            setResult(0);
            finish();
        }
    }
}