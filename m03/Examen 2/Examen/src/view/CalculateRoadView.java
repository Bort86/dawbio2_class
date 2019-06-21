
package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.TravelTimeCalculator;

/**
 * Método para mostrar la vista del cálculo de distancia
 * Como no es dinámico de acuerdo a una tabla preexistente, es más sencillo
 * @author Pablo Rodriguez
 */
public class CalculateRoadView extends JPanel {
    public JLabel resultCal, distance, roadName;
    public JTextField txtResultCal, txtDistance;
    public JComboBox select;
    public JButton calDistance;

    public CalculateRoadView(TravelTimeCalculator model) {
        //genero el tamaño del panel
        setLayout(new GridLayout(10,2));
        
        //genero el select
        roadName = new JLabel("Type of Road: ");
        String [] roadOptions = model.getRoadTypes();
        select = new JComboBox(roadOptions);
        
        //label y textfield de distancia
        distance = new JLabel("Distance to be made: ");
        txtDistance = new JTextField(10);
        
        //label y textfield de resultado
        resultCal = new JLabel("Result: ");
        txtResultCal = new JTextField(10);
        txtResultCal.setEditable(false);

        //botón para calcularlo
        calDistance = new JButton();
        calDistance.setText("Calculate"); //para hacer no editable este campo
        
        //finalmente se añade todo al panel
        add(roadName);
        add(select);
        add(distance);
        add(txtDistance);
        add(resultCal);
        add(txtResultCal);
        add(calDistance);
    }
    
}
