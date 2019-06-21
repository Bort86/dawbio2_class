/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Pablo Rodriguez
 */
public class Moneda {
    private String nom;
    private double canvi;
    
    //constructor
    public Moneda(String nom, double canvi) {
        this.nom = nom;
        this.canvi = canvi;
    }
    
    //setters & getters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getCanvi() {
        return canvi;
    }

    public void setCanvi(double canvi) {
        this.canvi = canvi;
    }
    
    //métodos
    public double convierteAEuros(double cantidad) {
        return cantidad*canvi;
    }
    public double convierteAMoneda(double cantidad){
        return cantidad/canvi;
    }
}
