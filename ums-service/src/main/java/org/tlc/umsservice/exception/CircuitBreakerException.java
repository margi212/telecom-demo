package org.tlc.umsservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CircuitBreakerException extends RuntimeException {

    public CircuitBreakerException() {
        super();
    }

    public CircuitBreakerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CircuitBreakerException(String message) {
        super(message);
    }

    public CircuitBreakerException(Throwable cause) {
        super(cause);
    }
}
