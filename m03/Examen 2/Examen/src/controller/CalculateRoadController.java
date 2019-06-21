package controller;

import view.CalculateRoadView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.TravelTimeCalculator;
import view.MainFrame;

/**
 * Controlador del menú para calcular distancias
 *
 * @author Pablo Rodriguez
 */
public class CalculateRoadController extends Component implements ActionListener {

    private CalculateRoadView vista;
    private TravelTimeCalculator model;

    public CalculateRoadController(MainFrame menu, TravelTimeCalculator model) {
        this.model = model;
        this.vista = new CalculateRoadView(model);
        menu.setContentPane(vista);
        menu.validate();

        this.vista.calDistance.addActionListener(this);

    }

    /**
     * Process request del menu, solo recibirá una opción
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "Calculate":
                calculate();
                break;
        }
    }

    /**
     * Método para calcular distancia
     */
    private void calculate() {

        try {
            if (vista.txtDistance.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Empty distance imput, please put any distance");
            } else {
                double distance = Double.parseDouble(vista.txtDistance.getText());
                String roadName = (String) vista.select.getSelectedItem();
                double result = model.calculateTime(distance, roadName);
                vista.txtResultCal.setText(String.valueOf(result));
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Invalid Distance Introducid");
        }
    }
}
