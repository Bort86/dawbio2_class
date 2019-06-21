package views;

public class FriendMenu extends Menu {

    public FriendMenu() {
        super("Friends Manager main menu");
        addOption(new Option("Exit","exit"));
        addOption(new Option("Find by Id","find_by_id"));
        addOption(new Option("Find by phone","find_by_phone"));
        addOption(new Option("Add friend","add_friend"));
        addOption(new Option("Update friend","update_friend"));
        addOption(new Option("Delete friend","delete_friend"));
    }
    
    
}
