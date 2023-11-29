/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.entitiesMB;

import com.entities.Products;
import com.sessionbean.ProductsFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;

/**
 *
 * @author nguye
 */
@Named(value = "cartProcessMB")
@SessionScoped
public class CartProcessMB implements Serializable {
    
    @EJB
    private ProductsFacadeLocal productsFacade;

    /**
     * Creates a new instance of CartProcessMB
     */
    private int quantity = 1;
    static Map<Products, Integer> cartMap = new HashMap<>();
    
    public CartProcessMB() {
        
    }

    //add cart 
    public String addCart(int id) {
        Products products = productsFacade.find(id);
        if (products != null) {
            if (cartMap.containsKey(products)) {
                cartMap.replace(products, quantity);
            } else {
                cartMap.put(products, quantity);
            }
        }
        return "cart";
    }

    //increase cart
    public String increaseCart(int id, int newquantity) {
        Products products = productsFacade.find(id);
        cartMap.replace(products, newquantity);
        return "cart";
    }

    //decrease Cart decreaseCart
    public String decreaseCart(int id, int newquantity) {
        Products products = productsFacade.find(id);
        cartMap.replace(products, newquantity);
        return "cart";
    }

    //sum cart 
    public int sumProductCart() {
        int sum = 0;
        for (Map.Entry<Products, Integer> e : cartMap.entrySet()) {            
            sum += e.getValue();
        }
        return sum;
    }
    
        public double sumCart(){
        double sum = 0;
        for(Map.Entry<Products, Integer> e : cartMap.entrySet()){
            sum += e.getKey().getPrice() * e.getValue().doubleValue();           
        }
        return sum;
    }
    

    public String removeItemCart(int id) {
        Products products = productsFacade.find(id);
        cartMap.remove(products);
        return "cart";
    }

    public String clearnCart() {
        cartMap.clear();
        quantity = 1;
        return "cart";
    }

    //geter seter
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Map<Products, Integer> getCartMap() {
        return cartMap;
    }
    
    public  void setCartMap(Map<Products, Integer> cartMap) {
       this.cartMap = cartMap;
    }
    
}
