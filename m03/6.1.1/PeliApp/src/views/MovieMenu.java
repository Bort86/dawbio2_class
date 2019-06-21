package views;

public class MovieMenu extends Menu {

    public MovieMenu() {
        super("Movies Manager main menu");
        addOption(new Option("Exit", "exit"));
        addOption(new Option("List All", "list_all"));
        addOption(new Option("Add movie", "add_movie"));
        addOption(new Option("Update movie", "update_movie"));
        addOption(new Option("Delete movie", "delete_movie"));
        addOption(new Option("Find by genre", "find_by_genre"));
        addOption(new Option("Find by age", "find_by_age"));
        addOption(new Option("List all screens", "list_screen"));
        addOption(new Option("List movies by screen", "list_movie"));
        addOption(new Option("Update screen", "update_screen"));
    }

}
