package org.jks.web.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author juancarrillo
 */
public class RestErrorMessage extends RestMessage {

    public class FieldErrorMessage {
        String field;
        String message;

        private FieldErrorMessage(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    private List<FieldErrorMessage> fieldErrors = new ArrayList<FieldErrorMessage>();

    public RestErrorMessage(String message) {
        super(message);
    }

    public List<FieldErrorMessage> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorMessage> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public void addField(String field, String message) {
        fieldErrors.add(new FieldErrorMessage(field, message));
    }
}
