package com.project.stilgalleriet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    //annotering som används för att markera en metod som en undantagshanterar, specifikt UserNotFoundException.
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e) {
        //skapar och returnerar ett ResponseEntity-objekt med felmeddelandet och HTTP-statuskoden 404 (NOT_FOUND)
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (InvalidUserDataException.class)
    public ResponseEntity<String> handleInvalidUserDataException(InvalidUserDataException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


    //annotering som anger att denna metod ska hantera undantag av typen MethodArgumentNotValidException när valid inte uppfyller valideringskraven.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {
        //skapar en ny tom Map för att lagra fältfel och deras tillhörande felmeddelande
        Map<String, String> errors = new HashMap<>();

        //itererar över alla fel som uppstod under valideringen
        e.getBindingResult().getAllErrors().forEach((error)-> {
            //hämtar namnet på fältet som orsakade felet
            String fieldName = ((FieldError)error).getField();
            //hämtar standardfelmeddelandet för felet
            String errorMessage = error.getDefaultMessage();
            //lägger till fältnamnet och felmeddelandet i Map
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}

