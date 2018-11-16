package com.example.arsh.fqandroidtest1.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arsh.fqandroidtest1.CoinDetailActivity;
import com.example.arsh.fqandroidtest1.Interface.ILoadmore;
import com.example.arsh.fqandroidtest1.model.Datum;
import com.example.arsh.fqandroidtest1.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.util.ArrayList;
import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Activity activity;
    List<Datum> items;

    int visibleThreshold = 5, lastVisibleItem, totalItemCount;

    public CoinAdapter(RecyclerView recyclerView ,Activity activity) {
        this.activity = activity;
        this.items = new ArrayList<>();
    }

    public void updateList( List<Datum> items){
        this.items.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(activity)
                .inflate(R.layout.coin_layout,viewGroup,false);

        return new CoinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        final Datum item= items.get(position);
        CoinViewHolder holderItem =(CoinViewHolder)viewHolder;
        holderItem.coin_name.setText(item.getName());
        holderItem.coin_symbol.setText(item.getSymbol());
        holderItem.coin_price.setText(item.getQuotes().getINR().getPrice().toString());
        holderItem.one_hour_change.setText(item.getQuotes().getINR().getPercentChange1H()+"%");
        holderItem.twenty_hour_change.setText(item.getQuotes().getINR().getPercentChange24H()+"%");
        holderItem.seven_days_change.setText(item.getQuotes().getINR().getPercentChange7D()+"%");

//        //Load Image
        Picasso.get()
                .load(new StringBuilder("https://res.cloudinary.com/dxi90ksom/image/upload/")
                .append(item.getSymbol().toLowerCase()).append(".png").toString()).into(holderItem.coin_icon);

        holderItem.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(activity,CoinDetailActivity.class);
                intent.putExtra("COIN_EXTRA",item);
                activity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
