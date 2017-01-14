package xyz.hans.leanote.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import xyz.hans.leanote.common.sp.UserManager;

/**
 * Created by Hans on 17/1/12.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    final protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

    protected abstract int getContentViewId();

    protected abstract void init(Bundle savedInstanceState);

    /**
     * 创建带有token的Map参数集合
     * @return
     */
    public Map<String, String> createParams() {
        Map<String, String> map = new HashMap<>();
        map.put("token", UserManager.getInstance(this).getToken());
        return map;
    }
}
