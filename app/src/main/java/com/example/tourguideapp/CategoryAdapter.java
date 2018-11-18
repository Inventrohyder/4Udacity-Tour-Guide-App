package com.example.tourguideapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes
     */
    CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new WorkSpacesFragment();
            case 1:
                return new StayingActiveFragment();
            case 2:
                return new FoodDrinkFragment();
            case 3:
                return new GreenSpaceFragment();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return mContext.getString(R.string.work_spaces);
            case 1:
                return mContext.getString(R.string.stay_active);
            case 2:
                return mContext.getString(R.string.food_drink);
            case 3:
                return mContext.getString(R.string.green_space);
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return 4;
    }
}
