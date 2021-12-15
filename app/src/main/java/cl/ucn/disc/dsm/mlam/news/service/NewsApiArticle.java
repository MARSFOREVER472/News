package cl.ucn.disc.dsm.mlam.news.service;

/**
 * Article from the NewsApi.
 */
public class NewsApiArticle {

    public Source source;
    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;
    public String content;

    /**
     * The source of the article.
     */
    public class Source {
        public String id;
        public String name;


    }
}
