package com.example.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StayingActiveFragment extends Fragment {


    public StayingActiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment and store it as rootView
        // so that we can access it later
        View rootView = inflater.inflate(R.layout.fragment_place_list, container, false);

        // Create our final {@link ArrayList} of Work Spaces
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getContext().getString(R.string.staying_active_ymca),
                getContext().getString(R.string.staying_active_ymca_address),
                getContext().getString(R.string.place_description_ymca_description)));
        places.add(new Place(getContext().getString(R.string.staying_active_planet_fitness),
                getContext().getString(R.string.staying_active_planet_fitness_address),
                getContext().getString(R.string.place_description_planet_fitness_description)));
        places.add(new Place(getContext().getString(R.string.staying_active_yoga_to_the_people),
                getContext().getString(R.string.staying_active_yoga_to_the_people_address),
                getContext().getString(R.string.place_description_ymca_description)));

        // Add our {@link ArrayList} to our custom {@link ArrayAdapter} so that we can pass it
        // to our {@link ListView} hence populating it with our {@link Place} objects correctly
        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), places);

        // Find our chosen {@link ListView} so that we can set our chosen adapter to have it get
        // populated. It is going to be in our already inflated rootView
        ListView listView = rootView.findViewById(R.id.places_list);

        // Set it to our custom adapter to give it the data
        listView.setAdapter(placeAdapter);


        // Set the {@link OnItemClickListener} so that clicking on an item creates a new Activity
        // showing info about the place
        listView.setOnItemClickListener(new PlaceOnItemClickListener(getContext(), places));

        // Return our rootView object that has been filled with data
        return rootView;
    }

}
