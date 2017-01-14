package xyz.hans.leanote.common.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import xyz.hans.leanote.BuildConfig;

/**
 * Created by Hans on 17/1/14.
 */

public class LogInterceptor implements Interceptor {
    private static final String TAG = "TokenInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Response response = chain.proceed(originalRequest);
        if (BuildConfig.DEBUG) {
            int code = response.code();
            String result = response.body().string();
            Log.d(TAG, String.format("code = %s", code));
            Log.d(TAG, String.format("result = %s", result));
            Log.d(TAG, "headers:" + response.headers().toString());
            ResponseBody body = ResponseBody.create(response.body().contentType(), result);
            response = new Response.Builder()
                    .protocol(response.protocol())
                    .message(response.message())
                    .headers(response.headers())
                    .handshake(response.handshake())
                    .receivedResponseAtMillis(response.receivedResponseAtMillis())
                    .sentRequestAtMillis(response.sentRequestAtMillis())
                    .code(code)
                    .body(body)
                    .cacheResponse(response.cacheResponse())
                    .networkResponse(response.networkResponse())
                    .request(response.request())
                    .build();
        }
        return response;
    }
}
