package com.example.pottypoll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.core.app.ApplicationProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BathroomAdaptor brDB;
    UserAdaptor userDB;
    EditText username;
    EditText password;
    SharedPreferences sharedPreferences;// = getApplicationContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brDB = new BathroomAdaptor(this);
        userDB = new UserAdaptor(this);

        sharedPreferences = getApplicationContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);

        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast message;

                username = (EditText)findViewById(R.id.username);
                password = (EditText)findViewById(R.id.password);
                //message = Toast.makeText(getApplicationContext(), username.getText().toString(), Toast.LENGTH_LONG);
                int userID = userDB.getID(username.getText().toString(), password.getText().toString());
                if (userID < 0)
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_LONG).show();
                else {
                    sharedPreferences = getApplicationContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
                    sharedPreferences.edit().putInt("USERID", userID).apply();
                    //message.show();

                    Intent intent = new Intent(MainActivity.this, MapActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    /*public void login(View view){
        Toast message;

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        message = Toast.makeText(getApplicationContext(), username.getText().toString(), Toast.LENGTH_LONG);
        int userID = userDB.getID(username.getText().toString(), password.getText().toString());
        if (userID >= 0)
            message = Toast.makeText(getApplicationContext(), userID, Toast.LENGTH_LONG);
        sharedPreferences = getApplicationContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("USERID",userID).apply();
        message.show();



    }*/

    public void createUser (View view)
    {
        Toast message;
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        message = Toast.makeText(getApplicationContext(), username.getText().toString(), Toast.LENGTH_LONG);
        int userID = (int)userDB.insertData(username.getText().toString(), password.getText().toString(), "name@email.com", 0);
        if (userID > 0)
            message = Toast.makeText(getApplicationContext(), "Account created successfully" , Toast.LENGTH_LONG);
        sharedPreferences.edit().putInt("USERID",userID).apply();
        message.show();
    }

    public void sendMessage (View view) {

        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        startActivity(intent);


    }

}
