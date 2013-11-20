package org.jks.web.common;

import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.jks.web.UserServiceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class RestErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
     public RestMessage generateNoResultError(NullPointerException e) {
        logger.error(e.getMessage());
        RestMessage errorMessage = new RestMessage(e.getMessage());
        return errorMessage;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public RestErrorMessage processNotValidObject(MethodArgumentNotValidException e) {
        logger.error(e.getMessage(), e);
        BindingResult result = e.getBindingResult();
        RestErrorMessage errorMessage = new RestErrorMessage("Invalid fields");
        processFieldErrors(errorMessage, result.getFieldErrors());
        return errorMessage;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestMessage processUrlNotValid(Exception e) {
        logger.error(e.getMessage(), e);
        return new RestMessage(e.getMessage());
    }

    private void processFieldErrors(RestErrorMessage errorMessage, List<FieldError> errors) {
        for (FieldError error : errors) {
            errorMessage.addField(error.getField(), error.getDefaultMessage());
        }
    }

//    private String resolveLocalizedErrorMessage(FieldError fieldError) {
//        Locale currentLocale =  LocaleContextHolder.getLocale();
//        String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);
//                       MessageSource s;
//        fieldError.
//        //If the message was not found, return the most accurate field error code instead.
//        //You can remove this check if you prefer to get the default error message.
//        if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
//            String[] fieldErrorCodes = fieldError.getCodes();
//            localizedErrorMessage = fieldErrorCodes[0];
//        }
//
//        return localizedErrorMessage;
//    }

}
