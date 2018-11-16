package com.example.arsh.fqandroidtest1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.arsh.fqandroidtest1.Adapter.CoinAdapter;
import com.example.arsh.fqandroidtest1.model.Coin;
import com.example.arsh.fqandroidtest1.network.ApiInterface;
import com.example.arsh.fqandroidtest1.network.RetrofitClient;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CoinAdapter adapter;
    private LinearLayoutManager layoutManager;
    private boolean loadmore=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_list);

        recyclerView= (RecyclerView)findViewById(R.id.recyclerView);
        adapter = new CoinAdapter(recyclerView,this);
        layoutManager = new LinearLayoutManager(CoinListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        getCoins();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                // super.onScrolled(recyclerView, dx, dy);
                int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();
                if (lastVisiblePosition == recyclerView.getChildCount()) {
                    if (loadmore) {
                        loadmore = false;
                        getCoins();

                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.signout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
               signout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void signout() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(CoinListActivity.this, "User Signed Out", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    private void getCoins() {


        ApiInterface service = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<Coin> call = service.getCoins();
        call.enqueue(new Callback<Coin>() {
            @Override
            public void onResponse(Call<Coin> call, Response<Coin> response) {

                showList(response.body());
                Log.d("TAG", "onResponse:  "+ response.body());

            }

            @Override
            public void onFailure(Call<Coin> call, Throwable t) {
//                progressDoalog.dismiss();
//                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showList(Coin coin)
    {
        adapter.updateList(coin.getData());
        loadmore=true;
    }
}

