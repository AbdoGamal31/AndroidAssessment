package com.androidassessment.retrofitnetwork;

import com.androidassessment.BaseApp;

import okhttp3.Interceptor;

import static com.androidassessment.retrofitnetwork.NetworkUtilities.isNetworkAvailable;

public class CheckConnectionInterceptor {

    public static final Interceptor CHECK_NETWORK_CONNECTION_INTERCEPTOR = chain -> {
        Boolean isConnected = isNetworkAvailable(BaseApp.getContext());
        if (!isConnected) {
            throw NetworkError.createOfflineError();
        } else {
            return chain.proceed(chain.request());
        }
    };
}
