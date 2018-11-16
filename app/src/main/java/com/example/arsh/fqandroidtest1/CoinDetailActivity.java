package com.example.arsh.fqandroidtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arsh.fqandroidtest1.model.Datum;
import com.squareup.picasso.Picasso;

public class CoinDetailActivity extends AppCompatActivity {

    public ImageView coin_icon;
    public TextView coin_symbol,coin_rate,coin_rank,coin_inr,coin_usd, coin_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_detail);
        
        Datum data= getIntent().getParcelableExtra("COIN_EXTRA");

        coin_icon =(ImageView) findViewById(R.id.imageView);
        coin_symbol =(TextView) findViewById(R.id.coinSymbol);
        coin_name =(TextView) findViewById(R.id.coinName);
        coin_rank = (TextView) findViewById(R.id.coinRank);
        coin_rate = (TextView) findViewById(R.id.coinRate);
        coin_inr = (TextView) findViewById(R.id.coinInr);
        coin_usd =(TextView) findViewById(R.id.coinUsd);

        coin_name.setText(data.getName());
        coin_symbol.setText(data.getSymbol());
        coin_rank.setText("Rank: "+data.getRank());
        coin_inr.setText("INR: "+data.getQuotes().getINR().getPrice());
        coin_usd.setText("USD: "+data.getQuotes().getUSD().getPrice());
        coin_rate.setText(data.getQuotes().getINR().getPercentChange24H()+"%");

        Picasso.get()
                .load(new StringBuilder("https://res.cloudinary.com/dxi90ksom/image/upload/")
                        .append(data.getSymbol().toLowerCase()).append(".png").toString()).into(coin_icon);

        if(data.getQuotes().getINR().getPercentChange24H()>0)
            coin_rate.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_up,0,0,0);
        else
            coin_rate.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_down,0,0,0);



    }
}
