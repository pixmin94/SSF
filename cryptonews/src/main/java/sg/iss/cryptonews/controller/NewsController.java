package sg.iss.cryptonews.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;

import sg.iss.cryptonews.model.Article;
import sg.iss.cryptonews.model.Articles;
import sg.iss.cryptonews.service.CryptoService;
import sg.iss.cryptonews.repository.CryptoRepository;

@Controller
// @RequestMapping(consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public class NewsController {
    @Autowired
    private CryptoService service;

    @Autowired
    private CryptoRepository repository;

    @GetMapping(path="/")
    public String getArticles(Model model) throws IOException {
        List<Article> articles = service.getArticles();
        model.addAttribute("articles", articles);
        return "index";
    }

    @PostMapping(path="/articles")
    public String postSavedArticles(Model model, @RequestParam("savedArticles") String[] articles) {
        for (String s: articles) {
            Article a = Article.toObject(Article.toJSON(s));
            repository.saveArticle(a.getId(), a);
        }
        model.addAttribute("successMessage", "Articles saved!");
        return "index";
    }
}
