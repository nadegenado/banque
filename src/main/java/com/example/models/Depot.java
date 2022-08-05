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
public class Depot {
    
    @Id
    private String id;
   private String montantD;
   private Compte compte;
   private Client client;
   private TypeCompte typecompte;

    public Depot(String id, String montantD, Compte compte, Client client, TypeCompte typecompte) {
        this.id = id;
        this.montantD = montantD;
        this.compte = compte;
        this.client = client;
        this.typecompte = typecompte;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMontantD() {
        return montantD;
    }

    public void setMontantD(String montantD) {
        this.montantD = montantD;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TypeCompte getTypecompte() {
        return typecompte;
    }

    public void setTypecompte(TypeCompte typecompte) {
        this.typecompte = typecompte;
    }

    
}
