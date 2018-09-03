/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.businesstraining.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Category implements Serializable {

    @EmbeddedId
    private CategoryId categoryId;
    
    private String libelle;

    public Category() {
    }

    public Category(CategoryId categoryId, String libelle) {
        this.categoryId = categoryId;
        this.libelle = libelle;
    }
    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    
    public String getName() {
        return categoryId.getName();
    }

    public Date getCreateDate() {
        return categoryId.getCreateDate();
    }
}
