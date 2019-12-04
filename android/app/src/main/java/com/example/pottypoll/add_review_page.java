package com.example.pottypoll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class add_review_page extends AppCompatActivity {

    EditText gender;
    EditText location;
    EditText building;
    EditText hours;
    EditText floor;
    CheckBox shower;
    CheckBox sink;
    CheckBox papertowel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review_page);
    }

    public void createBathroom(View view)
    {
        //gender = (EditText)findViewById(R.id.gender);
        //location = (EditText)findViewById(R.id.location);
        //building = (EditText)findViewById(R.id.building);
        //hours = (EditText)findViewById(R.id.hours);
        //floor = (EditText)findViewById(R.id.floor);
        //shower = (CheckBox)findViewById(R.id.shower);
        //sink = (CheckBox)findViewById(R.id.sink);
        //papertowel = (CheckBox)findViewById(R.id.papertowel);
        //Toast message;
        //message = Toast.makeText(getApplicationContext(), gender.getText().toString(), Toast.LENGTH_LONG);
        //message.show();
    }
}
