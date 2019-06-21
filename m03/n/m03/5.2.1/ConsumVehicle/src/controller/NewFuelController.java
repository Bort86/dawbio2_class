package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Fuel;
import view.Menu;
import view.NewFuelView;

/**
 *
 * @author Pablo Rodriguez
 */
public class NewFuelController extends Component implements ActionListener {

    private NewFuelView vista;
    private ArrayList<Fuel> fuels;

    public NewFuelController(Menu menu, ArrayList<Fuel> fuels) {
        this.vista = new NewFuelView();
        menu.setContentPane(vista);
        menu.validate();

        this.fuels = new ArrayList<Fuel>();
        this.fuels = fuels;

        this.vista.addFuel.addActionListener(this);
        this.vista.modifyFuel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            String typeFuel = vista.txtfuel.getText();
            if (!typeFuel.isEmpty()) {
                String action = e.getActionCommand();
                switch (action) {
                    case "Add Fuel":
                        add();
                        break;
                    case "Modify Fuel":
                        modify();
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Empty fuel type input");
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Invalid price");
        }
    }

    public void add() {
        
        String nameFuel = vista.txtfuel.getText();
        double priceFuel = Double.parseDouble(vista.txtprice.getText());
        Fuel newfuel = new Fuel(nameFuel);
        
        if (!fuels.contains(newfuel)){
            newfuel = new Fuel (nameFuel, priceFuel);
            fuels.add(newfuel);
            JOptionPane.showMessageDialog(null, "New fuel type added");
        } else {
            JOptionPane.showMessageDialog(null, "This fuel already exists");
        }
        
    }

    public void modify() {
        
        String nameFuel = vista.txtfuel.getText();
        double priceFuel = Double.parseDouble(vista.txtprice.getText());
        Fuel fuelFind = new Fuel (nameFuel);
        boolean result = false;
        for (Fuel fuel: fuels){
            if(fuel.equals(fuelFind)){
                fuel.setPrice(priceFuel);
                result = true;
                break;
            }
        }
        if (result){
            JOptionPane.showMessageDialog(null, "Fuel modified ok");
        } else {
            JOptionPane.showMessageDialog(null, "The fuel doesn't exist");
        }
    }

}
