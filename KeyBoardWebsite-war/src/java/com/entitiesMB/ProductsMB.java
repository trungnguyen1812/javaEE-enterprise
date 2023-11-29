/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.entitiesMB;

import com.entities.Category;
import com.entities.Products;
import com.sessionbean.CategoryFacadeLocal;
import com.sessionbean.ProductsFacadeLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author nguye
 */
@Named(value = "productsMB")
@SessionScoped
public class ProductsMB implements Serializable {

    @EJB
    private CategoryFacadeLocal categoryFacade;

    

    @EJB
    private ProductsFacadeLocal productsFacade;

    private Part fileImage;
    private String picture;
    private String keyfind = "";
    private Products products;
    private int nextid;
    private int categoryID;
    private Category category;
    private int productID;
    private final String UPLOAD_DIRECTORY = "img";
    private List<Products> listProducts = new ArrayList<>();
    private boolean isMaxQuantity= false;
    private int limitQuantity=8;

    public boolean isIsMaxQuantity() {
        return isMaxQuantity;
    }

    public void setIsMaxQuantity(boolean isMaxQuantity) {
        this.isMaxQuantity = isMaxQuantity;
    }

    public int getLimitQuantity() {
        return limitQuantity;
    }

    public void setLimitQuantity(int limitQuantity) {
        this.limitQuantity = limitQuantity;
    }
    
    
    

    /**
     * Creates a new instance of ProductsMB
     */
    public ProductsMB() {
        products = new Products();
    }
    
    public List<Products> showLimitPro(){
        return productsFacade.findLimit(this.limitQuantity);
    }
    
    
    //Upload fileImage:
    public void uploadFile() {
        System.out.println("Form has been submitted!");
        System.out.println("fileImage: " + fileImage);
        if (fileImage != null) {
            InputStream content = null;
            try {
                System.out.println("name: " + fileImage.getSubmittedFileName());
                System.out.println("type: " + fileImage.getContentType());
                System.out.println("size: " + fileImage.getSize());
                content = fileImage.getInputStream();
                // Write content to disk or DB.
                FacesContext context = FacesContext.getCurrentInstance();
                ExternalContext ec = context.getExternalContext();
                HttpServletRequest request = (HttpServletRequest) ec.getRequest();

                // gets absolute path of the web application
                String applicationPath = request.getServletContext().getRealPath("");

                // constructs path of the directory to save uploaded fileImage  
                String uploadFilePath = applicationPath + File.separator + "assets" + File.separator + UPLOAD_DIRECTORY;

                // creates the save directory if it does not exists
                File fileImageSaveDir = new File(uploadFilePath);
                if (!fileImageSaveDir.exists()) {
                    fileImageSaveDir.mkdirs();
                }
                OutputStream outputStream = null;
                try {
                    File outputFilePath = new File(uploadFilePath + File.separator + fileImage.getSubmittedFileName());
                    content = fileImage.getInputStream();
                    outputStream = new FileOutputStream(outputFilePath);
                    int read = 0;
                    final byte[] bytes = new byte[1024];
                    while ((read = content.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                    System.out.println("File uploaded successfully!");
                } catch (Exception e) {
                    e.toString();
                    //fileImageName = "";
                } finally {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (content != null) {
                        content.close();
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ProductsMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Add:
    public String addProduct() {
        products.setPicture(fileImage.getSubmittedFileName());
        uploadFile();
         products.setCategoryID(categoryID);
        productsFacade.create(products);
        return "adminHome";
    }

    public List<Products> showAllProduct() {

        return productsFacade.findAll();

    }


    //show detail 
    public String showDetaiProduct(int id) {
        products = productsFacade.find(id);
        return "productsdetail";
    }
    
    
    //update products
    public String updateProduct() {
        products.setPicture(fileImage.getSubmittedFileName());
        uploadFile();
        products.setCategoryID((categoryID));
        productsFacade.edit(products);
        return "adminHome";
    }
    
    

    //delete products
    public String deleteProduct(int productID) {
        productsFacade.remove(productsFacade.find(productID));
        return "adminHome";
    }
    
    
    //show product in lient
    
    public String showProDetailsbyID(int id) {
        products = productsFacade.find(id);
        return "detailshop";
    }
    
    //search
    public List<Products> findByProductSame() {
      listProducts   = productsFacade.findByProductSame(keyfind);
        return listProducts;
    }
    
    //show search
    public List<Products> showProducts() {
        if ("".equals(keyfind)) {
            listProducts = showAllProduct();
        } else {
            listProducts = findByProductSame();
        }
        return listProducts;
    }

    public ProductsFacadeLocal getProductsFacade() {
        return productsFacade;
    }

    public void setProductsFacade(ProductsFacadeLocal productsFacade) {
        this.productsFacade = productsFacade;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getNextid() {
        return nextid;
    }

    public void setNextid(int nextid) {
        this.nextid = nextid;
    }



    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Part getFileImage() {
        return fileImage;
    }

    public void setFileImage(Part fileImage) {
        this.fileImage = fileImage;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getKeyfind() {
        return keyfind;
    }

    public void setKeyfind(String keyfind) {
        this.keyfind = keyfind;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoryFacadeLocal getCategoryFacade() {
        return categoryFacade;
    }

    public void setCategoryFacade(CategoryFacadeLocal categoryFacade) {
        this.categoryFacade = categoryFacade;
    }
    
    

}
