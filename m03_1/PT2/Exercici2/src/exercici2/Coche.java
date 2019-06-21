/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici2;

import java.util.Objects;

/**
 *
 * @author Pablo Rodriguez
 */
public class Coche extends Vehicle {

    private String nombre;

    public Coche() {
    }

    public Coche(String nombre) {
        this.nombre = nombre;
    }
    
    

    public Coche(String nombre, String marca, String model, String motor, int ejes) {
        super(marca, model, motor, ejes);
        this.nombre = nombre;
        super.setRuedas(4);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void endavant() {
        System.out.println("Arrancando " + this.getNombre());
    }

    @Override
    public void aturar() {
        System.out.println("Parando " + this.getNombre());
    }

    @Override
    public void girar() {
        System.out.println("Girando " + this.getNombre());
    }

    @Override
    public String toString() {
        return "Coche{" + "nombre=" + nombre + '}' + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coche other = (Coche) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
    

}
