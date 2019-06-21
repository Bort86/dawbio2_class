package controller;

import view.ConfigRoadView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.TravelTimeCalculator;
import view.MainFrame;

/**
 * Controlador de menú de configuración de distancias
 * @author Pablo Rodriguez
 */
public class ConfigRoadController extends Component implements ActionListener {

    private ConfigRoadView vista;
    private TravelTimeCalculator model;

    public ConfigRoadController(MainFrame menu, TravelTimeCalculator model) {
        //propiedades
        this.model = model;
        this.vista = new ConfigRoadView(model);
        //aquí cargamos la vista del panel dentro de la ventana principal
        menu.setContentPane(vista);
        menu.validate();
        
        //yo añado los actionlistener en el controler, porque así me evito
        //tener que inicializarlo dentro de la vista
        this.vista.updateRoad.addActionListener(this);
        this.vista.eraseRoadValues.addActionListener(this);
    }

    /**
     * Process request del controlador
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "Update Roads":
                updateRoads();
                break;
            case "Erase imput values":
                resetValues();
                break;
        }
    }

    /**
     * Método para actualizar distancias
     * Recoge los nombres y las distancias de los arrays de los JLabel
     * y Jtextfield de su vista, y luego actualiza el modelo
     */
    private void updateRoads() {
        ArrayList<String> names = new ArrayList<String>();
        for (JLabel name : this.vista.names){
            names.add(name.getText());
        }
        
        ArrayList<Double> valors = new ArrayList<Double>();
        for (JTextField valor: this.vista.valors ){
            valors.add(Double.parseDouble(valor.getText()));
        }
        
        for (int i = 0; i < names.size(); i++){
            model.setSpeedLimit(names.get(i), valors.get(i));
        }
        JOptionPane.showMessageDialog(null, "Roads updates");
    }

    /**
     * método para resetear los valores
     * Simplemente le indica a la vista que ponga todos los JtextField 
     * con valores vacíos
     */
    private void resetValues() {
        for (JTextField valor: this.vista.valors){
            valor.setText(null);
        }
    }

}
