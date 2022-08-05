/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.models.Virement;
import com.example.repository.VirementRepository;
import com.example.services.VirementService;
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
@RequestMapping("/api/virement")
public class VirementControlller {
    
    
    
    @Autowired
    private VirementService virementService;
    private  VirementRepository  virementRepository;

     @GetMapping("/create")
    public ResponseEntity< Virement> createVrmt (@RequestBody  Virement v) {
        try {
            Virement vrmt = virementService.saveVirement(v);
                    return  new ResponseEntity<>(vrmt, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
  
    @PostMapping("/Virement")
   Virement v(@RequestBody  Virement v) {
    return virementRepository.save(v);
  }
    
    @GetMapping("/all")
    public ResponseEntity<List< Virement>> getAll() {
        try {
            List< Virement> virement = virementService.findAll();
            if(virement.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(virement, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/Virement/{id}")
  Virement replaceDepot(@RequestBody Virement v, @PathVariable String id) {
    
    return virementRepository.findById(id)
      .map(virement -> {
       virement.setMontantV(v.getMontantV());
       virement.setCompte(v.getCompte());
        return virementRepository.save(v);
      })
      .orElseGet(() -> {
        v.setId(id);
        return virementRepository.save(v);
      });
  }
   
    
  @DeleteMapping("/Virement/{id}")
  void deleteVirement(@PathVariable String id) {
    virementRepository.deleteById(id);
  }
  
    
    
}
