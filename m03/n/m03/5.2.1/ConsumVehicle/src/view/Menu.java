/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Pablo Rodriguez
 */
public class Menu extends JFrame{
    public JMenu mnu;
    public JMenuBar menuBar;
    public JMenuItem menuItem1, menuItem2, menuItem3;
    
    public Menu() {
        getContentPane().setLayout(new BorderLayout());
        menuBar = new JMenuBar();
        
        //Creo el menú del botón Exit
        mnu = new JMenu("Exit");
        //Creo la opción Exit
        menuItem1 = new JMenuItem("Exit");
        //le añado el actioncommand
        menuItem1.setActionCommand("exit");
        //añado el botón exit al menú exit
        mnu.add(menuItem1);
        //añado el menu exit a la barra de menu
        menuBar.add(mnu);
        
        
        //Hago lo mismo para el menú y las opciones de formulario
        
        //Creo el menú fuel
        mnu = new JMenu("Fuel");
        //creo el item, le añado el action command y los meto en el menu
        menuItem2 = new JMenuItem("Fuel Options");
        menuItem2.setActionCommand("option1");
        mnu.add(menuItem2);
        
        menuItem3 = new JMenuItem("Calculate Consumption");
        menuItem3.setActionCommand("option2");
        mnu.add(menuItem3);
        
        //añado el menu a la barra
        menuBar.add(mnu);
        
        //declaro el menubar como tal
        setJMenuBar(menuBar);
    }
}
