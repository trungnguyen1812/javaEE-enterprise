/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "ClientAccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientAccount.findAll", query = "SELECT c FROM ClientAccount c"),
    @NamedQuery(name = "ClientAccount.findByAccountID", query = "SELECT c FROM ClientAccount c WHERE c.accountID = :accountID"),
    @NamedQuery(name = "ClientAccount.findByAccountName", query = "SELECT c FROM ClientAccount c WHERE c.accountName = :accountName"),
    @NamedQuery(name = "ClientAccount.findByAccountEmail", query = "SELECT c FROM ClientAccount c WHERE c.accountEmail = :accountEmail"),
    @NamedQuery(name = "ClientAccount.findByAccountAddress", query = "SELECT c FROM ClientAccount c WHERE c.accountAddress = :accountAddress"),
    @NamedQuery(name = "ClientAccount.findByAccountPassWord", query = "SELECT c FROM ClientAccount c WHERE c.accountPassWord = :accountPassWord")})
public class ClientAccount implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountID")
    private Collection<Orders> ordersCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AccountID")
    private Integer accountID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AccountName")
    private String accountName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "AccountEmail")
    private String accountEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 555)
    @Column(name = "AccountAddress")
    private String accountAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "AccountPassWord")
    private String accountPassWord;

    public ClientAccount() {
    }

//    public ClientAccount(String accountName, String accountEmail, String accountAddress, String accountPassWord) {
//        this.accountID = accountID;
//        this.accountName = accountName;
//        this.accountEmail = accountEmail;
//        this.accountAddress = accountAddress;
//        this.accountPassWord = accountPassWord;
//    }

//    public ClientAccount(Integer accountID) {
//        this.accountID = accountID;
//    }

    public Integer getAccountID() {
        return accountID;
    }

//    public void setAccountID(Integer accountID) {
//        this.accountID = accountID;
//    }
    

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public String getAccountPassWord() {
        return accountPassWord;
    }

    public void setAccountPassWord(String accountPassWord) {
        this.accountPassWord = accountPassWord;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientAccount)) {
            return false;
        }
        ClientAccount other = (ClientAccount) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.ClientAccount[ accountID=" + accountID + " ]";
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }


}
