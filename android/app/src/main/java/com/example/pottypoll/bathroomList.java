package com.example.pottypoll;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class bathroomList extends AppCompatActivity {
    ArrayList<BathroomStruct> brs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom_list);
        //Toolbar toolbar = findViewById(R.id.listToolbar);
        //setSupportActionBar(toolbar);
        restroom _restroom = new restroom(getApplicationContext());


        RecyclerView brList = (RecyclerView) findViewById(R.id.brList);
        //brs = _restroom.getRestrooms(0,0);
        brs = (ArrayList<BathroomStruct>)getIntent().getSerializableExtra("LIST");
        brAdapter adapter = new brAdapter(brs);
        brList.setAdapter(adapter);
        brList.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addBathroom(View view) {
        Intent intent = new Intent(this, add_review_page.class);
        startActivity(intent);
    }

}
