package cl.ucn.disc.dsm.mlam.news.service;

import java.util.List;

import retrofit2.Call;

public interface Backend {

    Call<List<BackendArticle>> getNews();
}
