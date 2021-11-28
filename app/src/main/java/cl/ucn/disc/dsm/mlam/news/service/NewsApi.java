package cl.ucn.disc.dsm.mlam.news.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NewsApi {


    final String API_KEY = "";

    @Headers({"X-Api-Key: "+API_KEY})
    @GET("top-headlines?language=es")
    Call<NewsApiResult> getTopHeadLines(@Query("pageSize") int pageSize);
}
