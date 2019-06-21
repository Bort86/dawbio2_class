/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Moneda;
import View.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Pablo Rodriguez
 */
public class ControladorMonedas implements ActionListener{
    Moneda moneda;
    Vista vista;
    
    //constructor
    public ControladorMonedas(Moneda moneda, Vista vista) {
        this.moneda = moneda;
        this.vista = vista;
        
        //añadir eventlisteners
        //this.vista.btEuros.addActionListener(this);
      //  this.vista.btMoneda.addActionListener(this);
        
    }
    // Inicio la vista
    public void iniciarVista(){
        vista.setTitle("Conversor");
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btEuros == e.getSource()) {
            if (!"".equals(vista.campoTexto.getText())) {
                try {
                    String texto_introducido = vista.campoTexto.getText();
                    double cantidad = Double.parseDouble(texto_introducido);
                    double total = moneda.convierteAEuros(cantidad);
                    vista.lResultado.setText(""+total);
                } catch (NumberFormatException ex){
                    vista.lResultado.setText("Introduzca una cantidad válida");
                }
            }
        } else if (vista.btMoneda == e.getSource()){
            if (!"".equals(vista.campoTexto.getText())) {
                try {
                    String texto_introducido = vista.campoTexto.getText();
                    double cantidad = Double.parseDouble(texto_introducido);
                    double total = moneda.convierteAMoneda(cantidad);
                    vista.lResultado.setText(""+total);                    
                } catch (NumberFormatException ex){
                    vista.lResultado.setText("Introduzca una cantidad válida");
                }
            }
        }
    } 
}
