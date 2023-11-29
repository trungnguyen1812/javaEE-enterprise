/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbean;

import com.entities.ClientAccount;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author nguye
 */
@Stateless
public class ClientAccountFacade extends AbstractFacade<ClientAccount> implements ClientAccountFacadeLocal {

    @PersistenceContext(unitName = "KeyBoardWebsite-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientAccountFacade() {
        super(ClientAccount.class);
    }
    
      @Override
    public ClientAccount findClientAccountByEmail(String accountEmail) {
        try {
            Query query = em.createNamedQuery("ClientAccount.findByAccountEmail", ClientAccount.class);
            query.setParameter("accountEmail", accountEmail);
            return (ClientAccount) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
}
