package com.androidassessment.retrofitnetwork;

import android.content.Context;

import com.androidassessment.BaseApp;

import okhttp3.Interceptor;
import okhttp3.Response;

import static com.androidassessment.retrofitnetwork.NetworkUtilities.isNetworkAvailable;

public class CashingInterceptor {

    public static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {
        Context context = BaseApp.getContext();
        Response originalResponse = chain.proceed(chain.request());
        if (isNetworkAvailable(context)) {
            int maxAge = 60;
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28;
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    };

}
