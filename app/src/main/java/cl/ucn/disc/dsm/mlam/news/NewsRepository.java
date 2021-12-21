package cl.ucn.disc.dsm.mlam.news;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import cl.ucn.disc.dsm.mlam.news.model.Article;
import cl.ucn.disc.dsm.mlam.news.model.NewsDao;
import cl.ucn.disc.dsm.mlam.news.model.NewsRoomDatabase;
import cl.ucn.disc.dsm.mlam.news.service.BackendService;

/**
 * The repository.
 */
public class NewsRepository {

    /**
     * The dao.
     */
    private NewsDao newsDao;
    /**
     * The list of articles.
     */
    private LiveData<List<Article>> allNews;
    /**
     * The backend service.
     */
    private BackendService backend;

    /**
     * Constructor.
     *
     * @param application
     */
    public NewsRepository(Application application) {
        NewsRoomDatabase db = NewsRoomDatabase.getDatabase(application);
        newsDao = db.getNewsDao();
        backend = new BackendService();
        allNews = newsDao.getAllNews();
    }

    /**
     * Return all news.
     *
     * @return
     */
    public LiveData<List<Article>> getAllNews() {
        return allNews;
    }

    /**
     * Fetch the NewsApi Service.
     */
    public void fetchNewsApi() {
        new InsertAsyncTask(newsDao, backend).execute();
        allNews = newsDao.getAllNews();
    }

    /**
     * Async Task to insert NewsApi articles to database.
     */
    private class InsertAsyncTask extends AsyncTask<Void, Void, Void> {
        private NewsDao dao;
        private BackendService service;

        public InsertAsyncTask(NewsDao newsDao, BackendService backend) {
            dao = newsDao;
            service = backend;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<Article> articles = service.getNews();
            for (Article article : articles) {
                dao.insertArticle(article);
            }
            return null;
        }
    }
}
