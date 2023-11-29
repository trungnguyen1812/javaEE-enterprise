/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbean;

import com.entities.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author nguye
 */
@Stateless
public class ProductsFacade extends AbstractFacade<Products> implements ProductsFacadeLocal {

    @PersistenceContext(unitName = "KeyBoardWebsite-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsFacade() {
        super(Products.class);
    }
    
    @Override
        public Integer nextID() {
        Query query = em.createQuery("SELECT max(p.productID) FROM Products p", Products.class);
        return (Integer) query.getSingleResult();
    }
        
      
    @Override
    public List<Products> showListProductPagination(int pageNumber) {
        Query query = em.createNamedQuery("Products.findAll");
        int pageSize = 8;
        query.setMaxResults(pageSize);
        query.setFirstResult((pageNumber - 1) * pageSize);
        return query.getResultList();
    }
    
    

    @Override
    public List<Products> findByProductSame(String key) {
        Query query = em.createQuery("SELECT p FROM Products p WHERE p.productName like :keydes", Products.class);
        query.setParameter("keydes", "%" + key + "%");
        return query.getResultList();
    }
    
  
    @Override
    public List<Products> findLimit(int quantity) {
        Query query = em.createQuery("SELECT p FROM Products p", Products.class);        
        query.setMaxResults(quantity);
       
        return query.getResultList();
    }

    @Override
    public List<Products> showListProbySearch(String st) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
