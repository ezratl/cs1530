package com.example.pottypoll;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BathroomSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom_select);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = findViewById(R.id.fab);

        ArrayList<Integer> bathrooms = getIntent().getIntegerArrayListExtra("VALUES");

        LinearLayout layout = findViewById(R.id.BathroomList);

        for (Integer bathroom : bathrooms){
            final TextView text = new TextView(this);
            text.setText("Floor " + bathroom.intValue());
            text.setPadding(4, 4, 4, 4);
            text.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent();
                    intent.putExtra("VALUE", Integer.valueOf(text.getText().toString().substring(6)));
                    setResult(1, intent);
                    finish();
                }
            });

            layout.addView(text);
        }
    }

}
