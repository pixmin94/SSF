// package sg.iss.cryptonews.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RestController;

// import sg.iss.cryptonews.model.Article;
// import sg.iss.cryptonews.service.CryptoService;

// @RestController
// public class NewsRestController {
//     @Autowired
//     private CryptoService service;

//     @PostMapping(path="/articles")
//     public ResponseEntity<String> postSavedArticles(Model model, @RequestParam List<Article> articles) {
//         service.saveArticles(articles);
//         // model.addAttribute("savedArticles", list);
//         model.addAttribute("successMessage", "Articles saved!");
//         return "index";
//     }
// }
