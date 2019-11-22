package com.example.pottypoll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.core.app.ApplicationProvider;

import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BathroomAdaptor brDB;
    UserAdaptor userDB;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brDB = new BathroomAdaptor(this);
        userDB = new UserAdaptor(this);
    }

    public void login(View view){
        Toast message;

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        message = Toast.makeText(getApplicationContext(), username.getText().toString(), Toast.LENGTH_LONG);
        int userID = userDB.getID(username.getText().toString(), password.getText().toString());
        if (userID >= 0)
            message = Toast.makeText(getApplicationContext(), userID , Toast.LENGTH_LONG);

        message.show();

    }

    public void createUser (View view)
    {
        Toast message;
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        message = Toast.makeText(getApplicationContext(), username.getText().toString(), Toast.LENGTH_LONG);
        long userID = userDB.insertData(username.getText().toString(), password.getText().toString(), "name@email.com", 0);
        if (userID > 0)
            message = Toast.makeText(getApplicationContext(), "YAY" , Toast.LENGTH_LONG);

        message.show();
    }
}
