package com.example.HW4.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandle(Exception ex, WebRequest req) {
        return new ResponseEntity<>("Error Error Error", HttpStatus.BAD_REQUEST);
    }*/

    @ExceptionHandler(InvalidPhotoIdException.class)
    public ResponseEntity<?> invalidPhoto(Exception ex, WebRequest req) {
        return new ResponseEntity<>("Error" + ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidAlbumIdException.class)
    public ResponseEntity<?> invalidAlbum(Exception ex, WebRequest req) {
        return new ResponseEntity<>("Error" + ex.getMessage(), HttpStatus.FORBIDDEN);
    }

}


