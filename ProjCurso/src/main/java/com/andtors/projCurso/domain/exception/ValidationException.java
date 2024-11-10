package com.andtors.projCurso.domain.exception;

public class ValidationException extends RuntimeException{
    public ValidationException (String message){
        super(message);
    }
}