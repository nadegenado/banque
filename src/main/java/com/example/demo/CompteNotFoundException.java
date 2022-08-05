/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

/**
 *
 * @author USER
 */
public class CompteNotFoundException  extends RuntimeException {
    
    
     CompteNotFoundException(String id) {
    super("Could not find compte " + id);
  }
}
