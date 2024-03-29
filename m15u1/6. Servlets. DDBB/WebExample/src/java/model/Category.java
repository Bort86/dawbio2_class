/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pablo Rodriguez
 */
public class Category {

    private int id;
    private String description;

    public Category() {
    }

    public Category(String description) {
        this.description = description;
    }

    public Category(int id) {
        this.id = id;
    }

    public Category(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "id= " + id + ", description= " + description + "<br/>";
    }
}
