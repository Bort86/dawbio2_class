/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici1;

/**
 *
 * @author Pablo Rodriguez
 */
public class Quadrat implements Figura2D{
    
    private int costat;
    
    //Constructors

    public Quadrat() {
    }

    public Quadrat(int costat) {
        this.costat = costat;
    }
    
    //Getters n setters

    public int getCostat() {
        return costat;
    }

    public void setCostat(int costat) {
        this.costat = costat;
    }

    @Override
    public String area() {
        return "Área = "+ Math.pow(this.costat,2);
    }

    @Override
    public String perímetre() {
        return "Perímetro = "+ this.costat*4;
    }

    
    
}
