
package com.example.arsh.fqandroidtest1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class INR implements Parcelable {

    @SerializedName("market_cap")
    private Double mMarketCap;
    @SerializedName("percent_change_1h")
    private Double mPercentChange1H;
    @SerializedName("percent_change_24h")
    private Double mPercentChange24H;
    @SerializedName("percent_change_7d")
    private Double mPercentChange7D;
    @SerializedName("price")
    private Double mPrice;
    @SerializedName("volume_24h")
    private Double mVolume24H;

    public Double getMarketCap() {
        return mMarketCap;
    }

    public void setMarketCap(Double marketCap) {
        mMarketCap = marketCap;
    }

    public Double getPercentChange1H() {
        return mPercentChange1H;
    }

    public void setPercentChange1H(Double percentChange1H) {
        mPercentChange1H = percentChange1H;
    }

    public Double getPercentChange24H() {
        return mPercentChange24H;
    }

    public void setPercentChange24H(Double percentChange24H) {
        mPercentChange24H = percentChange24H;
    }

    public Double getPercentChange7D() {
        return mPercentChange7D;
    }

    public void setPercentChange7D(Double percentChange7D) {
        mPercentChange7D = percentChange7D;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public Double getVolume24H() {
        return mVolume24H;
    }

    public void setVolume24H(Double volume24H) {
        mVolume24H = volume24H;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mMarketCap);
        dest.writeValue(this.mPercentChange1H);
        dest.writeValue(this.mPercentChange24H);
        dest.writeValue(this.mPercentChange7D);
        dest.writeValue(this.mPrice);
        dest.writeValue(this.mVolume24H);
    }

    public INR() {
    }

    protected INR(Parcel in) {
        this.mMarketCap = (Double) in.readValue(Double.class.getClassLoader());
        this.mPercentChange1H = (Double) in.readValue(Double.class.getClassLoader());
        this.mPercentChange24H = (Double) in.readValue(Double.class.getClassLoader());
        this.mPercentChange7D = (Double) in.readValue(Double.class.getClassLoader());
        this.mPrice = (Double) in.readValue(Double.class.getClassLoader());
        this.mVolume24H = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<INR> CREATOR = new Parcelable.Creator<INR>() {
        @Override
        public INR createFromParcel(Parcel source) {
            return new INR(source);
        }

        @Override
        public INR[] newArray(int size) {
            return new INR[size];
        }
    };
}
