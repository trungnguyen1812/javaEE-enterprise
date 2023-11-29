/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.entitiesMB;

import com.entities.Admin;
import com.sessionbean.AdminFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author nguye
 */
@Named(value = "adminMB")
@SessionScoped

public class AdminMB implements Serializable {

    @EJB
    private AdminFacadeLocal adminFacade;
    private String accountName;
    private String acountPass;
    private Admin admin;

    /**
     * Creates a new instance of AdminMB
     */
    public AdminMB() {
        admin = new Admin();
    }

    //login client 
    public String checkLogin() {
        admin = adminFacade.findAdminByName(accountName, acountPass);
        if (admin != null) {
            if (admin.getAccountPass().equals(acountPass)) {
                HttpServletRequest httpReq = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                httpReq.getSession().setAttribute("adminLogin", "loggedIn");
                return "adminHome";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Password is incorrect!!!"));
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Name is incorrect!!!"));
        return "loginAdmin";
    }

    //show all list products
    public List<Admin> showAllAccountAdmin() {

        return adminFacade.findAll();

    }

    //create account admin
    public String addAdmin() {
     
        adminFacade.create(admin);
        return "managerAccountAdmin";
    }

    public String deleteAdmin() {
        adminFacade.remove(admin);
        return "managerAccountAdmin";
    }

    //show detail admin
    public String showDetaiAdmin(int id) {
        admin = adminFacade.find(id);
        return "detailAccountAdmin";
    }
    
    //update admin
    
      public String updateAdmin() {
        adminFacade.edit(admin);
        return "managerAccountAdmin";
    }

    //logout 
//    public String logout(){
//          HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
//            .getExternalContext().getSession(false);
//        session.invalidate();
//        return "login";
//    }
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAcountPass() {
        return acountPass;
    }

    public void setAcountPass(String acountPass) {
        this.acountPass = acountPass;
    }

    public AdminFacadeLocal getAdminFacade() {
        return adminFacade;
    }

    public void setAdminFacade(AdminFacadeLocal adminFacade) {
        this.adminFacade = adminFacade;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    

}
