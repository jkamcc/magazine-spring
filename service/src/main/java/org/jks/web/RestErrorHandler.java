package org.jks.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String ValidationErrors(NullPointerException e) {
        logger.error(e.getMessage());
        return e.getMessage();
    }

    //    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public String ValidationError(MethodArgumentNotValidException e) {
//        BindingResult result = e.getBindingResult();
//
//        return "invalid";
//    }



}
