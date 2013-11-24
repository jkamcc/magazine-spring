package org.jks.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.jks.domain.Article;
import org.jks.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("articles")
public class ArticleController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	
	//Este metodo lleva al usuario a editarticle.jsp para que pueda crear un articulo
    @RequestMapping(value="/newarticle", method = RequestMethod.GET)
    public String newarticle(Model model) {
    	
    	Section[] sections = restTemplate.getForObject("http://localhost:8080/service/section/all", Section[].class);

		model.addAttribute("sectionList",  sections);
		
    	return "editarticle";
    }
    
    
    
	@RequestMapping(value="/article/{articleId}", method = RequestMethod.GET)
	public ModelAndView showArticle(@PathVariable int articleId) {
		Article article = restTemplate.getForObject("http://localhost:8080/service/article/"+articleId, Article.class);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("myArticle",  article);

		return new ModelAndView("article", model);
	}
	
	
	
	
	
}
