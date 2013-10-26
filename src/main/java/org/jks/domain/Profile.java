package org.jks.domain;

/**
 * @author juancarrillo
 */
public enum Profile {
    ADMINISTRATOR(0), CONTENT_CREATOR(1), NORMAL(2) ;

    private final int value;

    private Profile(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
