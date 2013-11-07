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

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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

    // Ka cuales códigos de http se devuelven cuando no existe un usuario,
    // o cuando falló el update, insert?
    // lo q falta es validar todas las entradas, crear los cruds, todos los errores son manejados por RestErrorHandler
    // el link q ud pasó la vez pasada: http://codetutr.com/2013/04/09/spring-mvc-easy-rest-based-json-services-with-responsebody/
    // Ver link que esta bueno http://www.petrikainulainen.net/programming/spring-framework/spring-from-the-trenches-adding-validation-to-a-rest-api/
    // Para probar http://localhost:8080/service/user/1 por ejemplo
    // Ka en general como los clientes saben q el servicio tiró un error, en todo eso vos eres la experta :)
     // habrá q tirar un json con el error? creo q para eso el link sirve.

}
