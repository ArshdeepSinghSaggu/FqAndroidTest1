
package com.example.arsh.fqandroidtest1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Quotes implements Parcelable {

    @SerializedName("INR")
    private INR mINR;
    @SerializedName("USD")
    private USD mUSD;

    public INR getINR() {
        return mINR;
    }

    public void setINR(INR iNR) {
        mINR = iNR;
    }

    public USD getUSD() {
        return mUSD;
    }

    public void setUSD(USD uSD) {
        mUSD = uSD;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mINR, flags);
        dest.writeParcelable(this.mUSD, flags);
    }

    public Quotes() {
    }

    protected Quotes(Parcel in) {
        this.mINR = in.readParcelable(INR.class.getClassLoader());
        this.mUSD = in.readParcelable(USD.class.getClassLoader());
    }

    public static final Parcelable.Creator<Quotes> CREATOR = new Parcelable.Creator<Quotes>() {
        @Override
        public Quotes createFromParcel(Parcel source) {
            return new Quotes(source);
        }

        @Override
        public Quotes[] newArray(int size) {
            return new Quotes[size];
        }
    };
}
