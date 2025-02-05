package com.example.equipmentregister.controllers.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {
    /*@ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse onConstraintValidationException(
            ConstraintViolationException e
    ) {
        e.getConstraintViolations();
        final List<Violation> violations = e.getConstraintViolations().stream()
                .map(
                        violation -> new Violation(
                                violation.getPropertyPath().toString(),
                                violation.getMessage()
                        )
                )
                .collect(Collectors.toList());

        return new ValidationErrorResponse(violations);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse onMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) {
        final List<Violation> violations = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new Violation(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ValidationErrorResponse(violations);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleEntityValidationExceptions(NoSuchElementException e) {
        return new ResponseEntity<>("По указанному параметру, сущность не найдена: " + e.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
        return new ResponseEntity<>("JSON не читается: " + e.getMessage(),
                HttpStatus.BAD_REQUEST);
    }*/
}
