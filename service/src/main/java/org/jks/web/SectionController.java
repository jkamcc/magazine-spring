package org.jks.web;

/**
 * @author scorrales
 */

@Controller
@RequestMapping("section")
public class SectionController {
	
	 private static final Logger logger = LoggerFactory.getLogger(SectionController.class);

	    @Inject
	    private SectionService sectionService;
	    
	    @RequestMapping(value="addSection", method=RequestMethod.POST)
	    @ResponseBody
	    public String saveSection(Section section) {
	        sectionService.addSection(section);
	        return "Seccion agregada: " + section.toString();
	    }

}
