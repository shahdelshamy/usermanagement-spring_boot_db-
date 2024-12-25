package com.usermanagement.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice    //for all Controllers
public class ControllerExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<HashMap<String,List<String>>> handlerException(BindException ex){
        List<String> errors=ex.getAllErrors().stream()
                .map((exception)->exception.getDefaultMessage())
                .collect(Collectors.toList());

        HashMap<String ,List<String>> errMap=new HashMap<>();
        errMap.put("Errors",errors);

        return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
    }

}
