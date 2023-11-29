/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "Admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByAccontID", query = "SELECT a FROM Admin a WHERE a.accontID = :accontID"),
    @NamedQuery(name = "Admin.findByAccontName", query = "SELECT a FROM Admin a WHERE a.accontName = :accontName"),
    @NamedQuery(name = "Admin.findByAccountPass", query = "SELECT a FROM Admin a WHERE a.accountPass = :accountPass")})
public class Admin implements Serializable {

    @OneToMany(mappedBy = "accontID")
    private Collection<Orders> ordersCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AccontID")
    private Integer accontID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AccontName")
    private String accontName;
    @Size(max = 20)
    @Column(name = "AccountPass")
    private String accountPass;

    public Admin() {
    }

//    public Admin(Integer accontID) {
//        this.accontID = accontID;
//    }

//    public Admin(Integer accontID, String accontName) {
//        this.accontID = accontID;
//        this.accontName = accontName;
//    }

    public Integer getAccontID() {
        return accontID;
    }
//
//    public void setAccontID(Integer accontID) {
//        this.accontID = accontID;
//    }

    public String getAccontName() {
        return accontName;
    }

    public void setAccontName(String accontName) {
        this.accontName = accontName;
    }

    public String getAccountPass() {
        return accountPass;
    }

    public void setAccountPass(String accountPass) {
        this.accountPass = accountPass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accontID != null ? accontID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.accontID == null && other.accontID != null) || (this.accontID != null && !this.accontID.equals(other.accontID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Admin[ accontID=" + accontID + " ]";
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }
    
}
