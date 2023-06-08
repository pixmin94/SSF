package sg.iss.cryptonews.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.Date;
// import java.util.List;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;

public class Article implements Serializable{
    private String id;
    private Date published_on;
    private String title;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Date getPublished_on() {
        return published_on;
    }
    public void setPublished_on(Date published_on) {
        this.published_on = published_on;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getCategories() {
        return categories;
    }
    public void setCategories(String categories) {
        this.categories = categories;
    }

    public static Article createArticle(JsonObject o){
        Article n = new Article();
        n.setId(o.getString("id"));
        // n.setPublished_on(o.getDate("published_on"));
        n.setTags(o.getString("tags"));
        System.out.println("from article model: "+n.getId());
        return n;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
        .add("id", this.getId())
        .add("tags", this.getTags())
        .build()
        ;
    }

    public static JsonObject toJSON(String json){
        JsonReader r = (JsonReader) Json.createReader(new StringReader(json));
        return r.readObject();
    }

    public static Article toObject(JsonObject o) {
        Article a = new Article();
        a.setId(o.getString("id"));
        a.setTags(o.getString("tags"));
        return a;
    }
}
