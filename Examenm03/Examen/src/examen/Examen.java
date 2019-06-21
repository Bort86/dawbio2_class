package examen;

import controller.HospitalController;
import model.Model;
import java.sql.SQLException;

/**
 *
 * @author Pablo Rodriguez
 */
public class Examen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Examen myApp = new Examen();
        myApp.run();
    }
    private void run() throws ClassNotFoundException, SQLException {
        
        Model model = new Model();
        HospitalController controller = new HospitalController(model);
    }
    
}
