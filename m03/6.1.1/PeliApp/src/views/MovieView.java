package views;

import controllers.MovieController;
import java.sql.SQLException;
import java.util.Scanner;
import model.Model;
import model.Movie;
import model.Screen;

/**
 *
 * @author Pablo Rodriguez
 */
public class MovieView {
    
    private final MovieController control;
    private final Model model;
    private final MovieMenu menu;

    public MovieView(MovieController control, Model model) {
        this.control = control;
        this.model = model;
        this.menu = new MovieMenu();
    }
    
    public String showInputDialog(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void display() throws ClassNotFoundException, SQLException {
        do {
            menu.show();
            String action = menu.getSelectedOptionActionCommand();
            control.executeAction(action);           
        } while (true);
    }

    public void showMovieForm(Movie movie) {
        System.out.println(movie.toString());
    }
    
    public void showScreenForm(Screen screen) {
        System.out.println(screen.toString());
    }
    
}
