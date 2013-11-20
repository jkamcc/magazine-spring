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
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String login(Model model) {

        return "login";
    }

    @RequestMapping(value="/signfailed", method = RequestMethod.GET)
    public String loginerror(Model model) {

        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value="/signout", method = RequestMethod.GET)
    public String logout(Model model) {

        return "login";
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register(Model model) {

        return "register";
    }

    @RequestMapping(value = "/register", method= RequestMethod.POST)
    @ResponseBody
    public String createUser(@Valid User user, BindingResult result, Model model) {

        String returnText = "Sorry an error has occurred";

        if (!result.hasErrors()) {

            try {
                restTemplate.postForObject("http://localhost:8080/service/user/create", user, User.class);

            } catch (RestClientException e) {
                e.printStackTrace();
            }

            returnText = "User created successfully";
        }

        return returnText;
    }
}
