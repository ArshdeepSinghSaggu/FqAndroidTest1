package com.example.arsh.fqandroidtest1.network;

import com.example.arsh.fqandroidtest1.model.Coin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/v2/ticker/?convert=INR&limit=100&structure=array")
    Call<Coin> getCoins();
}
