package cl.ucn.disc.dsm.mlam.news.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dsm.mlam.news.model.Article;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsApiService {

    private NewsApi newsApi;

    public NewsApiService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        newsApi = retrofit.create(NewsApi.class);
    }

    /**
     * Get News from news Api Web and transforms to article.
     *
     * @param pageSize: number of articles to return
     * @return a List Of Article
     */
    public List<Article> getNews(int pageSize) {
        Call<NewsApiResult> call = newsApi.getTopHeadLines(pageSize);
        try {
            Response<NewsApiResult> response = call.execute();
            NewsApiResult result = response.body();

            List<Article> articles = new ArrayList<Article>();
            for (NewsApiArticle a : result.articles) {
                articles.add(new Article(a.title, a.description, a.author,
                        a.publishedAt, a.source.name, a.url, a.urlToImage));
            }
            return articles;

        } catch (IOException e) {
            return new ArrayList<Article>();
        }
    }
}
