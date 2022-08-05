/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Client;
import com.example.models.Compte;
import com.example.repository.ClientRepository;
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
public class ClientServiceImpl implements ClientService {

    
    @Autowired
    private ClientRepository clientRepository;
    private CompteRepository compteRepository;
   
    @Override
    public Client saveClient(Client c) {
        return clientRepository.save(c);
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
    public void deleteClient(String id) {
        
          Optional<Compte> data = findById(id);
        if(data.isPresent()){
            clientRepository.deleteById(id);
    }
    
    
    
}
}
