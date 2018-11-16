package com.example.arsh.fqandroidtest1;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    public static final int RC_SIGN_IN = 1;
    private FirebaseAuth.AuthStateListener mAuthStateListner;

    List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.EmailBuilder().build(),
            new AuthUI.IdpConfig.PhoneBuilder().build(),
            new AuthUI.IdpConfig.GoogleBuilder().build());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void setAuth(){
        if(checkInternet()) {
            mFirebaseAuth = FirebaseAuth.getInstance();
            mAuthStateListner = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user != null) {
                        Toast.makeText(MainActivity.this, "User Signed In", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, CoinListActivity.class));
                    } else {

                        startActivityForResult(
                                AuthUI.getInstance()
                                        .createSignInIntentBuilder()
                                        .setIsSmartLockEnabled(false)
                                        .setAvailableProviders(providers)
                                        .build(),
                                RC_SIGN_IN
                        );
                    }


                }
            };
            mFirebaseAuth.addAuthStateListener(mAuthStateListner);
        }
        else {

            Toast.makeText(MainActivity.this,"Please check your internet connection!",Toast.LENGTH_SHORT).show();
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
        }

    }

    private boolean checkInternet()
    {
        ConnectivityManager conMgr =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        return netInfo!=null;
    }
    @Override
    protected void onResume() {
        super.onResume();
            setAuth();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mFirebaseAuth!=null)
            mFirebaseAuth.removeAuthStateListener(mAuthStateListner);

    }



}
