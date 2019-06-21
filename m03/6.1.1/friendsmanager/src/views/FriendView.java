package views;

import controllers.FriendController;
import java.sql.SQLException;
import model.Friend;
import model.Model;
import java.util.Scanner;

public class FriendView {

    private final FriendController control;
    private final Model model;
    private final FriendMenu menu;

    public FriendView(FriendController control, Model model) {
        this.control = control;
        this.model = model;
        this.menu = new FriendMenu();
    }

    public String showInputDialog(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Displays a message.
     * @param message to display
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays a form with data of friend f.
     * @param f friend to show
     */
    public void showFriendForm(Friend f) {
        System.out.println(f.toString());
    }

    /**
     * Shows the view.
     */
    public void display() throws ClassNotFoundException, SQLException {
        do {
            menu.show();
            String action = menu.getSelectedOptionActionCommand();
            control.executeAction(action);           
        } while (true);
    }   
    
}//end of class
