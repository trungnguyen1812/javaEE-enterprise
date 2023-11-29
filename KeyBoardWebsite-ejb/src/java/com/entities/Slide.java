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
@Table(name = "Slide")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Slide.findAll", query = "SELECT s FROM Slide s"),
    @NamedQuery(name = "Slide.findBySlideID", query = "SELECT s FROM Slide s WHERE s.slideID = :slideID"),
    @NamedQuery(name = "Slide.findBySLtile", query = "SELECT s FROM Slide s WHERE s.sLtile = :sLtile"),
    @NamedQuery(name = "Slide.findBySLDescription", query = "SELECT s FROM Slide s WHERE s.sLDescription = :sLDescription")})
public class Slide implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SlideID")
    private Integer slideID;
    @Size(max = 100)
    @Column(name = "SLtile")
    private String sLtile;
    @Lob
    @Column(name = "SLPicture")
    private byte[] sLPicture;
    @Size(max = 1073741823)
    @Column(name = "SLDescription")
    private String sLDescription;

    public Slide() {
    }

    public Slide(Integer slideID) {
        this.slideID = slideID;
    }

    public Integer getSlideID() {
        return slideID;
    }

    public void setSlideID(Integer slideID) {
        this.slideID = slideID;
    }

    public String getSLtile() {
        return sLtile;
    }

    public void setSLtile(String sLtile) {
        this.sLtile = sLtile;
    }

    public byte[] getSLPicture() {
        return sLPicture;
    }

    public void setSLPicture(byte[] sLPicture) {
        this.sLPicture = sLPicture;
    }

    public String getSLDescription() {
        return sLDescription;
    }

    public void setSLDescription(String sLDescription) {
        this.sLDescription = sLDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (slideID != null ? slideID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Slide)) {
            return false;
        }
        Slide other = (Slide) object;
        if ((this.slideID == null && other.slideID != null) || (this.slideID != null && !this.slideID.equals(other.slideID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Slide[ slideID=" + slideID + " ]";
    }
    
}
