/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Compte;
import com.example.repository.CompteRepository;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class CompteServiceImpl implements CompteService {

    
    @Autowired
    private CompteRepository compteRepository;
    @Override
    public Compte saveCompte(Compte c) {
        return compteRepository.save(c); 
    }

    @Override
    public Optional<Compte> findById(String id) {
        return compteRepository.findById(id);
    }

  
    @Override
    public List<Compte> findAll() {
        return compteRepository.findAll();
    }

    @Override
    public void deleteCompte(String id) {
        Optional<Compte> data = findById(id);
        if(data.isPresent()){
            compteRepository.deleteById(id);
    }
    
}
}
