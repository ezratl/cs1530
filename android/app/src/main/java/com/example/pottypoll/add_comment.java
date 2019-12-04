package com.example.pottypoll;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class add_comment extends AppCompatActivity {

    EditText commentText;
    RatingBar rating;
    SharedPreferences sharedPreferences;// = getApplicationContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
    CommentAdaptor cDB;
    BathroomStruct bathroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        commentText = findViewById(R.id.comment_text);
        rating = findViewById(R.id.comment_rating);
        bathroom = (BathroomStruct)getIntent().getSerializableExtra("BATHROOM");

        final Button submitButton = findViewById(R.id.comment_submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                comment newComment = new comment(add_comment.this);

                newComment.setComment(commentText.getText().toString());
                newComment.setRating(rating.getNumStars());
                newComment.setBathroomID(bathroom.ID);

                CommentAdaptor adaptor = new CommentAdaptor(add_comment.this);
                adaptor.insertData(newComment.getBathroomID(), newComment.getUserID(), newComment.getRating(), newComment.getComment());

                finish();
            }
        });

    }

    public  void submitComment(View view)
    {

        commentText = (EditText)findViewById(R.id.comment_text);
        rating = (RatingBar)findViewById(R.id.comment_rating);

        String commentString = commentText.getText().toString();
        int ratingNum = rating.getNumStars();
        sharedPreferences = getApplicationContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        int userID = sharedPreferences.getInt("USERID", 0);
        int bathroomID = sharedPreferences.getInt("BATHROOMID", 0);

        cDB = new CommentAdaptor(this);
        int commentID = (int)cDB.insertData(bathroomID, userID, ratingNum, commentString);

        if(commentID >= 0)
        {

            Toast message = Toast.makeText(getApplicationContext(), "ADDED TO DATABASE" , Toast.LENGTH_LONG);
            message.show();
        }
        else
        {

            Toast message = Toast.makeText(getApplicationContext(), "NEGATIVE" , Toast.LENGTH_LONG);
            message.show();

        }

    }

}
