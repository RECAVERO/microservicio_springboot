package com.reynaldo.application.advice;

import com.reynaldo.application.controller.ClientController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WebExchangeBindException.class)
    public Map<String, String> handlerArguments(WebExchangeBindException ex){
        Map<String, String> res=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            res.put(error.getField(),error.getDefaultMessage());
        });

        return res;
    }
}
