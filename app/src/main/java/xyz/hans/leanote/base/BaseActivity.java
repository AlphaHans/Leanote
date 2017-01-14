package xyz.hans.leanote.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

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

}
