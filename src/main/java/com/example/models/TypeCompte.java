/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import org.springframework.data.annotation.Id;

/**
 *
 * @author USER
 */
public class TypeCompte {
    
    @Id
    private String id;
    private String CompteCourant;
    private String CompteEpargne;

    public TypeCompte(String id, String CompteCourant, String CompteEpargne) {
        this.id = id;
        this.CompteCourant = CompteCourant;
        this.CompteEpargne = CompteEpargne;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompteCourant() {
        return CompteCourant;
    }

    public void setCompteCourant(String CompteCourant) {
        this.CompteCourant = CompteCourant;
    }

    public String getCompteEpargne() {
        return CompteEpargne;
    }

    public void setCompteEpargne(String CompteEpargne) {
        this.CompteEpargne = CompteEpargne;
    }
    
    
}
