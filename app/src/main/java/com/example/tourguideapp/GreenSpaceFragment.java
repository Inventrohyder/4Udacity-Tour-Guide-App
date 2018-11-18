package com.example.tourguideapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import java.util.ArrayList;

/**
 * A fragment representing a list of {@link Place} Items.
 */
public class GreenSpaceFragment extends Fragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GreenSpaceFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment and store it as rootView
        // so that we can access it later
        View rootView = inflater.inflate(R.layout.fragment_place_list, container, false);

        // Create our {@link ArrayList} of Work Spaces
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getContext().getString(R.string.green_space_mission_dolores_park),
                getContext().getString(R.string.green_space_mission_dolores_park_address),
                getContext().getString(R.string.place_description_mission_dolores_park_description)));
        places.add(new Place(getContext().getString(R.string.green_space_yerba_buena_gardens),
                getContext().getString(R.string.green_space_yerba_buena_gardens_address),
                getContext().getString(R.string.place_description_yerba_buena_gardens_description)));
        places.add(new Place(getContext().getString(R.string.green_space_golden_gate_park),
                getContext().getString(R.string.green_space_golden_gate_park_address),
                getContext().getString(R.string.place_description_golden_gate_park_description)));
        places.add(new Place(getContext().getString(R.string.green_space_bernal_heights_park),
                getContext().getString(R.string.green_space_bernal_heights_park_address),
                getContext().getString(R.string.place_description_bernal_heights_park_description)));
        places.add(new Place(getContext().getString(R.string.green_space_bernal_heights_park),
                getContext().getString(R.string.green_space_bernal_heights_park_address),
                getContext().getString(R.string.place_description_bernal_heights_park_description)));
        places.add(new Place(getContext().getString(R.string.green_space_corona_heights),
                getContext().getString(R.string.green_space_corona_heights_address),
                getContext().getString(R.string.place_description_corona_heights_description)));
        places.add(new Place(getContext().getString(R.string.green_space_lands_end_lookout),
                getContext().getString(R.string.green_space_lands_end_lookout_address),
                getContext().getString(R.string.place_description_lands_end_lookout_description)));
        places.add(new Place(getContext().getString(R.string.green_space_san_francisco_botanical_gardens),
                getContext().getString(R.string.green_space_san_francisco_botanical_gardens_address),
                getContext().getString(R.string.place_description_san_francisco_botanical_gardens_description)));
        places.add(new Place(getContext().getString(R.string.green_space_twin_peaks),
                getContext().getString(R.string.green_space_twin_peaks_address),
                getContext().getString(R.string.place_description_twin_peaks_description)));
        places.add(new Place(getContext().getString(R.string.green_space_balboa_park),
                getContext().getString(R.string.green_space_balboa_park_address),
                getContext().getString(R.string.place_description_balboa_park_description)));
        places.add(new Place(getContext().getString(R.string.green_space_buena_vista_park),
                getContext().getString(R.string.green_space_buena_vista_park_address),
                getContext().getString(R.string.place_description_buena_vista_park_description)));
        // Add our {@link ArrayList} to our custom {@link ArrayAdapter} so that we can pass it
        // to our {@link ListView} hence populating it with our {@link Place} objects correctly
        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), places);

        // Find our chosen {@link ListView} so that we can set our chosen adapter to have it get
        // populated. It is going to be in our already inflated rootView
        ListView listView = rootView.findViewById(R.id.places_list);

        // Set it to our custom adapter to give it the data
        listView.setAdapter(placeAdapter);


        // Set the {@link OnItemClickListener} so that clicking on an item creates a new Fragment
        // showing info about the place
        listView.setOnItemClickListener(new PlaceOnItemClickListener(getContext(), places));

        // Return our rootView object that has been filled with data
        return rootView;
    }

}

