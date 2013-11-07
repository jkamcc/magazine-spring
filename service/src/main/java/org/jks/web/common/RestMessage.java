package org.jks.web.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author juancarrillo
 */
public class RestMessage {

    private String message;

    public RestMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
