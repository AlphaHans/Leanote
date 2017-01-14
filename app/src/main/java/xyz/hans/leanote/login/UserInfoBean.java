package xyz.hans.leanote.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hans on 17/1/12.
 */

public class UserInfoBean {
    /**
     * Ok : true
     * Token : 5500830738f41138e90003232
     * UserId : 52d26b4e99c37b609a000001
     * Email : leanote@leanote.com
     * Username : leanote
     */
    @SerializedName("Ok")
    private boolean ok;
    @SerializedName("Token")
    private String token;
    @SerializedName("UserId")
    private String userId;
    @SerializedName("Email")
    private String email;
    @SerializedName("Username")
    private String userName;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "ok=" + ok +
                ", token='" + token + '\'' +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
