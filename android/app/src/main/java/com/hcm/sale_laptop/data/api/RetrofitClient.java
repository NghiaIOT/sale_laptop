package com.hcm.sale_laptop.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.Strictness;

import java.util.concurrent.TimeUnit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    // local host for simulator
//    public static final String BASE_URL = "http://10.0.2.2:3000/";

    public static final String BASE_URL = "https://cf11-2402-800-6294-4913-751c-31fb-d302-aa10.ngrok-free.app";

    private static Retrofit retrofit;

    // Singleton Retrofit instance
    public static Retrofit getInstance() {
        if (retrofit == null) {
            // Tạo Gson instance
            final Gson gson = new GsonBuilder()
                    .setStrictness(Strictness.LENIENT) // Sử dụng khi dữ liệu không chuẩn JSON
                    .create();

            // Tạo interceptor để log thông tin request và response
            final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            // Tạo OkHttpClient với timeout
            final int timeout = 60;
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(timeout, TimeUnit.SECONDS)
                    .readTimeout(timeout, TimeUnit.SECONDS)
                    .writeTimeout(timeout, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .build();

            // Khởi tạo Retrofit
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson)) // Converter cho Gson
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Adapter cho RxJava
                    .build();

        }
        return retrofit;
    }
}


