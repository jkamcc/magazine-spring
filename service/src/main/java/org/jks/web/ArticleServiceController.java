package org.jks.web;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.jks.domain.Article;
import org.jks.service.ArticleService;
import org.jks.web.common.RestMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.common.base.Preconditions;

/**
 * @author juancarrillo
 */
@Controller
@RequestMapping("article")
public class ArticleServiceController{
	@Inject
    private ArticleService articleService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Article getById(@PathVariable Long id) {

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
    public List<Article> getArticles(@RequestParam(value = "start", defaultValue = "0") int start,
                                    @RequestParam(value = "end", defaultValue = "0") int end){

        return articleService.getArticles(start, end);
    }
    
    
    @RequestMapping(value = "/completeall/{quantity}/{comments}", method = RequestMethod.GET)
    @ResponseBody
    public List<Article> getCompleteArticles(@PathVariable int quantity, @PathVariable int comments){
    	
    	List<Article> listArticles = articleService.getCompleteArticles(quantity, comments);

    	Preconditions.checkNotNull(listArticles, "Articles with quantity "+ quantity + " and "+
				comments +" comments cannot be found.");

        return listArticles;
    }
    
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT, 
    		headers = "Accept=application/json", consumes = "application/json")
    @ResponseBody
    public RestMessage updateArticle(@Valid @RequestBody Article article){
    	articleService.updateArticle(article);
    	 return new RestMessage("Updated article " + article.getSubject());
    }
    
    @RequestMapping(value = "/delete/{articleId}", method = RequestMethod.DELETE)
    public void deleteArticleById(@PathVariable long articleId){
    	articleService.deleteArticleById(articleId);  //TODAVIA FALTA PROBAR
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST,
            headers = "Accept=application/json", consumes = "application/json")
    @ResponseBody
    public RestMessage createArticle(@Valid @RequestBody Article article){ 
    	articleService.addArticle(article);
    	 return new RestMessage("Created Article " + article.getSubject());
    }
}
