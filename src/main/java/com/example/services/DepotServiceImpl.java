/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Compte;
import com.example.models.Depot;
import com.example.repository.CompteRepository;
import com.example.repository.DepotRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author USER
 */
public class DepotServiceImpl  implements DepotService{

    
    @Autowired
    private DepotRepository depotRepository;
    private CompteRepository compteRepository;
    @Override
    public Depot saveDepot(Depot d) {
      return  depotRepository.save(d);
    }

    @Override
    public Optional<Compte> findById(String id) {
    return compteRepository.findById(id);
    }

     @Override
    public List<Depot> findAll() {
        return depotRepository.findAll();
    }
    @Override
    public void deleteDepot(String id) {
       Optional<Compte> data = findById(id); 
        if(data.isPresent()){
            compteRepository.deleteById(id);
        }
}
}
