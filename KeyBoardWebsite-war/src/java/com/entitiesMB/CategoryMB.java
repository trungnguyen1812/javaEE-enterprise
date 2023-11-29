/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.entitiesMB;

import com.entities.Category;
import com.sessionbean.CategoryFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author nguye
 */
@Named(value = "categoryMB")
@SessionScoped
public class CategoryMB implements Serializable {

    @EJB
    private CategoryFacadeLocal categoryFacade;

    private Category category;
    private int categoryID;

    /**
     * Creates a new instance of CategoryMB
     */
    public CategoryMB() {
        category = new Category();
    }

    //show all category
    public List<Category> showAllCategori() {
        return categoryFacade.findAll();
    }

    //add category 
    public String addCategory() {
        category.setCategoryID(categoryID);
        categoryFacade.create(category);
        return "categoryAdmin";
    }

    //delete category
    public String deleteCategory(int categoryID) {
        category.setCategoryID((categoryID));
        categoryFacade.remove(categoryFacade.find(categoryID));
        return "categoryAdmin";
    }

    //show detail category
    public String showDetailCategory(int id) {
        category = categoryFacade.find(id);
        return "categoryDetail";
    }

    //update category
    public String updateCategory() {
        categoryFacade.edit(category);
        return "categoryAdmin";
    }

    public CategoryFacadeLocal getCategoryFacade() {
        return categoryFacade;
    }

    public void setCategoryFacade(CategoryFacadeLocal categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

}
