package xyz.hans.leanote.common;

import android.app.Application;

/**
 * Created by Hans on 17/1/12.
 */

public class LNApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient.getInstance().init(this);
    }
}
