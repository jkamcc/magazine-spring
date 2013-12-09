package org.jks.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jks.domain.Article;
import org.jks.domain.Comment;
import org.jks.domain.Section;
import org.jks.domain.User;
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
	
	
	//Este metodo lleva al usuario a edit_article.jsp para que pueda crear un articulo
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newarticle(Model model, HttpServletRequest request) {
    	if(usuarioValido(request, (byte)0) || usuarioValido(request,(byte)1)){
	        addSectionsToModel(model);
	        model.addAttribute("edit-article", "");
	    	return "editarticle";
    	}else{
    		return "home";
    	}
    }

    @RequestMapping(value="/edit/{id}")
    public String editArticle(@PathVariable long id, Model model, HttpServletRequest request) {
    	try{
	    	if(usuarioValido(request, (byte)0) || usuarioValido(request,(byte)1)){
		        addSectionsToModel(model);
		        addArticleToModel(id, model);
		        model.addAttribute("edit_article", "edit_article");
		        return "editarticle";
	    	}
	    	else{
	    		return "home";
	    	}
    	}
    	catch(RestClientException e){
    		return "home";
    	}
    }

	@RequestMapping(value="/article/{articleId}", method = RequestMethod.GET)
	public String showArticle(@PathVariable long articleId, Model model) {
		try{
	        addArticleToModel(articleId, model);
			return "article";
		}
		catch(RestClientException e){
			return "home";
		}
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
    public String editArticles(Model model, HttpServletRequest request) {
    	if(usuarioValido(request, (byte)0) || usuarioValido(request,(byte)1)){
	    	Article[] articles=restTemplate.getForObject("http://localhost:8080/service/article/completeall/0/0", Article[].class);
	    	for (int i=0;i<articles.length;++i){
	    		if(articles[i].getArticle().length()>40){
	    			articles[i].setArticle(articles[i].getArticle().substring(0, 40));
	    		}
	    	}
	    	model.addAttribute("articlesList", articles);
	        return "articles";
    	}
    	else{
    		return "home";
    	}
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
    
    /*Verifica si el usuario logueado posee profile de Administrator*/
	private boolean usuarioValido(HttpServletRequest request, byte idvalido){
		boolean valido=false;
		User user= (User) request.getAttribute("currentUser");
		if(user!=null && user.getProfileid()==(byte)idvalido){
			valido=true;
		}
		return valido;
	}
}



