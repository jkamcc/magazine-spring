package org.jks.web;

import org.jks.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

/**
 * @author juancarrillo
 */
@Controller
@RequestMapping("users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {

        return "login";
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model) {

        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(Model model) {

        return "login";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register(Model model) {

        User user = restTemplate.getForObject("http://localhost:8080/service/user/1", User.class);
        System.out.println("user.getUsername() = " + user.getUsername());
        
        return "register";
    }

    @RequestMapping(value = "/register", method= RequestMethod.POST)
    public String createUser(@Valid User user, BindingResult result, Model model) {

        try {
            restTemplate.postForObject("http://localhost:8080/service/user/create", user, User.class);

        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return "register";
    }
}
