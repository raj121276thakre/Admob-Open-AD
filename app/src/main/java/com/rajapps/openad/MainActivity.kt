package com.rajapps.openad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

public class MainActivity extends AppCompatActivity {


    private AppOpenAd mAppOpenAd;

    private boolean isShowingAd = false;
    private void showOpenAd(){

        AdRequest adRequest = new AdRequest.Builder().build();
        AppOpenAd.load(this, "ca-app-pub-3940256099942544/3419835294",
                adRequest,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                new AppOpenAd.AppOpenAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                    }

                    @Override
                    public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                        super.onAdLoaded(appOpenAd);
                        mAppOpenAd = appOpenAd;

                        if(!isShowingAd) {
                            mAppOpenAd.show(MainActivity.this);
                            isShowingAd = true;
                        }
                    }
                });
    }
    @Override
    protected void onResume() {
        super.onResume();

        if(!isShowingAd) {
            showOpenAd();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}