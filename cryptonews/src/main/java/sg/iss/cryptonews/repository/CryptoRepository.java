package sg.iss.cryptonews.repository;

import org.springframework.stereotype.Repository;
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
}
