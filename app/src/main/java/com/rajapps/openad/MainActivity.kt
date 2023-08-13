package com.rajapps.openad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback

class MainActivity : AppCompatActivity() {
    private var mAppOpenAd: AppOpenAd? = null
    private var isShowingAd = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }



    private fun showOpenAd() {
        val adRequest = AdRequest.Builder().build()
        AppOpenAd.load(this, "ca-app-pub-3940256099942544/3419835294",
            adRequest,
            AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
            object : AppOpenAdLoadCallback() {
                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    super.onAdFailedToLoad(loadAdError)
                }

                override fun onAdLoaded(appOpenAd: AppOpenAd) {
                    super.onAdLoaded(appOpenAd)
                    mAppOpenAd = appOpenAd
                    if (!isShowingAd) {
                        mAppOpenAd!!.show(this@MainActivity)
                        isShowingAd = true
                    }
                }
            })
    }

    override fun onResume() {
        super.onResume()
        if (!isShowingAd) {
            showOpenAd()
        }
    }



}