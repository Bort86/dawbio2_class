package controller;

import model.Fuel;
import view.Menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo Rodriguez
 */
public class WindowController extends Component implements ActionListener {

    //atributos: la vista del menu y 
    //los fuels con sus cambios predeterminados
    private Menu menu;
    private ArrayList<Fuel> loadedFuel;
    
    public WindowController(Menu menu){
        this.menu = menu;
        
        this.menu.menuItem1.addActionListener(this);
        this.menu.menuItem2.addActionListener(this);
        this.menu.menuItem3.addActionListener(this);
    }
    
    public void iniciarVista(){
        
        menu.setTitle("Practica 5.2.1");
        menu.pack();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setSize(400, 500);
    }
    
    public void cargarFuels() {
        loadedFuel = new ArrayList<Fuel>();
        loadedFuel.add(new Fuel("Gasolina",1.40));
        loadedFuel.add(new Fuel("BioDiesel",1.60));
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String action = e.getActionCommand();
        
        switch(action) {
            case "exit":
                exitApp();
                break;
            case "option1":
                newFuel();
                break;
            case "option2":
                calculateFuel();
                break;
        }
    }

    private void exitApp() {
       
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit this App?");
        if (result == JOptionPane.OK_OPTION){
            System.exit(0);
        }
    }

    private void newFuel() {
        NewFuelController nf = new NewFuelController(menu, loadedFuel);
    }

    private void calculateFuel() {
        CalculateFuelController cf = new CalculateFuelController(menu,loadedFuel);
    }

}
