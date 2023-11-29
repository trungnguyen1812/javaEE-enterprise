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
@Table(name = "FeedBack")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FeedBack.findAll", query = "SELECT f FROM FeedBack f"),
    @NamedQuery(name = "FeedBack.findByCustomID", query = "SELECT f FROM FeedBack f WHERE f.customID = :customID"),
    @NamedQuery(name = "FeedBack.findByName", query = "SELECT f FROM FeedBack f WHERE f.name = :name"),
    @NamedQuery(name = "FeedBack.findByContent", query = "SELECT f FROM FeedBack f WHERE f.content = :content")})
public class FeedBack implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CustomID")
    private Integer customID;
    @Size(max = 50)
    @Column(name = "Name")
    private String name;
    @Size(max = 1073741823)
    @Column(name = "Content")
    private String content;

    public FeedBack() {
    }

    public FeedBack(Integer customID) {
        this.customID = customID;
    }

    public Integer getCustomID() {
        return customID;
    }

    public void setCustomID(Integer customID) {
        this.customID = customID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customID != null ? customID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeedBack)) {
            return false;
        }
        FeedBack other = (FeedBack) object;
        if ((this.customID == null && other.customID != null) || (this.customID != null && !this.customID.equals(other.customID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.FeedBack[ customID=" + customID + " ]";
    }
    
}
