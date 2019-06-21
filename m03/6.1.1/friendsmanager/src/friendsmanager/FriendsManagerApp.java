package friendsmanager;



import controllers.FriendController;
import java.sql.SQLException;
import model.Model;

public class FriendsManagerApp {
    
    public static void main ( String[] args) throws ClassNotFoundException, SQLException {
    
        FriendsManagerApp myApp = new FriendsManagerApp();
        myApp.run(); 
    }

    private void run() throws ClassNotFoundException, SQLException {
        
        Model model = new Model();
        FriendController controller = new FriendController(model);
    }
    
}// end of class
