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
import javax.persistence.Lob;
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
@Table(name = "About")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "About.findAll", query = "SELECT a FROM About a"),
    @NamedQuery(name = "About.findByAboutID", query = "SELECT a FROM About a WHERE a.aboutID = :aboutID"),
    @NamedQuery(name = "About.findByTilte", query = "SELECT a FROM About a WHERE a.tilte = :tilte"),
    @NamedQuery(name = "About.findBySlogan", query = "SELECT a FROM About a WHERE a.slogan = :slogan"),
    @NamedQuery(name = "About.findByDescription", query = "SELECT a FROM About a WHERE a.description = :description")})
public class About implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AboutID")
    private Integer aboutID;
    @Size(max = 500)
    @Column(name = "Tilte")
    private String tilte;
    @Lob
    @Column(name = "Picture")
    private byte[] picture;
    @Size(max = 100)
    @Column(name = "Slogan")
    private String slogan;
    @Size(max = 1073741823)
    @Column(name = "Description")
    private String description;

    public About() {
    }
    
    

    public About(Integer aboutID) {
        this.aboutID = aboutID;
    }

    public Integer getAboutID() {
        return aboutID;
    }

    public void setAboutID(Integer aboutID) {
        this.aboutID = aboutID;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aboutID != null ? aboutID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof About)) {
            return false;
        }
        About other = (About) object;
        if ((this.aboutID == null && other.aboutID != null) || (this.aboutID != null && !this.aboutID.equals(other.aboutID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.About[ aboutID=" + aboutID + " ]";
    }
    
}
