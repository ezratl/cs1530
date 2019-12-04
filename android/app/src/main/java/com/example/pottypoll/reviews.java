package com.example.pottypoll;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.content.Intent;

public class reviews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.potty_reviews);
    }

    public void display_typed_review_page(View view) {
        Intent review_type_intent = new Intent(reviews.this, typed_review.class);
        startActivity(review_type_intent);

    }

    public void display_all_reviews(View view) {
        Intent display_all_intent = new Intent(reviews.this, all_reviews.class);
        startActivity(display_all_intent);

    }



}
