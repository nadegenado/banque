/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Compte;
import com.example.models.Retrait;
import com.example.repository.CompteRepository;
import com.example.repository.RetraitRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author USER
 */
public class RetraitServiceImpl implements RetraitService {

    @Autowired
    private RetraitRepository retraitRepository;
      private CompteRepository compteRepository;
    @Override
    public Retrait saveRetrait(Retrait r) {
     return retraitRepository.save(r);
    }

    @Override
    public Optional<Compte> findById(String id) {
        return compteRepository.findById(id); 
    }
    
      @Override
    public List<Retrait> findAll() {
        return retraitRepository.findAll();
    }

    @Override
    public void deleteRetrait(String id) {
      Optional<Compte> data = findById(id); 
        if(data.isPresent()){
            retraitRepository.deleteById(id);
        }
    }
    
}
