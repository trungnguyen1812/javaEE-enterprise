/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.entitiesMB;

import com.entities.ClientAccount;
import com.sessionbean.ClientAccountFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
@Named(value = "accountMB")

@SessionScoped
public class AccountMB implements Serializable{

    @EJB
    private ClientAccountFacadeLocal clientAccountFacade;

    private String accountName;
    private String accountAddress;
    private String accountEmail;
    private String accountPassWord;
    private ClientAccount clientAccount;
    

    /**
     * Creates a new instance of AccountMB
     */
    public AccountMB() {
        clientAccount = new ClientAccount();
    }

    //register
    public String register() {
        clientAccountFacade.create(clientAccount);
        return "login";
    }

    //login client 
    public String checkLogin() {
         clientAccount = clientAccountFacade.findClientAccountByEmail(accountEmail);
        if (clientAccount != null) {
            if (clientAccount.getAccountPassWord().equals(accountPassWord)) {
                return "index";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Password is incorrect!!!"));
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Email is incorrect!!!"));
        return "login";
    }
    
    //show list account lient 
        public List<ClientAccount> showAllAccountAdmin() {

        return clientAccountFacade.findAll();

    }
        
        
    public  String addClient(){
        clientAccountFacade.create(clientAccount);
        return "managerAccountClient";
    }
    
       public String deleteClient() {
        clientAccountFacade.remove(clientAccount);
        return "managerAccountClient";
    }

    //show detail admin
    public String showDetaiClient(int id) {
        clientAccount = clientAccountFacade.find(id);
        return "detailClientAcc";
    }
    
    //update admin
    
      public String updateClient() {
        clientAccountFacade.edit(clientAccount);
        return "managerAccountClient";
    }

    //logout 
    public String logout(){
          HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
            .getExternalContext().getSession(false);
        session.invalidate();
        return "login";
    }
    




//Get - Set//
    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountPassWord() {
        return accountPassWord;
    }

    public void setAccountPassWord(String accountPassWord) {
        this.accountPassWord = accountPassWord;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }



}
