package com.example.tourguideapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDescription extends AppCompatActivity {

    /**
     * Static Fields that will be used as key's to pass data in form of intents
     */
    static final String PLACE = "PLACE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_description);

        // Receive the {@link Place} object that has been sent to this activity
        Place place = getIntent().getExtras().getParcelable(PLACE);

        // Get the TextViews that require their data to match with the arguments passed
        TextView placeNameTextView = findViewById(R.id.place_name);
        TextView placeAddressTextView = findViewById(R.id.place_address);
        TextView placeDescriptionTextView = findViewById(R.id.place_description);

        // Get the ImageView that will show the image of this {@link Place} object
        ImageView placeImageView = findViewById(R.id.place_image);

        // Set the text of each of the {@link TextView} objects accurately to the values of
        // the {@link Place} object
        placeNameTextView.setText(place.getName());
        placeAddressTextView.setText(place.getAddress());
        placeDescriptionTextView.setText(place.getDescription());

        // Set the image of the {@link Place} object
        placeImageView.setImageResource(place.getPicture());

    }

}
