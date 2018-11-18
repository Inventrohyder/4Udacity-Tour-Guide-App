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
public class FoodDrinkFragment extends Fragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FoodDrinkFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment and store it as rootView
        // so that we can access it later
        View rootView = inflater.inflate(R.layout.fragment_place_list, container, false);

        // Create our {@link ArrayList} of Work Spaces
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getContext().getString(R.string.food_drink_trader_joes_1),
                getContext().getString(R.string.food_drink_trader_joes_1_address),
                getContext().getString(R.string.place_description_trader_joes_1_description)));
        places.add(new Place(getContext().getString(R.string.food_drink_trader_joes_2),
                getContext().getString(R.string.food_drink_trader_joes_2_address),
                getContext().getString(R.string.place_description_trader_joes_2_description)));
        places.add(new Place(getContext().getString(R.string.food_drink_mi_tierra_market),
                getContext().getString(R.string.food_drink_mi_tierra_market_address),
                getContext().getString(R.string.place_description_mi_tierra_market_description)));
        places.add(new Place(getContext().getString(R.string.food_drink_foods_co),
                getContext().getString(R.string.food_drink_foods_co_address),
                getContext().getString(R.string.place_description_foodsco_description)));
        places.add(new Place(getContext().getString(R.string.food_drink_grocery_outlet_bargain_market),
                getContext().getString(R.string.food_drink_grocery_outlet_bargain_market_address),
                getContext().getString(R.string.place_description_grocery_outlet_bargain_market_description)));
        places.add(new Place(getContext().getString(R.string.food_drink_costco_wholesale),
                getContext().getString(R.string.food_drink_costco_wholesale_address),
                getContext().getString(R.string.place_description_costco_wholesale_description)));
        places.add(new Place(getContext().getString(R.string.food_drink_safeway),
                getContext().getString(R.string.food_drink_safeway_address),
                getContext().getString(R.string.place_description_safeway_description)));

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
