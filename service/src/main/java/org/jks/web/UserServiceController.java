package org.jks.web;

import com.google.common.base.Preconditions;
import org.jks.domain.User;
import org.jks.service.UserService;
import org.jks.web.common.RestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("user")
public class UserServiceController {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);

    @Inject
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getById(@PathVariable Long id) {

        logger.info("Requesting User Id "+ id);

        User user = userService.getUserById(id);

        Preconditions.checkNotNull(user, "User with id "+ id + " cannot be found.");

        return user;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage createUser(@Valid @RequestBody User user) throws Exception {
        userService.addUser(user);
        return new RestMessage("Created user " + user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public RestMessage updateUser(@Valid @RequestBody User user) throws Exception {
        userService.updateUser(user);
        return new RestMessage("Created user " + user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public RestMessage deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return  new RestMessage("Deleted user "+ id);
    }

    @RequestMapping(params = "username", method = RequestMethod.GET)
    @ResponseBody
    public User getByUsername(@RequestParam(value="username") String username) {

        logger.info("Requesting Username "+ username);

        User user = userService.getUserByUsername(username);

        Preconditions.checkNotNull(user, "User with username "+ username + " cannot be found.");

        return user;
    }

    @RequestMapping(value = "/all", params = {"start","end"}, method = RequestMethod.GET)
    public List<User> getUsers(@RequestParam(value = "start") int start, @RequestParam(value = "end") int end){

        return userService.getUsers();
    }

}
