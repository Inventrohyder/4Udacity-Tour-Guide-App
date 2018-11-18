package com.example.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
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
public class WorkSpacesFragment extends Fragment {

    public WorkSpacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment and store it as rootView
        // so that we can access it later
        View rootView = inflater.inflate(R.layout.fragment_place_list, container, false);

        // Create our {@link ArrayList} of Work Spaces
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getContext().getString(R.string.work_space_amazon_workspace),
                getContext().getString(R.string.work_space_amazon_workspace_address),
                getContext().getString(R.string.place_description_amazon_workspace),
                R.drawable.amazon_workspace));
        places.add(new Place(getContext().getString(R.string.work_space_peets_coffee),
                getContext().getString(R.string.work_space_peets_coffee_address),
                getContext().getString(R.string.place_description_peets_coffee_description),
                R.drawable.peets_coffee));
        places.add(new Place(getContext().getString(R.string.work_space_coffee_cultures),
                getContext().getString(R.string.work_space_coffee_cultures_address),
                getContext().getString(R.string.place_description_coffee_cultures_description),
                R.drawable.coffee_cultures));
        places.add(new Place(getContext().getString(R.string.work_space_arlequin_cafe),
                getContext().getString(R.string.work_space_arlequin_cafe_address),
                getContext().getString(R.string.place_description_arlequin_cafe_description),
                R.drawable.arlequin_cafe));

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
