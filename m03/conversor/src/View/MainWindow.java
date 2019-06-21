/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JFrame;

/**
 *
 * @author Pablo Rodriguez
 */
public class MainWindow {
    public MainWindow(){
        initWindowComponents();

    }

    private void initWindowComponents() {
        JFrame f = new JFrame("Titulo de ventana");
        f.setSize(400, 300); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setVisible(true);
    }
}
