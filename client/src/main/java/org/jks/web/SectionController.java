package org.jks.web;
import java.util.Arrays;
import java.util.List;
import org.jks.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


/**
 * @author scorrales
 */

@Controller
@RequestMapping("sections")
public class SectionController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	/* Obtiene la lista de todas las secciones en la BD */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showSections(Model model) {
		Section[] list = restTemplate.getForObject("http://localhost:8080/service/section/get", Section[].class);
		List<Section> slist = Arrays.asList(list);
		model.addAttribute("sectionList",  slist);
		return "showSections";
	}
	
	/* Almacena una nueva Seccion en la BD */
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String addSection(Section section, BindingResult result, Model model) {
		try{
			restTemplate.postForObject("http://localhost:8080/service/section/create", section, Section.class);
			showSections(model);
		}
		catch(RestClientException e){
			e.printStackTrace();
		}
		return "showSections";
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.DELETE)
	public String deleteSection(Section section, BindingResult result, Model model) {
		/*try{
			restTemplate.deleteForObject("http://localhost:8080/service/section/delete/{id}", section, Section.class);
		}
		catch(RestClientException e){
			e.printStackTrace();
		}*/
		return "showSections";
	}
}