/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.models.Retrait;

import com.example.repository.RetraitRepository;
import com.example.services.RetraitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/api/compte")

public class RetraitController {
    
    
    
     @Autowired
    private RetraitService retraitService;
    private RetraitRepository retraitRepository;

     @GetMapping("/create")
    public ResponseEntity<Retrait> createRtr (@RequestBody Retrait r) {
        try {
            Retrait rtr = retraitService.saveRetrait(r);
                    return  new ResponseEntity<>(rtr, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
  
    @PostMapping("/Retrait")
  Retrait r(@RequestBody Retrait r) {
    return retraitRepository.save(r);
  }
    
    @GetMapping("/all")
    public ResponseEntity<List<Retrait>> getAll() {
        try {
            List<Retrait> retrait = retraitService.findAll();
            if(retrait.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(retrait, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/retrait/{id}")
  Retrait replaceRetrait(@RequestBody Retrait r, @PathVariable String id) {
    
    return retraitRepository.findById(id)
      .map(retrait -> {
        retrait.setMontantR(r.getMontantR());
        retrait.setCompte(r.getCompte());
        return retraitRepository.save(r);
      })
      .orElseGet(() -> {
        r.setId(id);
        return retraitRepository.save(r);
      });
  }
   
    
  @DeleteMapping("/Retrait/{id}")
  void deleteCompte(@PathVariable String id) {
    retraitRepository.deleteById(id);
  }
    
    
}
