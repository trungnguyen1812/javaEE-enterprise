/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nguye
 */
@Entity
@Table(name = "Contac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contac.findAll", query = "SELECT c FROM Contac c"),
    @NamedQuery(name = "Contac.findByContacID", query = "SELECT c FROM Contac c WHERE c.contacID = :contacID"),
    @NamedQuery(name = "Contac.findByFullName", query = "SELECT c FROM Contac c WHERE c.fullName = :fullName"),
    @NamedQuery(name = "Contac.findByEmail", query = "SELECT c FROM Contac c WHERE c.email = :email"),
    @NamedQuery(name = "Contac.findBySdt", query = "SELECT c FROM Contac c WHERE c.sdt = :sdt"),
    @NamedQuery(name = "Contac.findByNoiDung", query = "SELECT c FROM Contac c WHERE c.noiDung = :noiDung")})
public class Contac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ContacID")
    private Integer contacID;
    @Size(max = 100)
    @Column(name = "FullName")
    private String fullName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 500)
    @Column(name = "Email")
    private String email;
    @Size(max = 10)
    @Column(name = "SDT")
    private String sdt;
    @Size(max = 1073741823)
    @Column(name = "NoiDung")
    private String noiDung;

    public Contac() {
    }

    public Contac(String fullName, String email, String sdt, String noiDung) {
        this.fullName = fullName;
        this.email = email;
        this.sdt = sdt;
        this.noiDung = noiDung;
    }
    
    

    public Contac(Integer contacID) {
        this.contacID = contacID;
    }

    public Integer getContacID() {
        return contacID;
    }

    public void setContacID(Integer contacID) {
        this.contacID = contacID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contacID != null ? contacID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contac)) {
            return false;
        }
        Contac other = (Contac) object;
        if ((this.contacID == null && other.contacID != null) || (this.contacID != null && !this.contacID.equals(other.contacID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Contac[ contacID=" + contacID + " ]";
    }
    
}
