package peliapp;

import controllers.MovieController;
import java.sql.SQLException;
import model.Model;

/**
 *
 * @author Pablo Rodriguez
 */
public class PeliApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PeliApp myApp= new PeliApp();
        myApp.run();
    }
    
    private void run() throws ClassNotFoundException, SQLException {
        Model model = new Model();
        MovieController controller = new MovieController(model);        
    }
    
}
