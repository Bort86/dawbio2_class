/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import Controller.ControladorMonedas;
import Model.Moneda;
import View.Vista;

/**
 *
 * @author Pablo Rodriguez
 */
public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Moneda moneda = new Moneda ("Euros", 0.5);
        Vista vista = new Vista();
        ControladorMonedas cm = new ControladorMonedas(moneda, vista);
        cm.iniciarVista();
        
    }
    
}
