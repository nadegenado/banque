/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Compte;
import com.example.models.Virement;
import com.example.repository.CompteRepository;
import com.example.repository.VirementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author USER
 */
public class VirementServiceImpl  implements VirementService {
    
    @Autowired 
    private VirementRepository virementRepository;
    private CompteRepository compteRepository;
   
    @Override
    public Virement saveVirement(Virement v) {
       return virementRepository.save(v);
    }

    @Override
    public Optional<Compte> findById(String id) {
       return compteRepository. findById(id);
    }
    
      @Override
    public List<Virement> findAll() {
        return virementRepository.findAll();
    }
    @Override
    public void deleteVirement(String id) {
        Optional<Compte> data = findById(id); 
        if(data.isPresent()){
            virementRepository.deleteById(id);
        
    
    
}
    }
}
    
