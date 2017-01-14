package xyz.hans.leanote.base;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import xyz.hans.leanote.R;

/**
 * Created by Hans on 17/1/12.
 */

public abstract class BaseTitleBarActivity extends BaseActivity {
    protected TextView mTvLeft, mTvRight, mTvTitle;
    protected ProgressBar mProgressBar;
    protected String mTitle;

    @Override
    protected void init(Bundle savedInstanceState) {
        mTvLeft = (TextView) findViewById(R.id.title_bar_tv_left);
        mTvTitle = (TextView) findViewById(R.id.title_bar_tv_title);
        mTvRight = (TextView) findViewById(R.id.title_bar_tv_right);
        mProgressBar = (ProgressBar) findViewById(R.id.title_bar_progress_bar);
    }

    protected void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mTvTitle.setText("验证中...");
    }

    protected void showTitle() {
        mProgressBar.setVisibility(View.GONE);
        mTvTitle.setText(mTitle);
    }

    protected void setTitle(String title) {
        mTitle = title;
        mTvTitle.setText(title);
    }

    protected void setLeftText(String text) {
        mTvLeft.setText(text);
    }

    protected void setRightText(String text) {
        mTvRight.setText(text);
    }
}
