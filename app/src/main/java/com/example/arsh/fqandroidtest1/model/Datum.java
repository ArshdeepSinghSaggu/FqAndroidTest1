
package com.example.arsh.fqandroidtest1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Datum implements Parcelable {

    @SerializedName("circulating_supply")
    private Double mCirculatingSupply;
    @SerializedName("id")
    private Long mId;
    @SerializedName("last_updated")
    private Long mLastUpdated;
    @SerializedName("max_supply")
    private Double mMaxSupply;
    @SerializedName("name")
    private String mName;
    @SerializedName("quotes")
    private Quotes mQuotes;
    @SerializedName("rank")
    private Long mRank;
    @SerializedName("symbol")
    private String mSymbol;
    @SerializedName("total_supply")
    private Double mTotalSupply;
    @SerializedName("website_slug")
    private String mWebsiteSlug;

    public Double getCirculatingSupply() {
        return mCirculatingSupply;
    }

    public void setCirculatingSupply(Double circulatingSupply) {
        mCirculatingSupply = circulatingSupply;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        mLastUpdated = lastUpdated;
    }

    public Double getMaxSupply() {
        return mMaxSupply;
    }

    public void setMaxSupply(Double maxSupply) {
        mMaxSupply = maxSupply;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Quotes getQuotes() {
        return mQuotes;
    }

    public void setQuotes(Quotes quotes) {
        mQuotes = quotes;
    }

    public Long getRank() {
        return mRank;
    }

    public void setRank(Long rank) {
        mRank = rank;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public void setSymbol(String symbol) {
        mSymbol = symbol;
    }

    public Double getTotalSupply() {
        return mTotalSupply;
    }

    public void setTotalSupply(Double totalSupply) {
        mTotalSupply = totalSupply;
    }

    public String getWebsiteSlug() {
        return mWebsiteSlug;
    }

    public void setWebsiteSlug(String websiteSlug) {
        mWebsiteSlug = websiteSlug;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mCirculatingSupply);
        dest.writeValue(this.mId);
        dest.writeValue(this.mLastUpdated);
        dest.writeValue(this.mMaxSupply);
        dest.writeString(this.mName);
        dest.writeParcelable(this.mQuotes, flags);
        dest.writeValue(this.mRank);
        dest.writeString(this.mSymbol);
        dest.writeValue(this.mTotalSupply);
        dest.writeString(this.mWebsiteSlug);
    }

    public Datum() {
    }

    protected Datum(Parcel in) {
        this.mCirculatingSupply = (Double) in.readValue(Double.class.getClassLoader());
        this.mId = (Long) in.readValue(Long.class.getClassLoader());
        this.mLastUpdated = (Long) in.readValue(Long.class.getClassLoader());
        this.mMaxSupply = (Double) in.readValue(Double.class.getClassLoader());
        this.mName = in.readString();
        this.mQuotes = in.readParcelable(Quotes.class.getClassLoader());
        this.mRank = (Long) in.readValue(Long.class.getClassLoader());
        this.mSymbol = in.readString();
        this.mTotalSupply = (Double) in.readValue(Double.class.getClassLoader());
        this.mWebsiteSlug = in.readString();
    }

    public static final Parcelable.Creator<Datum> CREATOR = new Parcelable.Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel source) {
            return new Datum(source);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };
}
