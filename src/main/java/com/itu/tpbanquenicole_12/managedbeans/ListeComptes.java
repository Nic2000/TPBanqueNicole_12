/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.itu.tpbanquenicole_12.managedbeans;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import com.itu.tpbanquenicole_12.ejb.GestionnaireCompte;
import com.itu.tpbanquenicole_12.entities.CompteBancaire;
import java.util.List;
import javax.ejb.EJB;
/**
 *
 * @author Nicole
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {

    /**
     * Constructeur
     */
    public ListeComptes() {
    }
      @EJB
  private GestionnaireCompte gestionnaireCompte;
  
  private List<CompteBancaire> listeComptes;

  /**
   *Récupère la Liste des comptes bancaires
   */
  
  public List<CompteBancaire> getAllComptes() {
    if (listeComptes == null) {
      listeComptes = gestionnaireCompte.getAllComptes();
    }
    return listeComptes;
  }
  
    
}
