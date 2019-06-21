
package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.TravelTimeCalculator;

/**
 *
 * @author Pablo Rodriguez
 */
public class ConfigRoadView extends JPanel {
    
    public JButton updateRoad, eraseRoadValues;
    public ArrayList<JLabel> names;
    public ArrayList<JTextField> valors;
    
    public ConfigRoadView(TravelTimeCalculator model) {
        //establecemos el tamaño del panel
        setLayout(new GridLayout(10, 2));
        
        //como esta vista será dinámica, he decidido guardar los nombres y 
        //valores de los JLabel y JTextField en un array de estos objetos
        names = new ArrayList<JLabel>();
        valors = new ArrayList<JTextField>();
        
        updateRoad = new JButton();
        updateRoad.setText("Update Roads");

        eraseRoadValues = new JButton();
        eraseRoadValues.setText("Erase imput values");
        
        //aquí se utiliza los datos del modelo para generar de forma dinámica 
        //la cantidad de labels y textfields
        String [] roads = model.getRoadTypes();
        for (String road : roads){
            JLabel name = new JLabel(road);
            JTextField valor = new JTextField(10);
            valor.setText(String.valueOf(model.getSpeedLimit(road)));
            names.add(name);
            valors.add(valor);
        }
        
        //finalmente una vez generados los añado uno a uno a la vista
        for (int i = 0; i < names.size(); i++){
            add(names.get(i));
            add(valors.get(i));   
        }
        
        add(updateRoad);
        add(eraseRoadValues);
        
    }
    
   
    

}
