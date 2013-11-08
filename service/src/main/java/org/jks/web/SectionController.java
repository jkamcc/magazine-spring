package org.jks.web;

import org.jks.domain.Section;
import org.jks.service.SectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * @author scorrales
 */

@Controller
@RequestMapping("section")
public class SectionController {
	
	 private static final Logger logger = LoggerFactory.getLogger(SectionController.class);

	    @Inject
	    private SectionService sectionService;
	    
	    @RequestMapping(value="addSection", method= RequestMethod.POST)
	    @ResponseBody
	    public String saveSection(Section section) {
	        sectionService.addSection(section);
	        return "Seccion agregada: " + section.toString();
	    }
	    
	   /* @RequestMapping(value="showSections", method= RequestMethod.GET)
	    @ResponseBody
	    public List<Section> getSections() {
	        return sectionService.getSections();
	    }/*/

}
