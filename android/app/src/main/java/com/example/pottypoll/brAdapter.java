package com.example.pottypoll;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

public class brAdapter extends
        RecyclerView.Adapter<brAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button reviewButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.bathroom_name);
            reviewButton = (Button) itemView.findViewById(R.id.review_button);
        }
    }

    // Store a member variable for the contacts
    private List<BathroomStruct> bathrooms;
    private Context context;

    // Pass in the contact array into the constructor
    public brAdapter(List<BathroomStruct> _bathrooms) {
        bathrooms = _bathrooms;
    }

    @Override
    public brAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.bathrooms, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(brAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final BathroomStruct bathroom = bathrooms.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(bathroom.BUILDNAME+" floor "+bathroom.FLOOR+" ("+bathroom.GENDER+")");
        Button button = viewHolder.reviewButton;
        button.setText("Review");
        button.setEnabled(true);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, add_comment.class);
                intent.putExtra("BATHROOM", bathroom);
                context.startActivity(intent);
            }
        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return bathrooms.size();
    }
}