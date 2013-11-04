package org.jks.web;

import java.util.List;

import javax.inject.Inject;

import org.jks.domain.Article;
import org.jks.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Preconditions;

/**
 * @author juancarrillo
 */
@Controller
@RequestMapping("article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Inject
    private ArticleService articleService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Article getById(@PathVariable Long id) {

        logger.info("Requesting User Id "+ id);

        Article article = articleService.getArticleById(id);

        Preconditions.checkNotNull(article, "Article with id "+ id + " cannot be found.");

        return article;
    }
    
    @RequestMapping(value = "/subject/{subject}", method = RequestMethod.GET)
    @ResponseBody
    public Article getArticleBySubject(@PathVariable String subject){
    	Article article = articleService.getArticleBySubject(subject);

        Preconditions.checkNotNull(article, "Article with subject "+ subject + " cannot be found.");

        return article;
    }
    
    @RequestMapping(value = "/complete/{articleId}/{comments}", method = RequestMethod.GET)
    @ResponseBody
    public Article getCompleteArticle(@PathVariable Long articleId, @PathVariable int comments){
        Article article = articleService.getCompleteArticle(articleId, comments);

        Preconditions.checkNotNull(article, "Article with id "+ articleId + " and "+
        					comments +" comments cannot be found.");

        return article;
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Article> getAll() {

    	List<Article> listArticles = articleService.getArticles();

        Preconditions.checkNotNull(listArticles, "Articles cannot be found.");

        return listArticles;
    }
      
    @RequestMapping(value = "/all/{start}/{end}", method = RequestMethod.GET)
    @ResponseBody
    public List<Article> getArticles(@PathVariable int start, @PathVariable int end){
    	List<Article> listArticles = articleService.getArticles(start, end);

        Preconditions.checkNotNull(listArticles, "Articles cannot be found.");

        return listArticles;
    }
    
    @RequestMapping(value = "/completeall/{quantity}/{comments}", method = RequestMethod.GET)
    @ResponseBody
    public List<Article> getCompleteArticles(@PathVariable int quantity, @PathVariable int comments){
    	
    	List<Article> listArticles = articleService.getCompleteArticles(quantity, comments);

    	Preconditions.checkNotNull(listArticles, "Articles with quantity "+ quantity + " and "+
				comments +" comments cannot be found.");

        return listArticles;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateArticle(){
    	//FALTA MANDAR EL OBJETO
    }
    
    @RequestMapping(value = "/delete/{articleId}", method = RequestMethod.DELETE)
    public void deleteArticleById(@PathVariable long articleId){
    	articleService.deleteArticleById(articleId);  //TODAVIA FALTA PROBAR
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, 
    		headers = "Accept=application/json", consumes = "application/json")
    @ResponseBody
    public String createArticle(@RequestBody String article){ 
    	//articleService.addArticle(article);
    	return article;    	
    }
}
