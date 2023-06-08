package sg.iss.cryptonews.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.*;

import sg.iss.cryptonews.model.Article;
import sg.iss.cryptonews.model.Articles;

@Service
public class CryptoService {
    @Value("${crypto.app.url}")
    private String cryptoArticleUrl;

    @Value("${crypto.app.apikey}")
    private String cryptoArticleApiKey;

    public List<Article> getArticles() throws IOException{   
        String articleUrl = UriComponentsBuilder
            .fromUriString(cryptoArticleUrl)
            .queryParam("api_key", cryptoArticleApiKey)
            .toUriString();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> r = template.getForEntity(articleUrl, String.class);
        Articles articles = Articles.createListofArticles(r.getBody());
        System.out.println(articles.getListOfArticles());
        return articles.getListOfArticles();
    }

    // public void saveArticles(String[] articles) {
    //     for (String s : articles) {
    //         repository.save(s);
    //     }
        
    // } 
}