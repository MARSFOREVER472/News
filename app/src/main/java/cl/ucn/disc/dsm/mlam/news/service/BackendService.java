package cl.ucn.disc.dsm.mlam.news.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dsm.mlam.news.model.Article;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The backend service.
 */
public class BackendService {

    private Backend backend;

    /**
     * Constructor.
     */
    public BackendService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        backend = retrofit.create(Backend.class);
    }

    /**
     * Get all the news from the backend.
     *
     * @return
     */
    public List<Article> getNews() {

        Call<List<BackendArticle>> call = backend.getNews();

        try {
            Response<List<BackendArticle>> response = call.execute();
            List<BackendArticle> result = response.body();

            List<Article> articles = new ArrayList<Article>();
            for (BackendArticle a : result) {
                articles.add(new Article(a.title, a.description, a.author, a.publishedAt,
                        a.source, a.sourceUrl, a.imageUrl));
            }

            return articles;

        } catch (IOException e) {
            return new ArrayList<Article>();
        }
    }
}
