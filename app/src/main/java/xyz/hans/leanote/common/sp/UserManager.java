package xyz.hans.leanote.common.sp;

import android.content.Context;
import android.content.SharedPreferences;

import xyz.hans.leanote.login.UserInfoBean;

/**
 * Created by Hans on 17/1/14.
 */

public class UserManager {
    private static final String SP_NAME = "sp_user_manager";
    private static UserManager mUserManager;
    private SharedPreferences mSp;

    public static UserManager getInstance(Context context) {
        if (mUserManager == null) {
            synchronized (UserManager.class) {
                mUserManager = new UserManager(context.getApplicationContext());
            }
        }
        return mUserManager;
    }

    private UserManager(Context context) {
        mSp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public String getToken() {
        return mSp.getString("token", "");
    }


    public void setToken(String token) {
        mSp.edit().putString("token", token).apply();
    }

    public String getUserId() {
        return mSp.getString("user_id", "");
    }

    public void setUserId(String userId) {
        mSp.edit().putString("user_id", userId).apply();
    }

    public String getEmail() {
        return mSp.getString("email", "");
    }

    public void setEmail(String email) {
        mSp.edit().putString("email", email).apply();
    }

    public String getUserName() {
        return mSp.getString("user_name", "");
    }

    public void setUserName(String userName) {
        mSp.edit().putString("user_name", userName).apply();
    }

    public void saveUserInfo(UserInfoBean bean) {
        String token = bean.getToken();
        setToken(token);
        String email = bean.getEmail();
        setEmail(email);
        String userName = bean.getUserName();
        setUserName(userName);
        String userId = bean.getUserId();
        setUserId(userId);
    }
}
