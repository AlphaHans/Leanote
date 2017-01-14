package xyz.hans.leanote.common.net;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by Hans on 17/1/14.
 */

class MemoryCookieJar implements CookieJar {
    private static Map<String, List<Cookie>> mCookieMap = new HashMap<>();

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        List<Cookie> oldCookies = mCookieMap.get(url.host());
        if (oldCookies == null) oldCookies = new ArrayList<>();
        List<Cookie> needRemove = new ArrayList<>();

        for (Cookie newCookie : cookies) {
            for (Cookie oldCookie : oldCookies) {
                if (newCookie.name().equals(oldCookie.name())) {
                    needRemove.add(oldCookie);
                }
            }
        }

        oldCookies.removeAll(needRemove);
        oldCookies.addAll(cookies);
        mCookieMap.put(url.host(), oldCookies);
        Log.d(TAG, "saveFromResponse: " + oldCookies.toString());
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = mCookieMap.get(url.host());
        if (cookies == null) cookies = new ArrayList<>();
        Log.d(TAG, "cookies : " + cookies.toString());
        return cookies;
    }

    private static final String TAG = "MemoryCookieJar";
}
