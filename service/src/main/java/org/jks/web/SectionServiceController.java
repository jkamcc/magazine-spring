package org.jks.web;

import java.util.List;

import org.jks.domain.Section;
import org.jks.service.SectionService;
import org.jks.web.common.RestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * @author scorrales
 */

@Controller
@RequestMapping("section")
public class SectionServiceController {
	
	 private static final Logger logger = LoggerFactory.getLogger(SectionServiceController.class);

	    @Inject
	    private SectionService sectionService;
	    
	    @RequestMapping(value="/create", method= RequestMethod.POST)
	    @ResponseBody
	    public RestMessage saveSection(@Valid @RequestBody Section section) {
	        sectionService.addSection(section);
	        return new RestMessage( "Seccion agregada: "+section.getSectionArticle()); 
	    }
	    
	    @RequestMapping(value="/get", method= RequestMethod.GET)
	    @ResponseBody
	    public List<Section> getSections() {
	        return sectionService.getSections();
	    }
	    
	    @RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE)
	    @ResponseBody
	    public RestMessage deleteSection(@PathVariable Long id) {
	        sectionService.deleteSection(sectionService.getSectionById(id));
	        return new RestMessage( "Seccion eliminada"); 
	    }
}