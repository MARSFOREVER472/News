package cl.ucn.disc.dsm.mlam.news.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")
public class Article {

    @PrimaryKey(autoGenerate = true)
    int id;

    String title;
    String description;
    String author;
    String publishedAt;
    String source;
    String url;
    String imageUrl;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Article(String title, String description, String author, String publishedAt, String source, String url, String imageUrl) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.publishedAt = publishedAt;
        this.source = source;
        this.url = url;
        this.imageUrl = imageUrl;
    }
}
