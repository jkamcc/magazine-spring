package org.jks.web;

import java.util.List;

import org.jks.domain.Section;
import org.jks.service.SectionService;
import org.jks.web.common.RestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        public Section saveSection(@Valid @RequestBody Section section) throws Exception {
            try{
                sectionService.addSection(section);
            }
            catch(Exception e){
                System.out.println("Fallo");
            }
            return section;
        }

        @RequestMapping(value="/all", method= RequestMethod.GET)
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

        
        @RequestMapping(value="/get/{name}", method= RequestMethod.GET)
	    @ResponseBody
	    public Section getSectionByName(@PathVariable String name) {
	    	Section section=sectionService.getSectionByName(name);
	        return section; 
	    }
        
        @RequestMapping(value="/update", method= RequestMethod.PUT)
        @ResponseBody
        public RestMessage updateSection(@Valid @RequestBody Section section) throws Exception {
        	sectionService.updateSection(section);
        	return new RestMessage( "Updated section");
        }
        
        @RequestMapping(value="/get/id/{id}", method= RequestMethod.GET)
        @ResponseBody
        public Section updateSection(@PathVariable long id) throws Exception {
        	Section section= sectionService.getSectionById(id);
        	return section;
        }
}
