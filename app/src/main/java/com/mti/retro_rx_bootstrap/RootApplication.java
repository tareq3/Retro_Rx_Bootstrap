/*
 * Created by Tareq Islam on 10/25/19 3:19 PM
 *
 *  Last modified 10/25/19 3:19 PM
 */

package com.mti.retro_rx_bootstrap;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mti.retro_rx_bootstrap.utils.Constants;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/***
 * Created by mtita on 25,October,2019.
 */
public class RootApplication extends Application {
    private static Retrofit retrofitInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

    }

    public static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null ) {

            OkHttpClient client = new OkHttpClient.Builder()

                    .connectTimeout(120, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();

            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofitInstance;
    }
}
