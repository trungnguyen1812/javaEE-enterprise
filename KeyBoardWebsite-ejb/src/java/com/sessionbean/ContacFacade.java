/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbean;

import com.entities.ClientAccount;
import com.entities.Contac;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author nguye
 */
@Stateless
public class ContacFacade extends AbstractFacade<Contac> implements ContacFacadeLocal {

    @PersistenceContext(unitName = "KeyBoardWebsite-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContacFacade() {
        super(Contac.class);
    }
    


    
}
