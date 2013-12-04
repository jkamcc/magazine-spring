package org.jks.domain;

/**
 * @author juancarrillo
 */

public enum Profile {
    ADMINISTRATOR((byte)0), CONTENT_CREATOR((byte)1), NORMAL((byte)2) ;

    private final byte value;

    private Profile(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
