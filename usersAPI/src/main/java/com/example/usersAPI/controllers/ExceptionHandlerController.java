package com.example.usersAPI.controllers;

import com.example.usersAPI.dtos.DataIntegrityViolationResponse;
import com.example.usersAPI.dtos.NotFoundResponse;
import com.example.usersAPI.dtos.NotValidFieldResponse;
import com.example.usersAPI.dtos.NotValidResponse;
import com.example.usersAPI.exceptions.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.usersAPI.utils.Constants.CONSTRAINT_VIOLATION;


@RestControllerAdvice
public class ExceptionHandlerController{

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundResponse> handleNotFoundException(NotFoundException notFoundException){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(NotFoundResponse
                        .builder()
                        .message(notFoundException.getLocalizedMessage())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<NotValidResponse> handleNotValidException(MethodArgumentNotValidException exception){

        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        List<NotValidFieldResponse> responses = errors
                .stream()
                .map(e -> NotValidFieldResponse.builder()
                        .field(e.getField())
                        .message(e.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity
                .badRequest()
                .body(NotValidResponse.builder()
                        .errors(responses)
                        .build());
    }

    // todo debería hacer una excepcion custom para comprobar que el dni ingresado no exista antes y ser más específico con el mensaje
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DataIntegrityViolationResponse> handleDataIntegrityViolation(DataIntegrityViolationException exception){
        return ResponseEntity
                .badRequest()
                .body(DataIntegrityViolationResponse
                        .builder()
                        .message(CONSTRAINT_VIOLATION)
                        .build());
    }

}
