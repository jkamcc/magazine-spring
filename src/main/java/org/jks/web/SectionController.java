package org.jks.web;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.sql.ordering.antlr.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

import org.jks.domain.*;
import org.jks.service.SectionService;
import org.jks.service.UserService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class SectionController {

	 @Inject
	 private SectionService sectionService;
	 
	 
	@RequestMapping(value = "/addSection", method = RequestMethod.GET)
	public String addSection(Model model) {
        return "addSection";
    }
	
	/*@RequestMapping(value = "/addSection", method = RequestMethod.PUT)
	public String agregarSeccion(String nuevaSeccion){
		try{
			sectionService.agregarSeccion("Anuncios");
		}
		catch(HibernateException e){
		
		}
		return "addSection";
	}*/
}
