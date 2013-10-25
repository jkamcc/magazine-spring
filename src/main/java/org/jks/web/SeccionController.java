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
import org.jks.model.*;


/**
 * Handles requests for the application home page.
 */
@Controller
public class SeccionController {

	private static SessionFactory factory; 

	@RequestMapping(value = "/agregarSeccion", method = RequestMethod.GET)
	public String agregarSeccion(String nuevaSeccion){
		Session session= factory.openSession();
		Transaction tx= null;
		try{
			tx= session.beginTransaction();
			Section seccion= new Section();
			seccion.setSectionArticle("Anuncios");
			session.save(seccion);
		}
		catch(HibernateException e){
		
		}
		return "login";
	}
}
