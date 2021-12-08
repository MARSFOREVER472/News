package cl.ucn.disc.dsm.mlam.news;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import cl.ucn.disc.dsm.mlam.news.model.Article;

public class NewsViewModel extends AndroidViewModel {

    private NewsRepository repository;
    private LiveData<List<Article>> allNews;

    public LiveData<List<Article>> getAllNews() {
        return allNews;
    }

    public void refresh() {
        repository.fetchNewsApi();
        allNews = repository.getAllNews();
    }

    public NewsViewModel(@NonNull Application application) {
        super(application);
        repository = new NewsRepository(application);
        allNews = repository.getAllNews();
    }
}
