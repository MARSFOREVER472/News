package cl.ucn.disc.dsm.mlam.news;

import org.junit.Test;

import java.util.List;

import cl.ucn.disc.dsm.mlam.news.model.Article;
import cl.ucn.disc.dsm.mlam.news.service.BackendService;


public class BackendServiceTest {
    @Test
    public void testApiService(){
        BackendService service = new BackendService();
        List<Article> articles = service.getNews();
        for(Article i : articles) {
            System.out.println(i.getTitle());
        }
    }
}