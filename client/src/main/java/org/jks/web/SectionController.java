package org.jks.web;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.jks.domain.Article;
import org.jks.domain.Section;
import org.jks.domain.User;
import org.jks.web.common.HeaderInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.SimpleFormController;


/**
 * @author scorrales
 */

@Controller
@RequestMapping("sections")
public class SectionController {
	
	private static final Logger logger = LoggerFactory.getLogger(SectionController.class);
	
	@Autowired
    private RestTemplate restTemplate;
	
	
	/* Obtiene la lista de todas las secciones en la BD */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showSections(Model model, HttpServletRequest request) {
		if(usuarioAdministrador(request)){
			Section[] list = restTemplate.getForObject("http://localhost:8080/service/section/all", Section[].class);
			List<Section> slist = Arrays.asList(list);
			model.addAttribute("sectionList",  slist);
			return "sections";
		}
		else{
			return "home";
		}
	}
	
	@RequestMapping(value="/section/{id}", method = RequestMethod.GET)
	public String getArticlesWithSectionId(@PathVariable long id, Model model) {
		try{
			Section section = restTemplate.getForObject("http://localhost:8080/service/section/get/id/"+id, Section.class);
			Article[] articles = restTemplate.getForObject("http://localhost:8080/service/article/bysection/"+id+"/0/10/0", Article[].class);
			model.addAttribute("section",  section);
			model.addAttribute("articles", articles);
		}catch(RestClientException e){
			return "home";
		}
		return "sectionandarticles";
	}
	
	/*Verifica si el usuario logueado posee profile de Administrator*/
	private boolean usuarioAdministrador(HttpServletRequest request){
		boolean valido=false;
		User user= (User) request.getAttribute("currentUser");
		if(user!=null && user.getProfileid()==(byte)0){
			valido=true;
		}
		return valido;
	}
	
}