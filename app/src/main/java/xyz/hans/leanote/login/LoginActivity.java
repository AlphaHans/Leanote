package xyz.hans.leanote.login;

import android.os.Bundle;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.hans.leanote.R;
import xyz.hans.leanote.R2;
import xyz.hans.leanote.base.BaseTitleBarActivity;
import xyz.hans.leanote.common.net.RetrofitClient;
import xyz.hans.leanote.common.sp.UserManager;
import xyz.hans.leanote.note.NotesActivity;

public class LoginActivity extends BaseTitleBarActivity {
    private static final String TAG = "LoginActivity";
    @BindView(R2.id.login_et_account)
    EditText mEtAccount;
    @BindView(R2.id.login_et_password)
    EditText mEtPassword;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        setTitle(getString(R.string.app_name));
        setRightText("登录");
        setLeftText("取消");
    }

    @OnClick(R2.id.title_bar_tv_left)
    public void onClickCancel() {
        finish();
    }

    @OnClick(R2.id.title_bar_tv_right)
    public void onClickLogin() {
        String account = mEtAccount.getText().toString();
        String password = mEtPassword.getText().toString();
        Map<String, String> params = new HashMap<>(2);
        params.put("email", account);
        params.put("pwd", password);
        showProgress();
        RetrofitClient.getInstance().getDefault(LoginApi.class)
                .login(params).enqueue(new Callback<UserInfoBean>() {
            @Override
            public void onResponse(Call<UserInfoBean> call, Response<UserInfoBean> response) {
                UserInfoBean bean = response.body();
                if (bean.isOk()) {
                    UserManager.getInstance(LoginActivity.this).saveUserInfo(bean);
                    NotesActivity.startActivity(LoginActivity.this);
                }
                showTitle();
            }

            @Override
            public void onFailure(Call<UserInfoBean> call, Throwable t) {
                showTitle();
            }
        });
    }
}
