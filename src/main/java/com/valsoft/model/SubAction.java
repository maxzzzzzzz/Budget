package com.valsoft.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

/**
 * Created by Asus on 18.06.2017.
 */
@Entity
@Table(name = "SUB_ACTION")
public class SubAction {
    @Id
    @GeneratedValue
    @Column(name = "SUB_ACTION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ACTION_ID")
    private Action action;

//    @ManyToOne
//    @JoinColumn(name = "CATEGORY_ID")
//    private Category category;
    public SubAction(){}

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PICTURE")
    private String picture;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


}
