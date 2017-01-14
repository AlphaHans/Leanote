package xyz.hans.leanote.common.net;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.hans.leanote.common.sp.UserManager;

/**
 * Created by Hans on 17/1/12.
 */

public class RetrofitClient {
    public static final String HOST_URL = "https://leanote.com/api/";
    private Context mContext;
    private static RetrofitClient INSTANCE;
    private OkHttpClient mOkHttpClient;

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
        mContext = context.getApplicationContext();
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor(context))
                .cookieJar(new MemoryCookieJar())
                .build();
    }

    private Retrofit mDefaultRetrofit;

    public <T> T getDefault(Class<T> api) {
        if (mDefaultRetrofit == null) {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(HOST_URL);
            if (mOkHttpClient != null)
                builder.client(mOkHttpClient);
            mDefaultRetrofit = builder.build();
        }
        return mDefaultRetrofit.create(api);
    }


    public Map<String, String> createParams() {
        Map<String, String> map = new HashMap<>();
        map.put("token", UserManager.getInstance(mContext).getToken());
        return map;
    }
}
