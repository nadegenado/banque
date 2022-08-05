/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Compte;
import com.example.models.Retrait;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author USER
 */
public interface RetraitService {
    
    
      public Retrait saveRetrait (Retrait r);
    public Optional<Compte> findById(String id);
      public List<Retrait> findAll();
    public void deleteRetrait(String id);
}

