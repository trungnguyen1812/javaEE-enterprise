/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "Orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOderID", query = "SELECT o FROM Orders o WHERE o.oderID = :oderID"),
    @NamedQuery(name = "Orders.findByClientID", query = "SELECT o FROM Orders o WHERE o.clientID = :clientID"),
    @NamedQuery(name = "Orders.findByAdminID", query = "SELECT o FROM Orders o WHERE o.adminID = :adminID"),
    @NamedQuery(name = "Orders.findByAddress", query = "SELECT o FROM Orders o WHERE o.address = :address"),
    @NamedQuery(name = "Orders.findByOrderDate", query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Orders.findByStastus", query = "SELECT o FROM Orders o WHERE o.stastus = :stastus"),
    @NamedQuery(name = "Orders.findByPrice", query = "SELECT o FROM Orders o WHERE o.price = :price")})
public class Orders implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Phone")
    private byte[] phone;
    @JoinColumn(name = "AccontID", referencedColumnName = "AccontID")
    @ManyToOne
    private Admin accontID;
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    @ManyToOne(optional = false)
    private ClientAccount accountID;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OderID")
    private Integer oderID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ClientID")
    private int clientID;
    @Column(name = "AdminID")
    private Integer adminID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Stastus")
    private String stastus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private double price;

    public Orders() {
    }

    public Orders(Integer oderID) {
        this.oderID = oderID;
    }

//    public Orders(Integer oderID, int clientID, String address, byte[] phone, Date orderDate, String stastus, double price) {
//        this.oderID = oderID;
//        this.clientID = clientID;
//        this.address = address;
//        this.phone = phone;
//        this.orderDate = orderDate;
//        this.stastus = stastus;
//        this.price = price;
//    }

    public Integer getOderID() {
        return oderID;
    }

//    public void setOderID(Integer oderID) {
//        this.oderID = oderID;
//    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStastus() {
        return stastus;
    }

    public void setStastus(String stastus) {
        this.stastus = stastus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oderID != null ? oderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.oderID == null && other.oderID != null) || (this.oderID != null && !this.oderID.equals(other.oderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Orders[ oderID=" + oderID + " ]";
    }

    public byte[] getPhone() {
        return phone;
    }

    public void setPhone(byte[] phone) {
        this.phone = phone;
    }

    public Admin getAccontID() {
        return accontID;
    }

    public void setAccontID(Admin accontID) {
        this.accontID = accontID;
    }

    public ClientAccount getAccountID() {
        return accountID;
    }

    public void setAccountID(ClientAccount accountID) {
        this.accountID = accountID;
    }
    
}
