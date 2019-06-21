package controllers;

import java.sql.SQLException;
import java.util.List;
import model.Friend;
import model.Model;
import views.FriendView;

public class FriendController {

    private final Model model;
    private FriendView view;

    public FriendController(Model model) throws ClassNotFoundException, SQLException {
        this.model = model;
        this.view = new FriendView(this, model);
        view.display();
    }

    public void exitApplication() {
        System.exit(0);
    }

    /**
     * Processes requests from the view.
     *
     * @param action to execute.
     */
    public void executeAction(String action) throws ClassNotFoundException, SQLException {
        switch (action) {
            case "exit":
                exitApplication();
                break;
            case "find_by_id":
                findByID();
                break;
            case "find_by_phone":
                findByPhone();
                break;
            case "add_friend":
                addFriend();
                break;
            case "update_friend":
                updateFriend();
                break;
            case "delete_friend":
                deleteFriend();
                break;
            default:
                view.showMessage("Wrong option");
                break;
        }
    }

    /**
     * Asks the user for an id in order to find a friend. Then looks for the
     * friend in the database and shows them.
     *
     * @throws java.lang.ClassNotFoundException
     */
    public void findByID() throws ClassNotFoundException {
        try {
            long id = Long.parseLong(view.showInputDialog("Input id:"));
            Friend f = model.findById(id);
            if (f != null) {
                view.showFriendForm(f);
            } else {
                view.showMessage("Friend not found");
            }
        } catch (NumberFormatException nfe) {
            view.showMessage("Error reading id: " + nfe.getMessage());
        }
    }

    private void findByPhone() throws ClassNotFoundException {
        try {
            String phone = view.showInputDialog("Input phone:");
            List<Friend> f = model.findByPhone(phone);
            if (f != null) {
                for (Friend friend : f) {
                    view.showFriendForm(friend);
                }

            } else {
                view.showMessage("Friend not found");
            }
        } catch (NumberFormatException nfe) {
            view.showMessage("Error reading id: " + nfe.getMessage());
        }

    }

    private void addFriend() throws ClassNotFoundException, SQLException {
        try {
            
            String title = view.showInputDialog("Input title:");
            int length = Integer.parseInt(view.showInputDialog("Input length:"));
            String country = view.showInputDialog("Input country:");
            String genre = view.showInputDialog("Input age:");
            int age = Integer.parseInt(view.showInputDialog("Input age:"));
            double rating = Double.parseDouble(view.showInputDialog("Input rating:"));;
            String sinopsis = view.showInputDialog("Input sinopsis:");;
            

            Friend f = new Friend(name, address, phone, age);

            int result_insert = model.addFriend(f);
            if (result_insert != 0) {
                view.showMessage("Friend inserted");
            } else {
                view.showMessage("Friend not inserted");
            }
        } catch (NumberFormatException nfe) {
            view.showMessage("Error :" + nfe.getMessage());
        }
    }

    private void updateFriend() {
        try {
            long id = Long.parseLong(view.showInputDialog("Input id to search:"));
            Friend f = model.findById(id);
            if (f != null) {
                String name = view.showInputDialog("Input new name:");
                String address = view.showInputDialog("Input new address:");
                String phone = view.showInputDialog("Input new phone:");
                int age = Integer.parseInt(view.showInputDialog("Input new age:"));

                f.setName(name);
                f.setAddress(address);
                f.setPhone(phone);
                f.setAge(age);

                int resultUpdate = model.updateFriend(f);
                if (resultUpdate != 0) {
                    view.showMessage("Friend updated ok");
                } else {
                    view.showMessage("Friend not updated");
                }

            } else {
                view.showMessage("Friend not found");
            }
        } catch (Exception nfe) {
            view.showMessage("Error: " + nfe.getMessage());
        }
    }

    private void deleteFriend() throws ClassNotFoundException {
        try {
            long id = Long.parseLong(view.showInputDialog("Input id to delete:"));
            Friend f = model.findById(id);
            if (f != null) {
                int resultDelete = model.deleteFriend(f);
                if (resultDelete != 0) {
                    view.showMessage("Friend deleted ok");
                } else {
                    view.showMessage("Friend not deleted");
                }
                
            } else {
                view.showMessage("Friend not found");
            }
        } catch (Exception nfe) {
            view.showMessage("Error: " + nfe.getMessage());
        }
    }
}
