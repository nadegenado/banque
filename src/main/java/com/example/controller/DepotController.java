/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.models.Depot;
import com.example.repository.DepotRepository;
import com.example.services.DepotService;
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
@RequestMapping("/api/depot")
public class DepotController {
    
    
    @Autowired
    private DepotService depotService;
    private DepotRepository depotRepository;

     @GetMapping("/create")
    public ResponseEntity<Depot> createDpt (@RequestBody Depot d) {
        try {
           Depot dpt = depotService.saveDepot(d);
                    return  new ResponseEntity<>(dpt, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
  
    @PostMapping("/Depot")
  Depot c(@RequestBody Depot d) {
    return depotRepository.save(d);
  }
    
    @GetMapping("/all")
    public ResponseEntity<List<Depot>> getAll() {
        try {
            List<Depot> depot = depotService.findAll();
            if(depot.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(depot, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/depot/{id}")
  Depot replaceDepot(@RequestBody Depot d, @PathVariable String id) {
    
    return depotRepository.findById(id)
      .map(depot -> {
       depot.setMontantD(d.getMontantD());
       depot.setCompte(d.getCompte());
        return depotRepository.save(d);
      })
      .orElseGet(() -> {
        d.setId(id);
        return depotRepository.save(d);
      });
  }
   
    
  @DeleteMapping("/Depot/{id}")
  void deleteDepot(@PathVariable String id) {
    depotRepository.deleteById(id);
  }
  
    
    
}
