package sg.iss.cryptonews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import jakarta.json.Json;
import jakarta.json.JsonObject;

import sg.iss.cryptonews.model.Article;
import sg.iss.cryptonews.service.CryptoService;

@RestController
public class NewsRestController {
    @Autowired
    private CryptoService service;

    @GetMapping(path="/news/{articleId}")
    public ResponseEntity<String> getArticle (@PathVariable String articleId) {
        Optional<Article> a = service.getArticleById(articleId);
        if(a.isEmpty()){
            JsonObject error = Json.createObjectBuilder()
                                .add("message", "Article not saved"
                                        .formatted(articleId))
                                .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(error.toString());
        }
        return ResponseEntity.ok(a.get().toJSON().toString());
    }
}
