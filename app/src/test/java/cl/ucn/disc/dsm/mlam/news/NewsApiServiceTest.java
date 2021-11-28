package cl.ucn.disc.dsm.mlam.news;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

import cl.ucn.disc.dsm.mlam.news.model.Article;
import cl.ucn.disc.dsm.mlam.news.service.NewsApiService;


public class NewsApiServiceTest {
    @Test
    public void testApiService(){
        NewsApiService service = new NewsApiService();
        List<Article> articles = service.getNews(10);
        for(Article i : articles) {
            System.out.println(i.getTitle());
        }
    }
}