package com.example.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

/**
 * Custom {@link android.widget.AdapterView.OnItemClickListener} to handle click events of
 * an item in a list of {@link Place} objects found in a {@link android.widget.ListView}
 */
public class PlaceOnItemClickListener implements AdapterView.OnItemClickListener {

    /**
     * The {@link android.content.Context} of the application
     */
    private Context mContext;

    /**
     * The ArrayList containing our list of {@link Place} objects
     */
    private ArrayList<Place> mArrayList;

    /**
     * Public constructor to create a new {@link PlaceOnItemClickListener} that will be having
     * the correct data
     * @param context is the {@link Context} of the application
     * @param arrayList contains the list of {@link Place} objects
     */
    public PlaceOnItemClickListener(Context context, ArrayList<Place> arrayList) {
        this.mContext = context;
        this.mArrayList = arrayList;
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Get the {@link Place} object name, address, and description so that we can send
        // them as part of an intent to another activity
        String placeName = mArrayList.get(position).getName();
        String placeAddress = mArrayList.get(position).getAddress();
        String placeDescription = mArrayList.get(position).getDescription();


        // Create a new intent that moves from the current context to the
        // {@link PlaceDescription} activity
        Intent intent = new Intent(mContext, PlaceDescription.class);

        // Send the {@link Place} object at position to the next activity
        intent.putExtra(PlaceDescription.PLACE, mArrayList.get(position));

        // Start the implicit intent to open the {@link PlaceDescription} activity
        mContext.startActivity(intent);
    }
}
