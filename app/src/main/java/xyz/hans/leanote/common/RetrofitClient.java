package xyz.hans.leanote.common;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hans on 17/1/12.
 */

public class RetrofitClient {
    public static final String HOST_URL = "https://leanote.com/api/";

    private static RetrofitClient INSTANCE;

    public static RetrofitClient getInstance() {
        if (INSTANCE == null) {
            synchronized (RetrofitClient.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RetrofitClient();
                }
            }
        }
        return INSTANCE;
    }


    public void init(Context context) {
        context = context.getApplicationContext();
    }

    private Retrofit mDefaultRetrofit;

    public <T> T getDefault(Class<T> api) {
        if (mDefaultRetrofit == null) {
            mDefaultRetrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(HOST_URL)
                    .build();
        }
        return  mDefaultRetrofit.create(api);
    }
}
