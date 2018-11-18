package com.example.tourguideapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Place implements Parcelable {

    /**
     * This is the name of the place
     */
    private String  mName;

    /**
     * This is the Address of the place
     */
    private String mAddress;

    /**
     * This is the description of the place
     */
    private String mDescription;

    /**
     * This is the ID of the picture of this {@link Place} object
     */
    private int mPicture;

    /**
     * Constructor for {@link Place}
     * @param name is the name of the place
     * @param address is the physical address of the place
     * @param picture is the ID of the picture of the place
     * @param  description is the description of the place
     */
    Place(String name, String address, String description, int picture){
        this.mName = name;
        this.mAddress = address;
        this.mDescription = description;
        this.mPicture = picture;
    }

    /**
     * Constructor for {@link Place}
     * @param name is the name of the place
     * @param address is the physical address of the place
     */
    Place(String name, String address){
        this(name, address, "", R.mipmap.ic_launcher);
    }

    /**
     * Constructor for {@link Place}
     * @param name is the name of the {@link Place} object
     * @param address is the address of the {@link Place} object
     * @param description is the description of the {@link Place} object
     */
    public Place(String name, String address, String description) {
        this(name, address, description, R.mipmap.ic_launcher);
    }

    protected Place(Parcel in) {
        mName = in.readString();
        mAddress = in.readString();
        mDescription = in.readString();
        mPicture = in.readInt();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    /**
     * Get the address of the place
     * @return the address of the place
     */
    String getAddress(){
        return mAddress;
    }

    /**
     * Get the name of the place
     * @return the name of the place
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the ID of the picture of the place
     * @return the pictures of the place.
     */
    public int getPicture() {
        return mPicture;
    }

    /**
     * Gets the description of the place
     * @return the description of the place
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
        dest.writeString(this.mAddress);
        dest.writeString(this.mDescription);
        dest.writeInt(this.mPicture);
    }


}
