/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumvehicle;

import controller.WindowController;
import view.Menu;

/**
 *
 * @author bort
 */
public class ConsumVehicle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Menu menu = new Menu();
        WindowController wc = new WindowController(menu);
        wc.cargarFuels();
        wc.iniciarVista();
    }
    
}
