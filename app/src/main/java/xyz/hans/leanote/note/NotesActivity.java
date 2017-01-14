package xyz.hans.leanote.note;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.hans.leanote.R;
import xyz.hans.leanote.base.BaseTitleBarActivity;
import xyz.hans.leanote.common.net.RetrofitClient;

/**
 * Created by Hans on 17/1/14.
 */

public class NotesActivity extends BaseTitleBarActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, NotesActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);

        RetrofitClient.getInstance().getDefault(NoteApi.class)
                .getNotebooks(createParams()).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
