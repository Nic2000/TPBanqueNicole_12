/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.itu.tpbanquenicole_12.ejb;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.itu.tpbanquenicole_12.entities.CompteBancaire;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

    @PersistenceContext (unitName = "banquePU")
    private EntityManager em;
    
    public List<CompteBancaire> getAllComptes() {
        TypedQuery query = em.createNamedQuery("CompteBancaire.findAll", CompteBancaire.class);
        return query.getResultList();
    }
    public void creerCompte(CompteBancaire c) {
       em.persist(c);
    }
    public long nbComptes(){
        TypedQuery<Long> query = em.createQuery("select count(c) from CompteBancaire c", Long.class);
        return query.getSingleResult();
    }   
    @Resource
    private javax.transaction.UserTransaction utx;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
