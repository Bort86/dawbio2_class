package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Fuel;

/**
 *
 * @author Pablo Rodriguez
 */
public class CalculateFuelView extends JPanel {
    public JLabel fuelAmmount, distance, fuelName;
    public JTextField txtFuelAmmount, txtDistance;
    public JComboBox select;
    public JButton calFuel;
    
    public CalculateFuelView(ArrayList<Fuel> loadedFuel){
        setLayout(new GridLayout(10,2));
        
        fuelAmmount = new JLabel("Ammount of fuel: ");
        txtFuelAmmount = new JTextField(10);
        
        distance = new JLabel("Distance to be made: ");
        txtDistance = new JTextField(10);
        
        fuelName = new JLabel("Type of Fuel: ");
        ArrayList<String> fuelOptions = new ArrayList<>();
        for (Fuel fuel: loadedFuel){
            fuelOptions.add(fuel.getName());
        }
        select = new JComboBox(fuelOptions.toArray());
        
        calFuel = new JButton();
        calFuel.setText("Calculate");
        
        add(fuelAmmount);
        add(txtFuelAmmount);
        add(distance);
        add(txtDistance);
        add(fuelName);
        add(select);
        add(calFuel);
        
    }
    
}
