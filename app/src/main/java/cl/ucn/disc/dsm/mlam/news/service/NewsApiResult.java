package cl.ucn.disc.dsm.mlam.news.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Result from the NewsApi.
 */
public class NewsApiResult {

    public String status;
    public long totalResults;
    public List<NewsApiArticle> articles = new ArrayList<NewsApiArticle>();
}
