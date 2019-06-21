package model;

import java.util.ArrayList;

/**
 *
 * @author Pablo Rodriguez
 */
public class Fuel {
    
    private String name;
    private Double price;

    //getters n setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    //constructors
    public Fuel() {
    }

    public Fuel(String name) {
        this.name = name;
    }

    
    public Fuel(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    
    public boolean equals(final Object other) {
        boolean b = false;
        if (other == null) b = false;  //second object is null.
        else {	//other!=null
            if (this == other) b = true; //the same object.
            else { //not the same object.
                if (other instanceof Fuel) { //second object is a fuel
                    final Fuel otherfuel = (Fuel) other;
                    //assess equality of fuels.
                    if (this.name.equals(otherfuel.name)) b = true;
                }
                else b = false; //not a fuel.
            }
        }
        return b;
    }

}
