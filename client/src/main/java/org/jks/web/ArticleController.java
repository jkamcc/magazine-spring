package org.jks.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.jks.domain.Article;
import org.jks.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;


@Controller
@RequestMapping("articles")
public class ArticleController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	/* 
	 * La este es el que con el form va a jalar los datos y crear el articulo para mandarlo a bd
	@RequestMapping(value="/savearticle", method = RequestMethod.GET)
	public String savearticle(Model model) {
		//Article article = restTemplate.getForObject("http://localhost:8080/service/user/1", Article.class);
		//System.out.println("article.getSubject() = " + article.getSubject());
		return "";
	}
	*/
	
	//Este metodo lleva al usuario a editarticle.jsp para que pueda crear un articulo
    @RequestMapping(value="/newarticle", method = RequestMethod.GET)
    public ModelAndView newarticle(Model m) {
    	Section[] sections = restTemplate.getForObject("http://localhost:8080/service/section/showSections", Section[].class);

    	Map<String, Object> model = new HashMap<String, Object>();
		model.put("sectionList",  sections);
		
    	return new ModelAndView("editarticle", model);
    }
    
    
    
	@RequestMapping(value="/article/{articleId}", method = RequestMethod.GET)
	public ModelAndView showArticle(@PathVariable int articleId) {
		Article article = restTemplate.getForObject("http://localhost:8080/service/article/"+articleId, Article.class);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("myArticle",  article);

		return new ModelAndView("article", model);
	}
	
	
	
	
	
}
