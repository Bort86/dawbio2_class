package examen;

import controller.WindowController;
import view.MainFrame;

/**
 * Main class for travel time calculator application.
 * This class is the entry point to the application.
 * @author Jose
 */
public class Main {

    public static void main(String[] args) {
        MainFrame menu = new MainFrame();
        WindowController wc = new WindowController(menu);
        wc.iniciarVista();
    }
    
}
