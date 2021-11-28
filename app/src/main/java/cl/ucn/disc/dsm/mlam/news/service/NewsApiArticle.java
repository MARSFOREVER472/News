package cl.ucn.disc.dsm.mlam.news.service;

public class NewsApiArticle {

    public Source source;
    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;
    public String content;

    public class Source {
        public String id;
        public String name;


    }
}
