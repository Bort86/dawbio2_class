package model;

import java.util.List;
import model.persistence.HospitalDAO;

/**
 * Class Model
 * It will function as an interface regarding all app functions
 * @author Pablo Rodriguez
 */
public class Model {

    public List<Patient> findByName(String name) throws ClassNotFoundException {
        HospitalDAO pd = new HospitalDAO();
        List<Patient> result = pd.findByName(name);
        return result;
    }

    public int addPatient(Patient p) throws ClassNotFoundException {
        HospitalDAO pd = new HospitalDAO();
        int result = pd.insert(p);
        return result;
    }

    public Patient findById(int id) throws ClassNotFoundException {
        HospitalDAO pd = new HospitalDAO();
        return pd.findById(id);
    }

    public int deleteMovie(Patient p) throws ClassNotFoundException {
        HospitalDAO pd = new HospitalDAO();
        int result = pd.delete(p);
        return result;
    }

    public List<Doctor> listAll() throws ClassNotFoundException {
        HospitalDAO pd = new HospitalDAO();
        List<Doctor> result = pd.listAll();
        return result;
    }

    public List<Patient> findPatbyDoc(String id) throws ClassNotFoundException {
        HospitalDAO pd = new HospitalDAO();
        List<Patient> result = pd.findPatbyDoc(id);
        return result;
    }
    
}
