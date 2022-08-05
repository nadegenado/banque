/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 *
 * @author USER
 */
public class Client {
     @Id
    private String id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String numerotel;
    @DBRef
    private List<Compte> compte;

    public Client(String id, String nom, String prenom, String adresse, String email, String numerotel, List<Compte> compte) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.numerotel = numerotel;
        this.compte = compte;
    }

    public Client(String bilbo_Baggins, String burglar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerotel() {
        return numerotel;
    }

    public void setNumerotel(String numerotel) {
        this.numerotel = numerotel;
    }

    public List<Compte> getCompte() {
        return compte;
    }

    public void setCompte(List<Compte> compte) {
        this.compte = compte;
    }
    
    
   @Override
    public boolean equals(Object o){
        if(this ==  o)
            return true;
        if(!(o instanceof Client))
            return false;
        Client client = (Client) o;
         return Objects.equals(this.id, client.id) && 
                Objects.equals(this.nom, client.nom) && 
                Objects.equals(this.prenom, client.prenom) && 
                Objects.equals(this.adresse, client.adresse) &&
                Objects.equals(this.email, client.email) && 
                Objects.equals(this.numerotel, client.numerotel) &&
                Objects.equals(this.compte, client.compte); 
       
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.nom, this.prenom, this.adresse, this.email, this.numerotel, this.compte);
    }
   @Override
    public String toString(){
        return "Client {" + "id = " + this.id + ", nom = '" + this.nom +'\'' + ", comptes='" +this.compte + '\'' + '}';
    }
     
    
}
