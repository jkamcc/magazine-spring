package org.jks.web;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.jks.domain.Section;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String showSections(Model model) {
		Section[] list = restTemplate.getForObject("http://localhost:8080/service/section/get", Section[].class);
		List<Section> slist = Arrays.asList(list);
		model.addAttribute("sectionList",  slist);
		return "sections";
	}
	
	/* Almacena una nueva Seccion en la BD */
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String addSection(Section section, BindingResult result, Model model) throws Exception{
		 restTemplate.postForObject("http://localhost:8080/service/section/create", section, Section.class);
		 return "redirect:/";
	}
	
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String deleteSection(Section section, BindingResult result, Model model)  {
		long id= section.getSectionid();
		restTemplate.delete("http://localhost:8080/service/section/delete/{id}",id);
		return "redirect:/";
	}
}