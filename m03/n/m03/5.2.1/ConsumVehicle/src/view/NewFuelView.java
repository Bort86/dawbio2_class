package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Pablo Rodriguez
 */
public class NewFuelView extends JPanel {

    public JLabel fuel, price;
    public JButton addFuel, modifyFuel;
    public JTextField txtfuel, txtprice;

    public NewFuelView() {

        setLayout(new GridLayout(10, 2));

        fuel = new JLabel("Fuel Type");
        price = new JLabel("Fuel Price");

        txtfuel = new JTextField(10);
        txtprice = new JTextField(10);

        addFuel = new JButton();
        addFuel.setText("Add Fuel");

        modifyFuel = new JButton();
        modifyFuel.setText("Modify Fuel");

        add(fuel);
        add(txtfuel);
        add(price);        
        add(txtprice);
        add(addFuel);
        add(modifyFuel);
    }
}
