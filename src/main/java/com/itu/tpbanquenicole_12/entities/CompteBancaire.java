/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itu.tpbanquenicole_12.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Nicole
 */
@Entity
public class CompteBancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private int solde;
    
    public Long getId() {
        return id;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
    /**
     *constructeur
     */
    public CompteBancaire(){}
    
    public CompteBancaire(String nom, int solde) {  
      this.nom = nom;  
      this.solde = solde;  
    }  

    public void deposer(int montant) {  
      solde += montant;  
    }  

    public void retirer(int montant) {  
      if (montant < solde) {  
        solde -= montant;  
      } else {
        solde = 0;
      }  
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.itu.tpbanquenicole_12.entities.CompteBancaire[ id=" + id + " ]";
    }

   
    
}
