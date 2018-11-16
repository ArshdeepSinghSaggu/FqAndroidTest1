
package com.example.arsh.fqandroidtest1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Coin {

    @SerializedName("data")
    private List<Datum> mData;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

}
