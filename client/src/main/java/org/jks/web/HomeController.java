package org.jks.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.jks.domain.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale) {
        logger.info("Welcome home! The client locale is {}.", locale);

        return "home";
    }

    @RequestMapping(value = "control_panel", method = RequestMethod.GET)
    public String getControlPanelPage() {

        return "control_panel_home";
    }
    
    @ExceptionHandler(Exception.class)
    @RequestMapping(value="/error")
    public ModelAndView handleAllException(Exception e) {
        logger.error(e.getMessage());
        e.printStackTrace();
        return new ModelAndView("error");
    }

}
