/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControladorMonedas;
import Controller.WindowController;
import Model.Moneda;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Pablo Rodriguez
 */
public class Vista extends JFrame{
    
    public JButton btEuros, btMoneda;
    public JPanel panelBotones, panelResult;
    public JLabel lResultado, lText;
    public JTextField campoTexto;
    public JMenuBar menuBar;
    
    public Vista(){
        getContentPane().setLayout(new BorderLayout());
        ControladorMonedas controladorMoneda = new ControladorMonedas(new Moneda("euro", 0.5), this);
        
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        
        panelResult = new JPanel();
        panelResult.setLayout(new FlowLayout());
        
        btEuros = new JButton("Convertir a Euros");
        btMoneda = new JButton("Convertir a Moneda");
        
        btEuros.addActionListener(controladorMoneda);
        btMoneda.addActionListener(controladorMoneda);
        
        btEuros.setActionCommand("btEuros");
        btMoneda.setActionCommand("btMoneda");
        
        lText= new JLabel("Resultado: ");
        lResultado = new JLabel();
        campoTexto = new JTextField(20);
        
        panelBotones.add(btEuros);
        panelBotones.add(btMoneda);
        
        panelResult.add(lText);
        panelResult.add(lResultado);
        
        add(campoTexto, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.SOUTH);
        add(panelResult, BorderLayout.CENTER);
        
        buildMenuBar();
                
    }
    
    private void buildMenuBar(){
        menuBar = new JMenuBar();
        JMenu mnu;
        JMenuItem mnuItem;
        
        WindowController windowController = new WindowController(this);
        
        mnu = new JMenu("File");
        mnuItem = new JMenuItem("Exit");
        mnuItem.setActionCommand("exit");
        mnuItem.addActionListener(windowController);
        mnu.add(mnuItem);
        menuBar.add(mnu);
        
        mnu = new JMenu ("Welcome");
        mnuItem = new JMenuItem("Hello!");
        mnuItem.setActionCommand("hello-dolly");
        mnuItem.addActionListener(windowController);
        mnu.add(mnuItem);
        menuBar.add(mnu);
        
        setJMenuBar (menuBar);
        
    }
}
