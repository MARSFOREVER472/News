package cl.ucn.disc.dsm.mlam.news;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import cl.ucn.disc.dsm.mlam.news.model.Article;
import cl.ucn.disc.dsm.mlam.news.model.NewsDao;
import cl.ucn.disc.dsm.mlam.news.model.NewsRoomDatabase;
import cl.ucn.disc.dsm.mlam.news.service.NewsApiService;

public class NewsRepository {

    private NewsDao newsDao;
    private LiveData<List<Article>> allNews;
    private NewsApiService newsApi;

    public NewsRepository(Application application){
        NewsRoomDatabase db = NewsRoomDatabase.getDatabase(application);
        newsDao = db.getNewsDao();
        newsApi = new NewsApiService();
        allNews = newsDao.getAllNews();
    }

    public LiveData<List<Article>> getAllNews() {
        return allNews;
    }

    public void fetchNewsApi(){
        new InsertAsyncTask(newsDao, newsApi).execute();
        allNews = newsDao.getAllNews();
    }

    private class InsertAsyncTask extends AsyncTask<Void, Void, Void> {
        private NewsDao dao;
        private NewsApiService service;

        public InsertAsyncTask(NewsDao newsDao, NewsApiService newsApi) {
            dao = newsDao;
            service = newsApi;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<Article> articles = service.getNews(20);
            for(Article article : articles){
                dao.insertArticle(article);
            }
            return null;
        }
    }
}
