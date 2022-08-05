/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author USER
 */
@ControllerAdvice
public class CompteNotFoundAdvice {
    
  @ResponseBody
  @ExceptionHandler(CompteNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
    String compteNotFoundHandler(CompteNotFoundException ex){
        return ex.getMessage();
    }
}
