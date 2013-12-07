package org.jks.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jks.domain.Article;
import org.jks.domain.Comment;
import org.jks.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("articles")
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
    private RestTemplate restTemplate;
	
	
	//Este metodo lleva al usuario a editarticle.jsp para que pueda crear un articulo
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newarticle(Model model) {
        addSectionsToModel(model);
        model.addAttribute("edit-article", "");
    	return "editarticle";
    }

    @RequestMapping(value="/edit/{id}")
    public String editArticle(@PathVariable long id, Model model) {
        addSectionsToModel(model);
        addArticleToModel(id, model);
        model.addAttribute("edit_article", "edit_article");
        return "editarticle";
    }

	@RequestMapping(value="/article/{articleId}", method = RequestMethod.GET)
	public String showArticle(@PathVariable long articleId, Model model) {
        addArticleToModel(articleId, model);
		return "article";
	}

    private void addSectionsToModel(Model model) {
        try {
            Section[] sections = restTemplate.getForObject("http://localhost:8080/service/section/all", Section[].class);
            model.addAttribute("sectionList",  sections);

        } catch (RestClientException e) {
            logger.error("Sections could not be retrieved", e);
        }
    }

    private void addArticleToModel(long articleId, Model model) {
        try {
            Article article = restTemplate.getForObject("http://localhost:8080/service/article/complete/"+articleId+"/3", Article.class);
            model.addAttribute("article",  article);

        } catch (RestClientException e) {
            logger.error("The article with id "+articleId + " could not be retrieved", e);
        }
    }

    private void addCommentsToModel(long articleId, Model model) {
        try {
            Comment[] comments = restTemplate.getForObject("http://localhost:8080/service/comment/"+articleId, Comment[].class);
            model.addAttribute("comments",  comments);

        } catch (RestClientException e) {
            logger.error("The comments for the article with id "+articleId + " could not be retrieved", e);
        }
    }
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String editArticles() {
        return "articles";
    }

    @RequestMapping(value="/articlesinsection", method = RequestMethod.GET)
    public String showArticlesPerSection(Model model) {
    	try{
    		Article[] articles = restTemplate.getForObject("http://localhost:8080/service/article/all", Article[].class);
    		Section[] sections = restTemplate.getForObject("http://localhost:8080/service/section/all", Section[].class);

            model.addAttribute("articlesList",  articles);
            model.addAttribute("sectionList",  sections);
    	}catch (RestClientException e){
    		logger.error("Sections could not be retrieved", e);
    	}
    	return "articlesinsection";
    }
}


