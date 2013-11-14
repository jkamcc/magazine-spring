package org.jks.web;
/**
 * @author scorrales
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jks.domain.Article;
import org.jks.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sections")
public class SectionController {
	@Autowired
    private RestTemplate restTemplate;
	
	/* Obtiene la lista de todas las secciones en la BD */
	@RequestMapping(value="/getSections", method = RequestMethod.GET)
	public ModelAndView showSections() {
		Section[] list = restTemplate.getForObject("http://localhost:8080/service/section/showSections", Section[].class);
		List<Section> slist = Arrays.asList(list);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("sectionList",  slist);
		return new ModelAndView("showSections", model);
	}
}
