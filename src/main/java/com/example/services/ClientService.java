/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Client;
import com.example.models.Compte;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author USER
 */
public interface ClientService {
      
    
    public Client saveClient(Client c);
    public Optional<Compte> findById(String id);
     public List<Compte> findAll();
    public void deleteClient(String id);
    
}
