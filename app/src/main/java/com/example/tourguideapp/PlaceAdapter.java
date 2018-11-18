package com.example.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter {

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param places The {@link ArrayList} containing {@link Place} objects
     */
    PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        /*
          Inner class ViewHolder to help implement getView method
         */
        ViewHolder mViewHolder;


        // If the convertView that we receive is null, we will have to inflate one
        if (convertView == null){

            // We do not want to attach it to the parent view yet though
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);

            // Create a new {@link ViewHolder} object to hold the views we need
            mViewHolder = new ViewHolder();

            // Get the {@link View} IDs that we require for the {@link Place} object's name
            // and address
            mViewHolder.placeNameTextView = convertView.findViewById(R.id.place_name);
            mViewHolder.placeAddressTextView = convertView.findViewById(R.id.place_address);

            // Set the tag of the convertView to be our filled {@link ViewHolder}
            convertView.setTag(mViewHolder);
        } else {

            // If the convertView is not null then it means we have already set a tag for it
            // since all the convertViews we will get were constructed from above and will
            // have a viewHolder with the views set as its tag
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        // After getting the {@link View} IDs or reusing the IDs we had stored
        // we need to store the actual data to those views

        // So first we need to get the {@link object} that we want to get its data
        // Its going to be the object at position number position
        Place place = (Place) getItem(position);

        // Ensure that the place object is not empty
        assert place != null;
        mViewHolder.placeNameTextView.setText(place.getName());
        mViewHolder.placeAddressTextView.setText(place.getAddress());

        return convertView;
    }


    /**
     * Inner class to help implement getView method
     */
    private static class ViewHolder{
        /**
         * {@link TextView} for the {@link Place} objects's name
         */
        TextView placeNameTextView;

        /**
         * {@link TextView} for the {@link Place} objects's address
         */
        TextView placeAddressTextView;
    }
}
