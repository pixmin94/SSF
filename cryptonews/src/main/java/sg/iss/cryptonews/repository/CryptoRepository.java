package sg.iss.cryptonews.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

import sg.iss.cryptonews.model.Article;;

@Repository
public class CryptoRepository {
    @Autowired
    @Qualifier("crypto")
    RedisTemplate<String, Object> template;

    public void saveArticle(String id, Article article) {
        template.opsForValue().set(id, article.toJSON().toString());
    }

    public Optional<Article> get(String articleId) {
        String json = (String)template.opsForValue().get(articleId);
        if(null == json || json.trim().length() <= 0){
            return Optional.empty();
        }
        return Optional.of(Article.toObject(Article.toJSON(json)));
    }
}
