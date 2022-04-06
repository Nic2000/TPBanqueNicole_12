/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.itu.tpbanquenicole_12.ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.itu.tpbanquenicole_12.entities.CompteBancaire;
import javax.persistence.Query;
/**
 *
 * @author Nicole
 */
@DataSourceDefinition (
    className="com.mysql.cj.jdbc.MysqlDataSource",
    name="java:app/jdbc/banque",
    serverName="localhost",
    portNumber=3306,
    user="root",              // nom et
    password="root", // mot de passe que vous avez donnés lors de la création de la base de données
    databaseName="banque",
    properties = {
      "useSSL=false",
      "allowPublicKeyRetrieval=true"
    }
)
@Stateless
public class GestionnaireCompte {

    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;
    public List<CompteBancaire> getAllComptes() {
       Query query = em.createNamedQuery("CompteBancaire.findAll");
       return query.getResultList();
    }
    public void creerCompte(CompteBancaire c) {
       em.persist(c);
    }
    public int nbComptes(){
        Query query = em.createNamedQuery("select count(c) from CompteBancaire c");
        return (int) query.getSingleResult();
    }   
    @Resource
    private javax.transaction.UserTransaction utx;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
