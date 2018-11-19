package com.androidassessment.retrofitnetwork.component;

import android.content.Context;

import com.androidassessment.BaseApp;
import com.androidassessment.retrofitnetwork.module.ApplicationModule;
import com.androidassessment.retrofitnetwork.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

import static com.androidassessment.BaseApp.BASE_URL;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface NetworkComponent {

    // void inject(NewsRemoteDataStore newsDataStore);

    class Initializer {

        private static NetworkComponent component;

        public static NetworkComponent buildComponent() {
            if (component == null) {
                Context context = BaseApp.getContext();
                component = DaggerNetworkComponent.builder()
                        .applicationModule(new ApplicationModule(context))
                        .networkModule(new NetworkModule(BASE_URL))
                        .build();
            }
            return component;
        }
    }
}