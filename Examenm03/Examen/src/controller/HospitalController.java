package controller;

import java.sql.SQLException;
import java.util.List;
import model.Doctor;
import views.HospitalView;
import model.Model;
import model.Patient;

/**
 *
 * @author Pablo Rodriguez
 */
public class HospitalController {
    private final Model model;
    private HospitalView view;
    
    // constructor
    public HospitalController(Model model) throws ClassNotFoundException, SQLException {
        this.model = model;
        this.view = new HospitalView(this, model);
        view.display();
    }
    
    public void exitApplication() {
        System.exit(0);
    }
    
    /**
     * executeAction
     * It will work as a process request
     * @param action
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void executeAction(String action) throws ClassNotFoundException, SQLException {
        switch (action) {
            case "exit":
                exitApplication();
                break;
            case "search_patient":
                searchPatient();
                break;
            case "add_patient":
                addPatient();
                break;
            case "delete_patient":
                deletePatient();
                break;
            case "list_doctor":
                listAllDoc();
                break;
            case "find_pat":
                listAllPat();
                break;
            default:
                view.showMessage("Wrong option");
                break;
        }
    }

    /**
     * searchPatient()
     * Asks for patients name and search it in the database, 
     * then prints the results
     * @throws ClassNotFoundException 
     */
    private void searchPatient() throws ClassNotFoundException {
        try {
            String name = view.showInputDialog("Input patient name:");
            List<Patient> p = model.findByName(name);
            if (p != null) {
                for (Patient patient : p) {
                    view.showPatientForm(patient);
                }

            } else {
                view.showMessage("Patient not found");
            }
        } catch (NumberFormatException nfe) {
            view.showMessage("Error reading database: " + nfe.getMessage());
        }
    
    }

    /**
     * addPatient()
     * Asks for new patient info and adds it to db
     * @throws ClassNotFoundException 
     */
    private void addPatient() throws ClassNotFoundException {
        try {

            int idPaciente = Integer.parseInt(view.showInputDialog("Input id:"));
            String nom = view.showInputDialog("Input name:");
            String cognoms = view.showInputDialog("Input surnames:");
            int edat = Integer.parseInt(view.showInputDialog("Input age:"));
            String idDoctor = view.showInputDialog("Input idDoctor:");

            Patient p = new Patient(idPaciente, nom, cognoms, edat, idDoctor);

            int result_insert = model.addPatient(p);
            if (result_insert != 0) {
                view.showMessage("Patient inserted");
            } else {
                view.showMessage("Patient not inserted");
            }
        } catch (NumberFormatException nfe) {
            view.showMessage("Error in db:" + nfe.getMessage());
        }
    }

    /**
     * DeletePatient()
     * Asks for patient id then deletes it
     */
    private void deletePatient() {
        try {
            int id = Integer.parseInt(view.showInputDialog("Input id of patient to delete:"));
            Patient p = model.findById(id);
            if (p != null) {
                int resultDelete = model.deleteMovie(p);
                if (resultDelete != 0) {
                    view.showMessage("Patient deleted ok");
                } else {
                    view.showMessage("Patient not deleted");
                }

            } else {
                view.showMessage("Movie not found");
            }
        } catch (Exception nfe) {
            view.showMessage("Error: " + nfe.getMessage());
        }
    }

    /**
     * listAllDoc()
     * Lists all doctos in db
     */
    private void listAllDoc() {
        try {
            List<Doctor> d = model.listAll();
            if (d != null) {
                for (Doctor doctor : d) {
                    view.showDoctorForm(doctor);
                }
            } else {
                view.showMessage("There are no doctors");
            }
        } catch (Exception e) {
            view.showMessage("Error reading db: " + e.getMessage());
        }
    }

    /**
     * listAllPat()
     * Asks for doctor id then prints all patients that has this 
     * idDoctor associated
     * @throws ClassNotFoundException 
     */
    private void listAllPat() throws ClassNotFoundException {
        try {
            String id = view.showInputDialog("Input doctor id:");
            List<Patient> p = model.findPatbyDoc(id);
            if (p != null) {
                for (Patient patient : p) {
                    view.showPatientForm(patient);
                }

            } else {
                view.showMessage("Movie not found");
            }
        } catch (NumberFormatException nfe) {
            view.showMessage("Error reading id: " + nfe.getMessage());
        }
    }
    
}
