package org.tlc.bssservice.exception;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BSSExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BSSErrorResponse> handleNotFoundException(JSONException exc) {

        BSSErrorResponse error = new BSSErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage("Data not available, are you registered?");

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BSSErrorResponse> handleException(Exception exc) {

        BSSErrorResponse error = new BSSErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
