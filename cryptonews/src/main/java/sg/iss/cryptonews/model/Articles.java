package sg.iss.cryptonews.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.json.Json;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import sg.iss.cryptonews.model.Article;

public class Articles implements Serializable{
    private List<Article> listOfArticles = new LinkedList<>();
    private List<Article> listOfSavedArticles = new LinkedList<>();

    public List<Article> getListOfArticles() {
        return listOfArticles;
    }

    public void setListOfArticles(List<Article> listOfArticles) {
        this.listOfArticles = listOfArticles;
    } 

    public List<Article> getListOfSavedArticles() {
        return listOfSavedArticles;
    }

    public void setListOfSavedArticles(List<Article> listOfSavedArticles) {
        this.listOfSavedArticles = listOfSavedArticles;
    }
    
    public static Articles createListofArticles(String json) throws IOException {
        Articles articles = new Articles();
        try(InputStream is = new ByteArrayInputStream(json.getBytes())) {
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            articles.listOfArticles = o.getJsonArray("Data").stream()
                .map(v-> (JsonObject)v)
                .map(v-> Article.createArticle(v))
                .toList();

        }

        return articles;
    }


    // public void addArticle(Article article) {
    //     this.listOfSavedArticles.add(article);
    // }
}
