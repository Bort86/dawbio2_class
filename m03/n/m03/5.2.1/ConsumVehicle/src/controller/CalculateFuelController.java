package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Fuel;
import view.CalculateFuelView;
import view.Menu;

/**
 *
 * @author Pablo Rodriguez
 */
public class CalculateFuelController extends Component implements ActionListener {

    private CalculateFuelView vista;
    private ArrayList<Fuel> fuels;
    
    public CalculateFuelController(Menu menu, ArrayList<Fuel> loadedFuel) {
        this.vista = new CalculateFuelView(loadedFuel);
        menu.setContentPane(vista);
        menu.validate();

        this.fuels = new ArrayList<Fuel>();
        this.fuels = fuels;
        
        this.vista.calFuel.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
            String action = e.getActionCommand();
            switch (action) {
                case "Calculate":
                    calculate();
                    break;
            }
    }

    private void calculate() {
        double ammountFuel = Double.parseDouble(vista.txtFuelAmmount.getText());
        double distance = Double.parseDouble(vista.txtDistance.getText());
        String nameFuel = (String)vista.select.getSelectedItem();
        
        double consumption = ammountFuel / (distance / 100);
        
        double ammountEuros = 0;
        for (Fuel fuel: fuels){
            if(fuel.getName().equals(nameFuel)){
                ammountEuros = distance * ammountFuel * fuel.getPrice();
            }
        }
        
        double ammountPerKm = 1; // no he entendido este punto del enunciado
        
        JOptionPane.showMessageDialog(null, "Fuel litres consumed in 100km: " + consumption + "l/km,\n"
                + "Total cost in euros is "+ ammountEuros + "€,\n" +
                "and consumition per km is: " + ammountPerKm);
        
    }
}
