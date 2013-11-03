package org.jks.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.jks.domain.User;
import org.jks.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserService userService;

    /**
     * Simply selaects the home view to render by returning its name.
     */
    @RequestMapping(value = "/{id}")
    @ResponseBody
    public User getById(@PathVariable Long id) {
        logger.info("Requesting User Id "+ id);
        User user = userService.getUserById(id);

        return user;
    }

}
