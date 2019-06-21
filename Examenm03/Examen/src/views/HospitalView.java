package views;

import controller.HospitalController;
import java.sql.SQLException;
import java.util.Scanner;
import model.Doctor;
import model.Model;
import model.Patient;

/**
 *
 * @author Pablo Rodriguez
 */
public class HospitalView {

    private final HospitalController control;
    private final Model model;
    private final HospitalMenu menu;

    public HospitalView(HospitalController control, Model model) {
        this.control = control;
        this.model = model;
        this.menu = new HospitalMenu();
    }
    
    public String showInputDialog(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void display() throws ClassNotFoundException, SQLException {
        do {
            menu.show();
            String action = menu.getSelectedOptionActionCommand();
            control.executeAction(action);           
        } while (true);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
    
    public void showPatientForm(Patient patient) {
        System.out.println(patient.toString());
    }
    
    public void showDoctorForm(Doctor doctor) {
        System.out.println(doctor.toString());
    }

}
