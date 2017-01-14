package xyz.hans.leanote.note;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Hans on 17/1/14.
 */

public interface NoteApi {

    @POST("notebook/getNotebooks")
    Call<String> getNotebooks(@QueryMap Map<String,String> map);
}
