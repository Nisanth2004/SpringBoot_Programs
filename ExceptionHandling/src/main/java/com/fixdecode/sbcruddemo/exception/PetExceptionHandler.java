package com.fixdecode.sbcruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class PetExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> petExceptionHandler(MethodArgumentNotValidException exception)
    {
        Map<String,String> errors=new HashMap<>();
        exception
                .getBindingResult()
                .getFieldErrors() // get all error message which we will be given in entity class
                .forEach(error->errors.put(error.getField(),error.getDefaultMessage()));

        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PetNotFoundException.class)
    public Map<String,String> petNotFound(PetNotFoundException exception)
    {
       Map<String,String> error=new HashMap<>();
       error.put("error",exception.getMessage());
       return error;
    }
}
