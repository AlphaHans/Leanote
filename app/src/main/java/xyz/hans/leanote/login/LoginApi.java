package xyz.hans.leanote.login;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Hans on 17/1/12.
 */

public interface LoginApi {
    @POST("auth/login")
    Call<UserInfoBean> login(@QueryMap Map<String,String> params);
}
