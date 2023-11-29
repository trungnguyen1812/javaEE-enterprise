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
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author nguye
 */
@Named(value = "homeMB")
@SessionScoped
public class HomeMB implements Serializable {

    private List<Products> listHome;
    private List<Products> listShop;
    private Products products;
    private int pagination = 1;
    private String search;
    @EJB
    private ProductsFacadeLocal productsFacade;

    /**
     * Creates a new instance of homeMB
     */
    public HomeMB() {
        products = new Products();
       // search("");
    }
    
        
    public String showPageResult(){
        return "search";
    }
    
    public List<Products> showListResult(){
        return productsFacade.showListProbySearch(search);
    }


    public List<Products> getListHome() {
        return listHome;
    }

    public void setListHome(List<Products> listHome) {
        this.listHome = listHome;
    }
    
    public List<Products> showListShopProduct(){
        return productsFacade.showListProductPagination(pagination);
    }

    public int numpage(){
        int t=productsFacade.count();
        int x=(t/8)*8;
        if(t==x){
            return t/8;
        }else{
            return (t/8)+1;
        }
    }
    
    public String pagishop(int i){
        pagination=i;
        return "shop";
    }
    
//    public String detailProduct(int id){
//        prodetail=productsFacade.find(id);
//        System.out.println(id);
//        return "detailproduct";
//    }

    public List<Products> getListShop() {
        return listShop;
    }

    public void setListShop(List<Products> listShop) {
        this.listShop = listShop;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getPagination() {
        return pagination;
    }

    public void setPagination(int pagination) {
        this.pagination = pagination;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    

}
