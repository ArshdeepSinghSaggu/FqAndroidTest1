package com.example.arsh.fqandroidtest1.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arsh.fqandroidtest1.R;

public class CoinViewHolder extends RecyclerView.ViewHolder {
    public ImageView coin_icon;
    public TextView coin_symbol,coin_price, coin_name, one_hour_change, twenty_hour_change, seven_days_change;
    public CoinViewHolder(@NonNull View itemView) {
        super(itemView);

        coin_icon =(ImageView) itemView.findViewById(R.id.coinIcon);
        coin_symbol =(TextView) itemView.findViewById(R.id.coinSymbol);
        coin_name =(TextView) itemView.findViewById(R.id.coinName);
        coin_price = (TextView) itemView.findViewById(R.id.priceInr);
        one_hour_change =(TextView) itemView.findViewById(R.id.oneHour);
        twenty_hour_change =(TextView) itemView.findViewById(R.id.twentyFourHour);
        seven_days_change =(TextView) itemView.findViewById(R.id.sevenDay);

    }
}
