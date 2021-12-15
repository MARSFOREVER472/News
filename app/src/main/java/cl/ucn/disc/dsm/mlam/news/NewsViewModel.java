package cl.ucn.disc.dsm.mlam.news;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import cl.ucn.disc.dsm.mlam.news.model.Article;

/**
 * The news view model.
 */
public class NewsViewModel extends AndroidViewModel {

    /**
     * The repository.
     */
    private NewsRepository repository;
    /**
     * The list of articles.
     */
    private LiveData<List<Article>> allNews;

    /**
     * Return all news.
     *
     * @return
     */
    public LiveData<List<Article>> getAllNews() {
        return allNews;
    }

    /**
     * Call the repository to update the news.
     */
    public void refresh() {
        repository.fetchNewsApi();
        allNews = repository.getAllNews();
    }

    /**
     * Constructor.
     *
     * @param application
     */
    public NewsViewModel(@NonNull Application application) {
        super(application);
        repository = new NewsRepository(application);
        allNews = repository.getAllNews();
    }
}
