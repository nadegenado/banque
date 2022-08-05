/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Compte;
import com.example.models.Depot;
import com.example.models.Virement;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author USER
 */
public interface VirementService {
    
    
    public Virement saveVirement (Virement r);
    public Optional<Compte> findById(String id);
     public List<Virement> findAll();
    public void deleteVirement(String id);
}
