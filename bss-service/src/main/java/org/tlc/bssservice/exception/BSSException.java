package org.tlc.bssservice.exception;

public class BSSException extends RuntimeException {

    public BSSException(String message, Throwable cause) {
        super(message, cause);
    }

    public BSSException(String message) {
        super(message);
    }

    public BSSException(Throwable cause) {
        super(cause);
    }

}
