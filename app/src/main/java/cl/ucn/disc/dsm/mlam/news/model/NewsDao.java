package cl.ucn.disc.dsm.mlam.news.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NewsDao {

    @Insert
    public void insertArticle(Article article);

    @Query("DELETE FROM articles")
    public void deleteAll();

    @Query("SELECT * FROM articles ORDER BY publishedAt DESC")
    public LiveData<List<Article>> getAllNews();
}
