package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.TravelTimeCalculator;
import view.MainFrame;

/**
 * Controlador de la ventana principal, cargará el menú con sus opciones
 * @author Pablo Rodriguez
 */
public class WindowController extends Component implements ActionListener {

    private MainFrame menu;
    private TravelTimeCalculator model;

    public WindowController(MainFrame menu) {
        this.menu = menu;
        this.model = new TravelTimeCalculator();

        this.menu.menuItem1.addActionListener(this);
        this.menu.menuItem2.addActionListener(this);
        this.menu.menuItem3.addActionListener(this);
        this.menu.menuItem4.addActionListener(this);
    }

    public void iniciarVista() {
        menu.setTitle("Examen GUI");
        menu.pack();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setSize(500, 500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "exit":
                exitApp();
                break;
            case "option1":
                configRoad();
                break;
            case "option2":
                calculateRoad();
                break;
            case "option3":
                showInfo();
                break;
        }
    }

    /**
     * Método para salir del programa
     */
    private void exitApp() {
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit this App?");
        if (result == JOptionPane.OK_OPTION){
            System.exit(0);
        }
    }
    
    private void configRoad() {
        ConfigRoadController cr = new ConfigRoadController(menu,model);
    }

    private void calculateRoad() {
        CalculateRoadController crc = new CalculateRoadController(menu,model);
    }

    /**
     * Método para mostrar ventana de info de sistema
     */
    private void showInfo() {
        JOptionPane.showMessageDialog(null, "Nice Program \n Version 2.0 \n Made in Java Swing");
    }

}
