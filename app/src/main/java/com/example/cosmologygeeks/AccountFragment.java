package com.example.cosmologygeeks;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    TextView payment,rate,feedback,about,share,logout;
    private RewardedAd rewardedAd;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v=inflater.inflate(R.layout.fragment_account, container, false);
        payment=v.findViewById(R.id.payment);
        rate=v.findViewById(R.id.rateus);
        feedback=v.findViewById(R.id.feedback);
        about=v.findViewById(R.id.aboutus);
        share=v.findViewById(R.id.share);
        logout=v.findViewById(R.id.logout);

        MobileAds.initialize(v.getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        onLoad();


        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAd();
                Uri uri;
                Intent intent=new Intent(v.getContext(), RazorPayActivity.class);
                startActivity(intent);
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAd();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAd();
                Intent intent=new Intent(v.getContext(), AbousUsActivity.class);
                startActivity(intent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: playstore");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return v;
    }
    private void onLoad()
    {
        this.rewardedAd = new RewardedAd(getContext(),
                getString(R.string.rewarded_ad_unit_id));

        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
                super.onRewardedAdLoaded();
                Log.i("Tag","Reward Added Successfully");
            }

            @Override
            public void onRewardedAdFailedToLoad(int errorCode) {
                // Ad failed to load.
                Log.i("Tag","Reward Failed");
            }
        };
        this.rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
    }

    public void showAd()
    {
        if (rewardedAd.isLoaded()) {

            RewardedAdCallback adCallback = new RewardedAdCallback() {
                @Override
                public void onRewardedAdOpened() {
                    // Ad opened.
                    super.onRewardedAdOpened();
                }

                @Override
                public void onRewardedAdClosed() {
                    // Ad closed.
                    super.onRewardedAdClosed();
                    onLoad();
                }

                @Override
                public void onUserEarnedReward(@NonNull RewardItem reward) {
                    // User earned reward.
                }

                @Override
                public void onRewardedAdFailedToShow(int errorCode) {
                    // Ad failed to display.
                }
            };
            this.rewardedAd.show(this.getActivity(), adCallback);
        } else {
            Log.d("TAG", "The rewarded ad wasn't loaded yet.");
        }
    }
}
