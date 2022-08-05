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
public class Virement {
   @Id
    private String id;
    private String montantV;
    private Compte compte;
    private Client client;

    public Virement(String id, String montantV, Compte compte, Client client) {
        this.id = id;
        this.montantV = montantV;
        this.compte = compte;
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMontantV() {
        return montantV;
    }

    public void setMontantV(String montantV) {
        this.montantV = montantV;
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
    
    
}
