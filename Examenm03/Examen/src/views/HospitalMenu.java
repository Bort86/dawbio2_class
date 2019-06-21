package views;

/**
 *
 * @author Pablo Rodriguez
 */
public class HospitalMenu extends Menu {

    public HospitalMenu() {
        super("Movies Manager main menu");
        addOption(new Option("Exit", "exit"));
        addOption(new Option("Search patient", "search_patient"));
        addOption(new Option("Add patient", "add_patient"));
        addOption(new Option("Delete patient", "delete_patient"));
        addOption(new Option("List doctor", "list_doctor"));
        addOption(new Option("Find patients by doctor", "find_pat"));
    }
}
