/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.util.Objects;
import org.springframework.data.annotation.Id;

/**
 *
 * @author USER
 */
public class Compte {
    @Id
    private String id;
    private String numeroAg;
    private String numeroCompte;
    private int solde;
    private TypeCompte typeCompte;
    private Client client;
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroAg() {
        return numeroAg;
    }

    public void setNumeroAg(String numeroAg) {
        this.numeroAg = numeroAg;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    

    public Compte(String id, String numeroAg, String numeroCompte, int solde, TypeCompte typeCompte, Client client) {
        this.id = id;
        this.numeroAg = numeroAg;
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.typeCompte = typeCompte;
        this.client = client;
    }

    
    
    
     @Override
    public boolean equals(Object o){
        if(this ==  o)
            return true;
        if(!(o instanceof Client))
            return false;
        Compte compte = (Compte) o;
         return Objects.equals(this.id, compte.id) && 
                Objects.equals(this.numeroAg, compte.numeroAg) && 
                Objects.equals(this.numeroCompte, compte.numeroCompte) && 
                Objects.equals(this.solde, compte.solde) &&
                Objects.equals(this.typeCompte, compte.typeCompte) && 
                Objects.equals(this.client, compte.client) ;
            
       
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.numeroAg, this.numeroCompte, this.typeCompte, this.client);
    }
   @Override
    public String toString(){
        return "Compte {" + "id = " + this.id + ", numeroCompte = '" + this.numeroCompte +'\'' + ", client='" +this.client + '\'' + '}';
    }
    
    
}
