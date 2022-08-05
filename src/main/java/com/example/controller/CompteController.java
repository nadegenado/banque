/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.models.Compte;
import com.example.repository.CompteRepository;
import com.example.services.CompteService;
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
public class CompteController {
    @Autowired
    private CompteService compteService;
    private CompteRepository compteRepository;

     @GetMapping("/create")
    public ResponseEntity<Compte> createCpte (@RequestBody Compte c) {
        try {
            Compte cpte = compteService.saveCompte(c);
                    return  new ResponseEntity<>(cpte, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
  
    @PostMapping("/compte")
  Compte c(@RequestBody Compte c) {
    return compteRepository.save(c);
  }
    
    @GetMapping("/all")
    public ResponseEntity<List<Compte>> getAll() {
        try {
            List<Compte> compte = compteService.findAll();
            if(compte.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(compte, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/compte/{id}")
  Compte replaceCompte(@RequestBody Compte c, @PathVariable String id) {
    
    return compteRepository.findById(id)
      .map(compte -> {
        compte.setNumeroCompte(c.getNumeroCompte());
        compte.setTypeCompte(c.getTypeCompte());
        return compteRepository.save(c);
      })
      .orElseGet(() -> {
        c.setId(id);
        return compteRepository.save(c);
      });
  }
   
    
  @DeleteMapping("/Compte/{id}")
  void deleteCompte(@PathVariable String id) {
    compteRepository.deleteById(id);
  }
  
    
}
