/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Class User
 * @author Pablo Rodriguez
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String role;
    private String email;
    private String address;
    private String dni;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    

    public User(String name, String password, String role, String email, String address) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
        this.address = address;
        this.dni = dni;
    }

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}
